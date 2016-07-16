package com.github.tereshse.expressions;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EvaluatorTest {
    @Test
    public void testEvaluator(){
        assertThat(Evaluator.evaluate("2 2 +")).isEqualTo(4.0);
        assertThat(Evaluator.evaluate("2 3 + 10 2 4 * - ^")).isEqualTo(25.0);
    }
}