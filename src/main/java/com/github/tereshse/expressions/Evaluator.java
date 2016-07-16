package com.github.tereshse.expressions;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.function.BiFunction;

public class Evaluator {
    private static final Map<String, BiFunction<Double, Double, Double>> OPERATIONS = ImmutableMap
            .of("^", (BiFunction<Double, Double, Double>) Math::pow,
                    "*", (BiFunction<Double, Double, Double>) (a, b) -> a * b,
                    "/", (BiFunction<Double, Double, Double>) (a, b) -> a / b,
                    "-", (BiFunction<Double, Double, Double>) (a, b) -> a - b,
                    "+", (BiFunction<Double, Double, Double>) (a, b) -> a + b);

    public static Double evaluate(String postfix) {
        StringTokenizer stringTokenizer = new StringTokenizer(postfix);
        Stack<Double> stack = new Stack<>();
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            if (StringUtils.isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                Double v2 = stack.pop();
                Double v1 = stack.pop();
                stack.push(OPERATIONS.get(token).apply(v1, v2));
            }
        }
        return stack.pop();
    }
}
