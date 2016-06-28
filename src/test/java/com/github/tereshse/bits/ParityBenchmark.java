package com.github.tereshse.bits;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.Random;

public class ParityBenchmark {
    public static final int BATCH = 30000;

    @Benchmark
    public void fastParity(Data data) {
        for (long value : data.data) {
            Parity.fastParity(value);
        }
    }

    @Benchmark
    public void bruteParity(Data data) {
        for (long value : data.data) {
            Parity.bruteForceParity(value);
        }
    }

    @Benchmark
    public void precalulatedParity(Data data) {
        for (long value : data.data) {
            Parity.precalculatedParity(value);
        }
    }

    @State(Scope.Benchmark)
    public static class Data {
        private long[] data;

        @Setup(Level.Trial)
        public void setup() throws Exception {
            Random random = new Random();
            data = new long[BATCH];
            for (int i = 0; i < data.length; i++) {
                data[i] = random.nextLong();

            }
        }
    }

    public static void main(String[] args) throws RunnerException {
        new Runner(new OptionsBuilder()
                .include(ParityBenchmark.class.getName() + ".*")
                .forks(1)
                .warmupTime(TimeValue.seconds(1))
                .warmupIterations(2)
                .measurementTime(TimeValue.seconds(2))
                .measurementIterations(3)
                .build()).run();
    }
}
