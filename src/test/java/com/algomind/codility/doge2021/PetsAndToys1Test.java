package com.algomind.codility.doge2021;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PetsAndToys1Test {
    private final PetsAndToys1 petsAndToys1 = new PetsAndToys1();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(boolean expected, int[] P, int[] T, int[] A, int[] B) {
        Assertions.assertEquals(expected, petsAndToys1.solution(P, T, A, B));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(true, new int[]{1, 1, 2}, new int[]{2, 1, 1}, new int[]{0, 2}, new int[]{1, 1}),
                Arguments.of(false, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{0, 1, 2, 3}, new int[]{1, 2, 0, 4}),
                Arguments.of(false, new int[]{1, 1, 2, 2, 1, 1, 2, 2}, new int[]{1, 1, 1, 1, 2, 2, 2, 2}, new int[]{0, 2, 4, 6}, new int[]{1, 3, 5, 7}),
                Arguments.of(true, new int[]{2, 2, 2, 2, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 2, 2, 2, 2}, new int[]{0, 1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6, 7}),
                Arguments.of(true, new int[]{2, 2, 2, 2, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 2, 2, 2, 2}, new int[]{0, 1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6, 7}),
                Arguments.of(true, new int[]{2, 2, 1, 1, 1, 1}, new int[]{1, 1, 2, 2, 1, 1}, new int[]{0, 1, 2}, new int[]{1, 2, 3}),
                Arguments.of(false, new int[]{2, 2, 1, 1, 1, 1}, new int[]{1, 1, 2, 2, 2, 1}, new int[]{0, 1, 2}, new int[]{1, 2, 3}),
                Arguments.of(true, new int[]{1, 1, 1, 1, 2, 2, 2}, new int[]{2, 1, 2, 1, 2, 1, 1}, new int[]{0, 0, 1, 1, 3, 3}, new int[]{1, 2, 3, 4, 5, 6}),
                Arguments.of(false, new int[]{1, 1, 2, 1, 2, 1, 2, 2}, new int[]{2, 1, 2, 2, 1, 2, 1, 1}, new int[]{0, 0, 1, 1, 5, 5}, new int[]{1, 2, 3, 4, 6, 7}),
                Arguments.of(true, new int[]{1, 2, 2, 1, 2, 1, 1, 2}, new int[]{2, 1, 2, 2, 1, 2, 1, 1}, new int[]{0, 0, 1, 1, 5, 5}, new int[]{1, 2, 3, 4, 6, 7}),
                Arguments.of(true, new int[]{1, 2, 2, 1, 2, 1, 1, 2}, new int[]{2, 1, 2, 2, 1, 2, 1, 1}, new int[]{0, 0, 1, 1, 5, 5, 1}, new int[]{1, 2, 3, 4, 6, 7, 5}),
                Arguments.of(false, new int[]{1, 2, 2, 1, 2, 1, 1, 2}, new int[]{2, 1, 2, 2, 1, 2, 1, 1}, new int[]{0, 2, 4, 6}, new int[]{1, 3, 5, 7}),
                Arguments.of(false, new int[]{1, 2, 2, 1, 2, 1, 1, 2}, new int[]{2, 1, 2, 2, 1, 2, 1, 1}, new int[]{}, new int[]{})
        );
    }
}