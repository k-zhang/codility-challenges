package com.algomind.codility.thecoderofrivia;

public class TheCoderOfRivia {
    public int[] solution(int[] A) {
        var matrix = init(A);
        calculate(matrix);

        var target = findTarget(matrix);

        while(!finished(matrix, target)) {
            var adjustCell = findAdjustCell(matrix);
            adjustMatrix(adjustCell, matrix, target);
        }

        return flattenMatrix(matrix);
    }

    private boolean finished(int[][] matrix, int target) {
        for(int y = 1 ; y <=3 ; y ++) if(matrix[y][0] != target) return false;
        for(int x = 1 ; x <=3 ; x ++) if(matrix[0][x] != target) return false;
        return true;
    }

//    private void printMatrix(int[][] matrix) {
//        for(int y = 0 ; y <= 3 ; y ++) {
//            for(int x = 0 ; x <= 3 ; x ++) {
//                System.out.print(matrix[y][x] + "  ");
//            }
//            System.out.println();
//        }
//    }

    private void adjustMatrix(int[] adjustCell, int[][] matrix, int target) {
        var x = adjustCell[0];
        var y = adjustCell[1];

        var adjustValue = target - Math.max(matrix[y][0], matrix[0][x]);

        matrix[y][x] += adjustValue;
        calculate(matrix);
    }

    private int[] flattenMatrix(int[][] matrix) {
        var flatten = new int[9];
        for(var y = 1 ; y <= 3 ; y++) {
            for(var x = 1 ; x <= 3 ; x++) {
                flatten[(y - 1) * 3 + (x - 1)] = matrix[y][x];
            }
        }
        return flatten;
    }

    private int[] findAdjustCell(int[][] matrix) {
        var min = Integer.MAX_VALUE;
        var minY = -1;
        for(int y = 1 ; y <=3 ; y ++) {
            if(matrix[y][0] < min) {
                min = matrix[y][0];
                minY = y;
            }
        }

        min = Integer.MAX_VALUE;
        var minX = -1;
        for(int x = 1 ; x <= 3 ; x ++) {
            if(matrix[0][x] < min) {
                min = matrix[0][x];
                minX = x;
            }
        }

        return new int[]{minX, minY};
    }

    private int findTarget(int[][] matrix) {
        var max = -1;
        for(int x = 1 ; x <=3 ; x ++) max = Math.max(max, matrix[0][x]);
        for(int y = 1 ; y <=3 ; y ++) max = Math.max(max, matrix[y][0]);
        return max;
    }

    private int[][] init(int[] A) {
        int[][] matrix = new int[4][4];
        for(int y = 1 ; y <= 3 ; y ++) {
            for(int x = 1 ; x <= 3 ; x ++) {
                matrix[y][x] = A[(y-1) * 3 + (x-1)];
            }
        }
        return matrix;
    }

    private void calculate(int[][] matrix) {
        for(int y = 1 ; y <= 3 ; y ++) {
            var sum = 0;
            for(int x = 1 ; x <= 3 ; x ++) {
                sum += matrix[y][x];
            }
            matrix[y][0] = sum;
        }

        for(int x = 1 ; x <= 3 ; x ++) {
            var sum = 0;
            for(int y = 1 ; y <= 3 ; y ++) {
                sum += matrix[y][x];
            }
            matrix[0][x] = sum;
        }
    }
}
