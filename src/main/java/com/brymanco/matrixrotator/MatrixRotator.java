package com.brymanco.matrixrotator;

public class MatrixRotator implements IMatrixRotator {

    @Override
    public void rotate90(int[][] matrix) {
        for (int start = 0; start < matrix.length / 2; start++) {

            final int last = matrix.length - 1 - start;

            for (int ii = start; ii < last; ++ii) {
                int offset = ii - start;

                int first = matrix[start][ii];
                int second = matrix[last - offset][start];
                int third = matrix[last][last - offset];
                int forth = matrix[ii][last];

                matrix[start][ii] = second;
                matrix[last - offset][start] = third;
                matrix[last][last - offset] = forth;
                matrix[ii][last] = first;
            }
        }
    }

}
