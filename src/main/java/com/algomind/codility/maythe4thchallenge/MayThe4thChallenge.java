package com.algomind.codility.maythe4thchallenge;

import java.util.HashSet;
import java.util.Set;

public class MayThe4thChallenge {
    public int solution(int[] A, int L, int R) {
        int result = 0;

        Set<Integer> included = new HashSet<>();
        for(int i = 0 ; i < A.length ; i++) {
            if(A[i] != 0 && A[i] < L && !included.contains(A[i])) {
                result ++;
                included.add(A[i]);
                A[i] = 0;
            }
        }

        included.clear();
        for (int a : A) {
            if (a != 0 && a > R && !included.contains(a)) {
                result++;
                included.add(a);
            }
        }

        return result;
    }
}
