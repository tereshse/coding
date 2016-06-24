package com.github.tereshse.arrays;

public final class RotateMatrix {

    public static int[][] rotateClockWise(int[][] matrix) {
        if (matrix == null ||
                matrix.length <= 0 ||
                matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Matrix should be NxN, where N > 0");
        } else {
            int layerCount = matrix.length / 2;
            int width = matrix.length - 1;

            for (int layer = 0; layer < layerCount; layer++) {
                for (int i = layer; i < width - layer; i++) {
                    int top = matrix[layer][i];
                    int left = matrix[width - i][layer];
                    int bottom = matrix[width - layer][width - i];
                    int right = matrix[i][width - layer];
                    //left - > top
                    matrix[layer][i] = left;
                    //bottom  - > left
                    matrix[width - i][layer] = bottom;
                    //right  - > bottom
                    matrix[width - layer][width - i] = right;
                    // top -> right
                    matrix[i][width - layer] = top;
                }
            }
            return matrix;
        }
    }
}
