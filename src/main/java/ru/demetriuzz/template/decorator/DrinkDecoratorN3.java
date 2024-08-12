package ru.demetriuzz.template.decorator;

import java.math.BigDecimal;

public class DrinkDecoratorN3 implements DrinkDecorator {

    private final ReadyDrink readyDrink;

    public DrinkDecoratorN3(ReadyDrink readyDrink) {
        this.readyDrink = readyDrink;
    }

    @Override
    public String description() {
        return "%s, %s".formatted(readyDrink.description(), "Вкусняшка №3");
    }

    @Override
    public BigDecimal coast() {
        return readyDrink.coast().add(BigDecimal.valueOf(0.75));
    }

}
