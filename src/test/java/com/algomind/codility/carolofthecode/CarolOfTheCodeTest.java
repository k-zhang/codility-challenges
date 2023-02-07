package com.algomind.codility.carolofthecode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CarolOfTheCodeTest {
    private final CarolOfTheCode carolOfTheCode = new CarolOfTheCode();

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void test(int expected, String[] A) {
        var result = carolOfTheCode.solution(A);
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(1, new String[]{"RGBW","GBRW"}),
                Arguments.of(4, new String[]{"WBGR","WBGR","WRGB","WRGB","RBGW"}),
                Arguments.of(2, new String[]{"RBGW","GBRW","RWGB","GBRW"}),
                Arguments.of(2, new String[]{"GBRW","RBGW","BWGR","BRGW"})
        );
    }
}