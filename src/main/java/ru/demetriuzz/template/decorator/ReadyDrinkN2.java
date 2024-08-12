package ru.demetriuzz.template.decorator;

import java.math.BigDecimal;

public class ReadyDrinkN2 implements ReadyDrink {

    @Override
    public String description() {
        return "Напиток №2";
    }

    @Override
    public BigDecimal coast() {
        return BigDecimal.valueOf(12.7);
    }

}
