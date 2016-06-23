package com.github.tereshse.arrays;

import org.junit.Test;

import static com.github.tereshse.arrays.SpiralMatrixTraverse.traverse;
import static org.assertj.core.api.Assertions.assertThat;

public class SpiralMatrixTraverseTest {
    @Test
    public void test_traverse_1x1_matrix() {
        int[][] array = new int[][]{{1}};
        assertThat(traverse(array)).containsExactlyInAnyOrder(1);
    }

    @Test
    public void test_traverse_2x2_matrix() {
        int[][] array = new int[][]{{1, 2},
                                    {4, 3}};
        assertThat(traverse(array)).containsExactlyInAnyOrder(1, 2, 3, 4);
    }

    @Test
    public void test_traverse_3x3_matrix() {
        int[][] array = new int[][]{{1, 2, 3},
                                    {8, 9, 4},
                                    {7, 6, 5}
        };
        assertThat(traverse(array)).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void test_traverse_4x4_matrix() {
        int[][] array = new int[][]{{1,   2,  3, 4},
                                    {12, 13, 14, 5},
                                    {11, 16, 15, 6},
                                    {10,  9,  8, 7}
        };
        assertThat(traverse(array)).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
    }

    @Test(expected = IllegalArgumentException.class)
    public void that_that_null_argument_cause_exception() {
        traverse(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void that_that_zero_size_matrix_argument_cause_exception() {
        traverse(new int[0][0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void that_that_zero_non_square_matrix_argument_cause_exception() {
        traverse(new int[1][2]);
    }
}