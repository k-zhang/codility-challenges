package com.algomind.codility.carolofthecode;

import java.util.Arrays;

public class CarolOfTheCode {
    // Dynamic Programming
    public int solution (String[] A) {
        var dp = new int[4];

        dp[0] = colorMovesTowardsRight(A[0], 'R');
        dp[1] = colorMovesTowardsRight(A[0], 'G');
        dp[2] = colorMovesTowardsRight(A[0], 'B');
        dp[3] = colorMovesTowardsRight(A[0], 'W');

        var facingRight = new char[]{'R','G','B','W'};
        var newFacingRight = new char[4];

        for(int i = 1 ; i < A.length ; i ++) {
            calculateFacingRight(A[i], newFacingRight, facingRight);

            for(int j = 0 ; j < 4 ; j ++) {
                dp[j] += colorMovesTowardsRight(A[i], newFacingRight[j]);
            }

            facingRight = newFacingRight;
        }

        return Arrays.stream(dp).min().getAsInt();
    }

    private void calculateFacingRight(String tile, char[] newFacingRight, char[] facingLeft) {
        for(int i = 0 ; i < facingLeft.length ; i++) {
            var facingLeftTileIndex = getTileIndex(tile, facingLeft[i]);
            newFacingRight[i] = tile.charAt((facingLeftTileIndex + 2) % 4);
        }
    }

    private int colorMovesTowardsRight(String tile, char color) {
        int tileIndex = getTileIndex(tile, color);
        return Math.abs(tileIndex - 1);
    }

    private int getTileIndex(String tile, char color) {
        int tileIndex = 0;
        for(int i = 0; i < tile.length() ; i ++) {
            if(tile.charAt(i) == color) {
                tileIndex = i;
            }
        }
        return tileIndex;
    }
}
