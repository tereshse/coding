package com.github.tereshse.arrays;

import org.junit.Test;

import static com.github.tereshse.arrays.RotateMatrix.rotateClockWise;
import static org.assertj.core.api.Assertions.assertThat;

public class RotateMatrixTest {

    @Test
    public void test_rotate_clockwise_1x1_matrix() {
        int[][] array = new int[][]{{1}};
        rotateClockWise(array);
        assertThat(array[0]).containsExactly(1);
    }

    @Test
    public void test_rotate_clockwise_2x2_matrix() {
        int[][] array = new int[][]{{1, 2},
                {3, 4}};
        rotateClockWise(array);
        assertThat(array[0]).containsExactly(3, 1);
        assertThat(array[1]).containsExactly(4, 2);
    }

    @Test
    public void test_rotate_clockwise_3x3_matrix() {
        int[][] array = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},};
        rotateClockWise(array);
        assertThat(array[0]).containsExactly(7, 4, 1);
        assertThat(array[1]).containsExactly(8, 5, 2);
        assertThat(array[2]).containsExactly(9, 6, 3);
    }

    @Test
    public void test_rotate_clockwise_4x4_matrix() {
        int[][] array = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        rotateClockWise(array);
        assertThat(array[0]).containsExactly(13, 9, 5, 1);
        assertThat(array[1]).containsExactly(14, 10, 6, 2);
        assertThat(array[2]).containsExactly(15, 11, 7, 3);
        assertThat(array[3]).containsExactly(16, 12, 8, 4);

    }

    @Test
    public void test_rotate_clockwise_5x5_matrix() {
        int[][] array = new int[][]{{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        rotateClockWise(array);
        assertThat(array[0]).containsExactly(21, 16, 11, 6, 1);
        assertThat(array[1]).containsExactly(22, 17, 12, 7, 2);
        assertThat(array[2]).containsExactly(23, 18, 13, 8, 3);
        assertThat(array[3]).containsExactly(24, 19, 14, 9, 4);
        assertThat(array[4]).containsExactly(25, 20, 15, 10, 5);

    }

    @Test(expected = IllegalArgumentException.class)
    public void that_that_null_argument_cause_exception() {
        rotateClockWise(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void that_that_zero_size_matrix_argument_cause_exception() {
        rotateClockWise(new int[0][0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void that_that_zero_non_square_matrix_argument_cause_exception() {
        rotateClockWise(new int[1][2]);
    }

}