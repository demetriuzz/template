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
            System.out.println(c1);
            System.out.println();
            Assertions.assertEquals(
                    "ClassWithInitBlock{currentYear=2021, cityName='Пермь', humanName='Вася'}", c1.toString());
        }
        {
            System.out.println("variant #2");
            ClassWithInitBlock c1 = new ClassWithInitBlock("Орёл", "Петя");
            System.out.println(c1);
            System.out.println();
            Assertions.assertEquals(
                    "ClassWithInitBlock{currentYear=2021, cityName='Орёл', humanName='Петя'}", c1.toString());
        }
        {
            System.out.println("variant #3");
            ClassWithInitBlock c1 = new ClassWithInitBlock("Сызрань");
            System.out.println(c1);
            System.out.println();
            Assertions.assertEquals(
                    "ClassWithInitBlock{currentYear=2021, cityName='Сызрань', humanName='Вася'}", c1.toString());
        }
    }

}
