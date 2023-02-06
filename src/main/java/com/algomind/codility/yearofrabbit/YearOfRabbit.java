package com.algomind.codility.yearofrabbit;

public class YearOfRabbit {
    public int solution(int[] A, int[] B) {
        var dp = new boolean[B.length][A.length];

        for(int i = 0 ; i < B.length ; i ++) {
            for(int j = 0 ; j < A.length ; j++) {
                dp[i][j] = A[j] != B[i];
            }
        }

        for(int a = 0 ; a < A.length ; a ++) {
            boolean satisfied = true;

            int b = 0, i = a;
            for(int j = 0 ; j < A.length ; j ++) {
                int x = i++ % A.length;
                int y = b++;

                if (!dp[y][x]) {
                    satisfied = false;
                    break;
                }
            }

            if(satisfied) {
                return a;
            }
        }

        return -1;
    }
}
