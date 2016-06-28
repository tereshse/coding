package com.github.tereshse.bits;

import org.junit.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;


public class ParityTest {

    @Test
    public void testFastParity() {
        test(Parity::fastParity);
    }

    @Test
    public void testBruteForceParity() {
        test(Parity::bruteForceParity);
    }

    @Test
    public void testPrecalculatedParity() {
        test(Parity::precalculatedParity);
    }

    private void test(Function<Long, Boolean> implementation) {
        assertThat(implementation.apply(0L)).isFalse();
        assertThat(implementation.apply(1L)).isTrue();
        assertThat(implementation.apply(2L)).isTrue();
        assertThat(implementation.apply(3L)).isFalse();
        assertThat(implementation.apply(-1L)).isFalse();
    }
}