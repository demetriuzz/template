package ru.demetriuzz.template.decorator;

import java.math.BigDecimal;

public class DrinkDecoratorN2 implements DrinkDecorator {

    private final ReadyDrink readyDrink;

    public DrinkDecoratorN2(ReadyDrink readyDrink) {
        this.readyDrink = readyDrink;
    }

    @Override
    public String description() {
        return "%s, %s".formatted(readyDrink.description(), "Вкусняшка №2");
    }

    @Override
    public BigDecimal coast() {
        return readyDrink.coast().add(BigDecimal.valueOf(2.15));
    }

}
