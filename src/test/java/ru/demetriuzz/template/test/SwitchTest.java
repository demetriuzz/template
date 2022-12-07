package ru.demetriuzz.template.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SwitchTest {

    @Test
    void t1() {
        assertEquals("один", switch1(1));
        assertEquals("два", switch1(2));
        assertEquals("три", switch1(3));
        assertEquals("много", switch1(4));

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
        // default впереди
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
    void t2() {
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

}
