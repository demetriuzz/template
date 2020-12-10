package ru.demetriuzz.template.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromeString {

    @Test
    void doIt() {
        Assertions.assertFalse(verify1(null));
        Assertions.assertFalse(verify1(""));
        Assertions.assertFalse(verify1("   "));

        Assertions.assertTrue(verify1("12321"));
        Assertions.assertTrue(verify1("каЗак"));
        Assertions.assertTrue(verify1("trArt"));
        Assertions.assertFalse(verify1("qweasd"));
    }

    private boolean verify1(String in) {
        if (in == null || in.isEmpty() || in.isBlank()) return false;

        // ? trim()
        return in.equalsIgnoreCase(new StringBuilder(in).reverse().toString());
    }

}