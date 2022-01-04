package com.algomind.codility.thecoderofrivia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TheCoderOfRiviaTest {
    private final TheCoderOfRivia solution = new TheCoderOfRivia();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[] expected, int[] A) {
        Assertions.assertArrayEquals(expected, solution.solution(A));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
//            Arguments.of(new int[]{1,2,3,4,1,1,1,3,2}, new int[]{0,2,3,4,1,1,1,3,1}),
            Arguments.of(new int[]{1,1,3,2,2,1,2,2,1}, new int[]{1,1,1,2,2,1,2,2,1})
        );
    }
}