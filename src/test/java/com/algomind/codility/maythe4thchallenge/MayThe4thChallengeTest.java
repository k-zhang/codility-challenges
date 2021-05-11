package com.algomind.codility.maythe4thchallenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MayThe4thChallengeTest {
    private final MayThe4thChallenge mayThe4thChallenge = new MayThe4thChallenge();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] A, int L, int R) {
        Assertions.assertEquals(expected, mayThe4thChallenge.solution(A, L, R));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(3, new int[]{2, 3, 3, 4}, 3, 1),
                Arguments.of(4, new int[]{1, 4, 5, 5}, 6, 4),
                Arguments.of(4, new int[]{5, 2, 5, 2}, 8, 1),
                Arguments.of(2, new int[]{1, 5, 5}, 2, 4),
                Arguments.of(0, new int[]{1, 5, 5}, 1, 8),
                Arguments.of(0, new int[]{5, 5, 5, 5, 5}, 5, 5)
        );
    }
}