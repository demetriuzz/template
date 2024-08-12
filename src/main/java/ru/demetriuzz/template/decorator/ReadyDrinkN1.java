package ru.demetriuzz.template.decorator;

import java.math.BigDecimal;

public class ReadyDrinkN1 implements ReadyDrink {

    @Override
    public String description() {
        return "Напиток №1";
    }

    @Override
    public BigDecimal coast() {
        return BigDecimal.valueOf(10.5);
    }

}
