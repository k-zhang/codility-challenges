package com.algomind.codility.fastandcurious;

public class FastAndCurious {
    public int solution(int[] A) {
        int MOD = 1000000007;
        long total = 0;
        int[] S = new int[A.length];
        for (var i = 0 ; i < A.length ; i ++) {
            S[i] = A[A.length - 1] - A[i];
            total += S[i];
        }

        long s = total - S[0];
        long result = s;
        for(int i = 1 ; i < A.length ; i ++) {
            s = s - S[i] + (long) i * (A[i] - A[i - 1]);
            result = Math.min(result, s);
        }

        return (int)(result % MOD);
    }
}
