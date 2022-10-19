package ru.demetriuzz.template.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SwitchTest {

    @Test
    void t1() {
        Assertions.assertEquals("один", switch1(1));
        Assertions.assertEquals("два", switch1(2));
        Assertions.assertEquals("три", switch1(3));
        Assertions.assertEquals("много", switch1(4));

        Assertions.assertEquals("один", switch2(1));
        Assertions.assertEquals("два", switch2(2));
        Assertions.assertEquals("три", switch2(3));
        Assertions.assertEquals("много", switch1(4));
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

}
