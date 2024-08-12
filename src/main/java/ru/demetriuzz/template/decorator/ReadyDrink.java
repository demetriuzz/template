package ru.demetriuzz.template.decorator;

import java.math.BigDecimal;

/**
 * Готовый напиток
 */
public interface ReadyDrink {

    /**
     * Описание напитка
     */
    String description();

    /**
     * Стоимость одной порции
     */
    BigDecimal coast();

}
