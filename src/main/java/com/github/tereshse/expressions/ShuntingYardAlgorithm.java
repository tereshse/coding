package com.github.tereshse.expressions;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://en.wikipedia.org/wiki/Shunting-yard_algorithm
 * Calculator: http://www.meta-calculator.com/learning-lab/how-to-build-scientific-calculator/infix-to-postifix-convertor.php
 */
public class ShuntingYardAlgorithm {
    private static final ImmutableMap<String, Integer> OPERATOR_TOKEN_PRECEDENTE = ImmutableMap.of("*", 1,
            "/", 1,
            "-", 0,
            "+", 0,
            "^", 2);
    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";

    private static boolean isLowerOrEqualPrecedence(String op1, String op2) {
        return OPERATOR_TOKEN_PRECEDENTE.get(op1) <= OPERATOR_TOKEN_PRECEDENTE.get(op2);
    }


    public static String toPostfix(String expression) {
        StringTokenizer stringTokenizer = new StringTokenizer(expression);
        Queue<String> queue = Lists.newLinkedList();
        Stack<String> stack = new Stack<>();
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            if (StringUtils.isNumeric(token)) {
                queue.offer(token);
                continue;
            }
            if (OPERATOR_TOKEN_PRECEDENTE.containsKey(token)) {
                while (stack.size() > 0 && OPERATOR_TOKEN_PRECEDENTE.containsKey(stack.peek())
                        && isLowerOrEqualPrecedence(token, stack.peek())) {
                    queue.offer(stack.pop());
                }
                stack.push(token);
                continue;
            }
            if (token.equals(LEFT_PARENTHESIS)) {
                stack.push(token);
                continue;
            }
            if (token.equals(RIGHT_PARENTHESIS)) {
                while (!stack.peek().equals(LEFT_PARENTHESIS)) {
                    queue.offer(stack.pop());
                }
                stack.pop();
            }
        }
        while (stack.size() > 0) {
            queue.offer(stack.pop());
        }
        return Joiner.on(" ").join(queue);
    }
}
