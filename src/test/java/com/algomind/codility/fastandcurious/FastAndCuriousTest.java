package com.algomind.codility.fastandcurious;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FastAndCuriousTest {
    private final FastAndCurious solution = new FastAndCurious();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] A) {
        Assertions.assertEquals(expected, solution.solution(A));
    }

    private static Stream<Arguments> provideData() {
        int KK = 5 * (int)Math.pow(10, 7);
        return Stream.of(
            Arguments.of(7, new int[]{1,5,9,12}),
            Arguments.of(0, new int[]{5,15}),
            Arguments.of(9, new int[]{2,6,7,8,12}),
            Arguments.of(499999972, new int[]{0,KK,2*KK,3*KK,4*KK,5*KK,6*KK,7*KK,8*KK,9*KK,10*KK,11*KK,12*KK,13*KK,14*KK,15*KK,16*KK,17*KK,18*KK,19*KK})
        );
    }
}