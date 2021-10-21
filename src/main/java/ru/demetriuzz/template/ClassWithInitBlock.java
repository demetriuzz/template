package ru.demetriuzz.template;

public class ClassWithInitBlock {

    private static final int currentYear;
    private String cityName;
    private String humanName;

    static {
        System.out.println("[run static {}]");
        currentYear = 2021;
    }

    {
        System.out.println("[run {}]");
        // currentYear можно здесь, но тогда это значение перекроет значение из блока static
        cityName = "Пермь";
        humanName = "Вася";
    }

    public ClassWithInitBlock() {
        System.out.println("[run empty constructor]");
    }

    public ClassWithInitBlock(String cityName, String humanName) {
        System.out.println("[run constructor #1]");
        this.cityName = cityName;
        this.humanName = humanName;
    }

    public ClassWithInitBlock(String cityName) {
        System.out.println("[run constructor #2]");
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "ClassWithInitBlock{" +
                "currentYear=" + currentYear +
                ", cityName='" + cityName + '\'' +
                ", humanName='" + humanName + '\'' +
                '}';
    }

}
