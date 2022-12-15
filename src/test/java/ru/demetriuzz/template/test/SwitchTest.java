package ru.demetriuzz.template.test;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SwitchTest {

    @Test
    void switchTest() {
        assertEquals("один", switch1(1));
        assertEquals("два", switch1(2));
        assertEquals("три", switch1(3));
        assertEquals("много", switch1(4));

        // default в начале
        assertEquals("один", switch2(1));
        assertEquals("два", switch2(2));
        assertEquals("три", switch2(3));
        assertEquals("много", switch2(4));
    }

    private String switch1(int digit) {
        switch (digit) {
            case 1:
                return "один";
            case 2:
                return "два";
            case 3:
                return "три";
            default:
                return "много";
        }
    }

    private String switch2(int digit) {
        switch (digit) {
            default:
                return "много";
            case 1:
                return "один";
            case 2:
                return "два";
            case 3:
                return "три";
        }
    }

    @Test
    void returnTest() {
        // сортировка не гарантированна!
        assertEquals(-1, loop(Set.of(), Set.of()));
        assertEquals(0, loop(Set.of(1, 2, 3, 4, 5), Set.of(1, 2, 3, 4, 5)));
        assertEquals(-2, loop(Set.of(1, 10, 20, 30, 40), Set.of(1, 2, 3, 4, 5)));
        assertEquals(-3, loop(Set.of(1, 2, 3, 4, 5), Set.of(1, 10, 11, 12)));
    }

    Integer loop(Set<Integer> set1, Set<Integer> set2) {
        if (set1.isEmpty() || set2.isEmpty()) {
            return -1;
        }

        System.out.println("loop start");
        for (var s1 : set1) {
            System.out.printf("loop: [%d]%n", s1);
            if (s1 > 10) {
                return -2;
            }
            for (var s2 : set2) {
                System.out.printf("loop: [%d] [%d]%n", s1, s2);
                if (s2 > 10) {
                    return -3;
                }
            }
        }
        return 0;
    }

    @Test
    void equalTest() {
        {
            // A
            CharSequence sequence = new StringBuilder("привет");
            String string = "привет";

            assertNotEquals(sequence, string);
            assertEquals(sequence.toString(), string);
        }
        {
            // Б
            CharSequence sequence = "привет";
            String string = "привет";

            assertEquals(sequence, string);
        }
    }

}
