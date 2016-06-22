package com.github.tereshse.bits;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.Random;

public class ConvertBenchmark {
    public static final int BATCH = 30000;

    @Benchmark
    public void convertToBitString(Data data) {
        for (int value : data.data) {
            Convert.toBitString(value);

        }
    }

    @Benchmark
    public void referenceImplementation(Data data) {
        for (int value : data.data) {
            Integer.toBinaryString(value);
        }
    }

    @State(Scope.Benchmark)
    public static class Data {
        private int[] data;

        @Setup(Level.Trial)
        public void setup() throws Exception {
            Random random = new Random();
            data = new int[BATCH];
            for (int i = 0; i < data.length; i++) {
                data[i] = random.nextInt();

            }
        }
    }

    public static void main(String[] args) throws RunnerException {
        new Runner(new OptionsBuilder()
                .include(ConvertBenchmark.class.getName() + ".*")
                .forks(1)
                .warmupTime(TimeValue.seconds(3))
                .warmupIterations(3)
                .measurementTime(TimeValue.seconds(3))
                .measurementIterations(5)
                .build()).run();
    }
}
