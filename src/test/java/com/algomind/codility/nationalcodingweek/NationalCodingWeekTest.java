package com.algomind.codility.nationalcodingweek;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NationalCodingWeekTest {
    private final NationalCodingWeek solution = new NationalCodingWeek();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(String expected, String S) {
        Assertions.assertEquals(expected, solution.solution(S));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of("baaaa", "ababb"),
            Arguments.of("babaaaa", "abbbabb"),
            Arguments.of("aaabab", "aaabab"),
            Arguments.of("ab", "ab"),
            Arguments.of("baa", "abb"),
            Arguments.of("bababaa", "abbbbbb"),
            Arguments.of("bababababaa", "abbbbbbbbbb")
        );
    }
}