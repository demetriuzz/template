package ru.demetriuzz.template.decorator;

import java.math.BigDecimal;

public class ReadyDrinkN3 implements ReadyDrink {

    @Override
    public String description() {
        return "Напиток №3";
    }

    @Override
    public BigDecimal coast() {
        return BigDecimal.valueOf(7.3);
    }

}
