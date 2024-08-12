package ru.demetriuzz.template.decorator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ReadyDrinkTest {

    @Test
    void test1() {
        // первый напиток, без вкусняшек
        ReadyDrink drink1 = new ReadyDrinkN1();
        info(drink1);
        Assertions.assertEquals(10.5, drink1.coast().doubleValue());

        // второй напиток, несколько разных вкусняшек
        ReadyDrink drink2 = new ReadyDrinkN2();
        drink2 = new DrinkDecoratorN1(drink2);
        drink2 = new DrinkDecoratorN2(drink2);
        info(drink2);
        Assertions.assertEquals(16.1, drink2.coast().doubleValue());

        // третий напиток, несколько одинаковых вкусняшек
        ReadyDrink drink3 = new ReadyDrinkN3();
        drink3 = new DrinkDecoratorN1(drink3);
        drink3 = new DrinkDecoratorN1(drink3);
        drink3 = new DrinkDecoratorN2(drink3);
        drink3 = new DrinkDecoratorN3(drink3);
        info(drink3);
        Assertions.assertEquals(12.7, drink3.coast().doubleValue());
    }

    private void info(ReadyDrink drink) {
        System.out.printf("%s\n [%f]\n\n", drink.description(), drink.coast());
    }

}
