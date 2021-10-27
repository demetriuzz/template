package ru.demetriuzz.template.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * проверка allMatch, anyMatch, noneMatch
 */
class MatchingTest {

    private final int[] digitArray = {1, 3, 5, 8, 10};

    @Test
    void t1() {
        final var allMatchStatus = Arrays.stream(digitArray).allMatch(p -> p > 0);
        Assertions.assertTrue(allMatchStatus);
        System.out.printf("allMatch, status %b%n", allMatchStatus);

        final var anyMatchStatus = Arrays.stream(digitArray).anyMatch(p -> p > 8);
        Assertions.assertTrue(anyMatchStatus);
        System.out.printf("anyMatch, status %b%n", anyMatchStatus);

        // !anyMatch = noneMatch

        final var noneMatchStatus = Arrays.stream(digitArray).noneMatch(p -> p > 8);
        Assertions.assertFalse(noneMatchStatus);
        System.out.printf("noneMatch, status %b%n", noneMatchStatus);
    }

}
