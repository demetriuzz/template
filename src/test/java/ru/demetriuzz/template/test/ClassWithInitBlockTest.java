package ru.demetriuzz.template.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.demetriuzz.template.ClassWithInitBlock;

class ClassWithInitBlockTest {

    @Test
    void init1() {
        {
            System.out.println("variant #1");
            ClassWithInitBlock c1 = new ClassWithInitBlock();
            final var res = c1.toString();
            System.out.printf("%s\n\n", res);
            Assertions.assertEquals(
                    "ClassWithInitBlock{currentYear=2021, cityName='Пермь', humanName='Вася'}", res);
        }
        {
            System.out.println("variant #2");
            ClassWithInitBlock c1 = new ClassWithInitBlock("Орёл", "Петя");
            final var res = c1.toString();
            System.out.printf("%s\n\n", res);
            Assertions.assertEquals(
                    "ClassWithInitBlock{currentYear=2021, cityName='Орёл', humanName='Петя'}", res);
        }
        {
            System.out.println("variant #3");
            ClassWithInitBlock c1 = new ClassWithInitBlock("Сызрань");
            final var res = c1.toString();
            System.out.printf("%s\n\n", res);
            Assertions.assertEquals(
                    "ClassWithInitBlock{currentYear=2021, cityName='Сызрань', humanName='Вася'}", res);
        }
    }

}
