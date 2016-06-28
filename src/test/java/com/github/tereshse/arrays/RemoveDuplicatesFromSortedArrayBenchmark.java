package com.github.tereshse.arrays;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.Arrays;
import java.util.Random;

public class RemoveDuplicatesFromSortedArrayBenchmark {
    public static final int BATCH = 10000;

    @Benchmark
    public void fast(Data data) {
        RemoveDuplicatesFromSortedArray.removeDuplicatesFromSortedArray(data.data);
    }

    @Benchmark
    public void bruteForce(Data data) {
        RemoveDuplicatesFromSortedArray.bruteForceRemoveDuplicatesFromSortedArray(data.data);
    }


    @State(Scope.Benchmark)
    public static class Data {
        private int[] data;
        private int[] masterData;

        @Setup(Level.Trial)
        public void setupOnce() {
            Random random = new Random();
            masterData = new int[BATCH];
            for (int i = 0; i < masterData.length; i++) {
                masterData[i] = random.nextInt(BATCH / 10);
            }
            Arrays.sort(masterData);
        }

        @Setup(Level.Invocation)
        public void setup() throws Exception {
            data = Arrays.copyOf(masterData, masterData.length);
        }
    }

    public static void main(String[] args) throws RunnerException {
        new Runner(new OptionsBuilder()
                .include(RemoveDuplicatesFromSortedArrayBenchmark.class.getName() + ".*")
                .forks(1)
                .warmupTime(TimeValue.seconds(1))
                .warmupIterations(3)
                .measurementTime(TimeValue.seconds(2))
                .measurementIterations(5)
                .build()).run();
    }
}
