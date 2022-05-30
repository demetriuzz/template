package ru.demetriuzz.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassWithInitBlock {

    private static final Logger logger = LoggerFactory.getLogger(ClassWithInitBlock.class);
    private static final int CURRENT_YEAR;
    private String cityName;
    private String humanName;

    static {
        logger.info("[run static block]");
        CURRENT_YEAR = 2021;
    }

    {
        logger.info("[run block]");
        // currentYear можно здесь, но тогда это значение перекроет значение из блока static
        cityName = "Пермь";
        humanName = "Вася";
    }

    public ClassWithInitBlock() {
        logger.info("[run empty constructor]");
    }

    public ClassWithInitBlock(String cityName, String humanName) {
        logger.info("[run constructor #1]");
        this.cityName = cityName;
        this.humanName = humanName;
    }

    public ClassWithInitBlock(String cityName) {
        logger.info("[run constructor #2]");
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "ClassWithInitBlock{" +
                "currentYear=" + CURRENT_YEAR +
                ", cityName='" + cityName + '\'' +
                ", humanName='" + humanName + '\'' +
                '}';
    }

}
