package com.github.tereshse.arrays;

import com.google.common.collect.Lists;

import java.util.List;


public class SpiralMatrixTraverse {
    /**
     * Traverse square matrix by spiral staring top left corner.
     * @param matrix a matrix
     * @return traversal list
     */
    public static List<Integer> traverse(int[][] matrix) {
        if (matrix == null ||
                matrix.length <= 0 ||
                matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Matrix should be NxN, where N > 0");
        } else {
            List<Integer> traverse = Lists.newArrayListWithCapacity(matrix.length * matrix.length);
            int tx = 0, ty = 0, bx = matrix.length - 1, by = matrix.length - 1;
            while (traverseTopSide(matrix, tx, ty++, bx, by, traverse) &&
                    traverseRightSide(matrix, tx, ty, bx--, by, traverse) &&
                    traverseBottomSide(matrix, tx, ty, bx, by--, traverse) &&
                    traverseLeftSide(matrix, tx++, ty, bx, by, traverse)) ;
            return traverse;
        }
    }

    private static boolean traverseLeftSide(int[][] array, int top, int ty, int bx, int by, List<Integer> traverse) {
        for (int i = by; i >= ty; i--) {
            traverse.add(array[i][top]);
        }
        return top + 1 <= bx && ty <= by;
    }

    private static boolean traverseBottomSide(int[][] array, int tx, int ty, int bx, int by, List<Integer> traverse) {
        for (int i = bx; i >= tx; i--) {
            traverse.add(array[by][i]);
        }
        return tx <= bx && ty <= by - 1;
    }

    private static boolean traverseRightSide(int[][] array, int tx, int ty, int bx, int by, List<Integer> traverse) {
        for (int i = ty; i <= by; i++) {
            traverse.add(array[i][bx]);
        }
        return tx <= bx + 1 && ty <= by;
    }

    private static boolean traverseTopSide(int[][] array, int tx, int ty, int bx, int by, List<Integer> traverse) {
        for (int i = tx; i <= bx; i++) {
            traverse.add(array[ty][i]);
        }
        return tx + 1 <= bx && ty <= by;
    }
}
