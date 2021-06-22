package com.algomind.codility.thefellowshipofthecode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TheFellowshipOfTheCodeTest {
    private final TheFellowshipOfTheCode solution = new TheFellowshipOfTheCode();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(String expected, String S, int K) {
        Assertions.assertEquals(expected, solution.solution(S, K));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("adcede", "decade", 4),
                Arguments.of("babbbbb", "bbbabbb", 2),
                Arguments.of("aaaaabrcdbr", "abracadabra", 15)
        );
    }
}