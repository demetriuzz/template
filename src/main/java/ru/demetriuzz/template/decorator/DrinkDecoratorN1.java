package ru.demetriuzz.template.decorator;

import java.math.BigDecimal;

public class DrinkDecoratorN1 implements DrinkDecorator {

    private final ReadyDrink readyDrink;

    public DrinkDecoratorN1(ReadyDrink readyDrink) {
        this.readyDrink = readyDrink;
    }

    @Override
    public String description() {
        return "%s, %s".formatted(readyDrink.description(), "Вкусняшка №1");
    }

    @Override
    public BigDecimal coast() {
        return readyDrink.coast().add(BigDecimal.valueOf(1.25));
    }

}
