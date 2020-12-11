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

        Assertions.assertFalse(verify2(null));
        Assertions.assertFalse(verify2(""));
        Assertions.assertFalse(verify2("   "));

        Assertions.assertTrue(verify2("12321"));
        Assertions.assertTrue(verify2("каЗак"));
        Assertions.assertTrue(verify2("trArt"));
        Assertions.assertFalse(verify2("qweasd"));
    }

    private boolean verify1(String in) {
        if (in == null || in.isEmpty() || in.isBlank()) return false;

        // ? trim()
        return in.equalsIgnoreCase(new StringBuilder(in).reverse().toString());
    }


    private boolean verify2(String in) {
        if (in == null || in.isEmpty() || in.isBlank()) return false;

        return in.equalsIgnoreCase(reverseString(in));
    }

    private String reverseString(String str) {
        // остался один символ, начало процесса свертывания ..
        if (str.length() <= 1) return str;

        // строка с индекса 1 + первый символ (переворот)
        return reverseString(str.substring(1)) + str.charAt(0);
    }

}