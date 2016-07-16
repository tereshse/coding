package com.github.tereshse.expressions;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShuntingYardAlgorithmTest {

    @Test
    public void testInfixToPostfix() {
        assertThat(ShuntingYardAlgorithm.toPostfix("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3")).isEqualTo("3 4 2 * 1 5 - 2 ^ 3 ^ / +");
        assertThat(ShuntingYardAlgorithm.toPostfix("( 2 + 3 ) ^ ( 1 - 2 * 4 )")).isEqualTo("2 3 + 1 2 4 * - ^");
    }
}