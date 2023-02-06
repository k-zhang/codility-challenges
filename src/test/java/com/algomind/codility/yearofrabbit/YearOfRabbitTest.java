package com.algomind.codility.yearofrabbit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class YearOfRabbitTest {
    private final YearOfRabbit yearOfRabbit = new YearOfRabbit();

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void test(int expected, int[] A, int[] B) {
        var result = yearOfRabbit.solution(A, B);
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
            Arguments.of(2, new int[] {1,3,5,2,8,7}, new int[]{7,1,9,8,5,7}),
            Arguments.of(3, new int[] {1,3,5,1,8,7}, new int[]{7,1,9,8,1,7}),
            Arguments.of(-1, new int[] {1,1,1,1}, new int[]{1,2,3,4}),
            Arguments.of(0, new int[] {3,5,0,2,4}, new int[]{1,3,10,6,7})
        );
    }
}