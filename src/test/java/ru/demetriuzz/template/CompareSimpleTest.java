package ru.demetriuzz.template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CompareSimpleTest {

    @Test
    void compare() {
        final var so11 = SimpleObject.builder().id(10).name("имя 10").flag(true).coast(BigDecimal.ONE).build();
        final var so12 = SimpleObject.builder().id(10).name("имя 10").flag(true).coast(BigDecimal.ONE).build();
        Assertions.assertEquals(so12, so11);
        Assertions.assertEquals(so12.hashCode(), so11.hashCode());
        System.out.printf("1. so11.hash=%d, so12.hash=%d %n%n", so11.hashCode(), so12.hashCode());

        so12.setId(12);
        Assertions.assertNotEquals(so12, so11);
        Assertions.assertNotEquals(so12.hashCode(), so11.hashCode());
        System.out.printf("2. so11.hash=%d, so12.hash=%d %n%n", so11.hashCode(), so12.hashCode());

        final var so13 = SimpleObject.builder().id(12).name("имя 10").flag(true).coast(BigDecimal.ONE).build();
        Assertions.assertEquals(so13, so12);
        Assertions.assertEquals(so13.hashCode(), so12.hashCode());
        System.out.printf("3. so12.hash=%d, so13.hash=%d %n%n", so12.hashCode(), so13.hashCode());
    }

}
