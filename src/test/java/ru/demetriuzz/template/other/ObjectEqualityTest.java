package ru.demetriuzz.template.other;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Методы <code>equals()</code> и <code>hashCode()</code> тесно связаны друг с другом.</br>
 * Переопределение этой пары методов должно быть <b>согласованно</b>.</br>
 * Переопределение <code>equals()</code> должно следовать правилам:
 * <ol>
 *     <li>Рефлексивность: равенство самому себе</li>
 *     <li>Симметричность: если A=B, то B=A</li>
 *     <li>Транзитивность: из трех объектов A, B и C C=A, если A=B, а B=C</li>
 *     <li>Согласованность: для заданных A и B повторные вызовы метода сравнения вернут одинаковый результат</li>
 *     <li>Сравнение с <code>null</code>: вызов метода сравнения с входным значением <code>null</code> возвращает <code>false</code></li>
 * </ol>
 * Переопределение <code>hashCode()</code> должно следовать правилам:
 * <ol>
 *     <li>Хэш-значение <u>неизменно</u>, при многократном вызове хэш-функции. При условии что объект остается неизменным</li>
 *     <li>Если объекты A и B равны, то хэш-значения этих объектов одинаковы</li>
 *     <li>Если объекты A и B не равны, то хэш-значения этих объектов так же не равны</li>
 * </ol>
 * Переопределение этих методов не является обязательным и должны быть <u>причины</u> их переопределения.</br>
 * Например, нет причин переопределять методы, если: экземпляр класса уникален; нет нужны сравнивать объекты; уже есть своя реализация методов; приватная область видимости.</br></br>
 * <p>
 * При переопределении метода <code>equals()</code> нужно помнить про согласованность с методом <code>compareTo()</code> интерфейса <code>Comparable</code>: т.е. <code>A.equals(B) == true</code> и <code>A.compareTo(B) == 0</code>
 */
public class ObjectEqualityTest {

    @Test
    void t1() {
        final var p1 = new Point1(1, 1);
        final var p2 = new Point1(1, 1);
        final var p3 = new Point1(1, 1);

        Assertions.assertEquals(p1, p1);
        Assertions.assertEquals(p2, p2);
        Assertions.assertEquals(p3, p3);

        Assertions.assertEquals(p1, p2);
        Assertions.assertEquals(p2, p1);
        Assertions.assertEquals(p1.hashCode(), p2.hashCode());

        Assertions.assertEquals(p2, p3);
        Assertions.assertEquals(p3, p2);
        Assertions.assertEquals(p2.hashCode(), p3.hashCode());

        Assertions.assertEquals(p1, p3);
        Assertions.assertEquals(p3, p1);
        Assertions.assertEquals(p1.hashCode(), p3.hashCode());
    }

    public record Point1(int x, int y) {
    }

    @Test
    void t2() {
        final var p1 = new PointOnlyX(1, 1);
        final var p2 = new PointOnlyX(1, 2);
        final var p3 = new PointOnlyX(1, 3);

        Assertions.assertEquals(p1, p1);
        Assertions.assertEquals(p2, p2);
        Assertions.assertEquals(p3, p3);

        Assertions.assertEquals(p1, p2);
        Assertions.assertEquals(p2, p1);
        Assertions.assertNotEquals(p1.hashCode(), p2.hashCode());

        Assertions.assertEquals(p2, p3);
        Assertions.assertEquals(p3, p2);
        Assertions.assertNotEquals(p2.hashCode(), p3.hashCode());

        Assertions.assertEquals(p1, p3);
        Assertions.assertEquals(p3, p1);
        Assertions.assertNotEquals(p1.hashCode(), p3.hashCode());
    }

    public record PointOnlyX(int x, int y) {
        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (this == o) return true;
            if (o.getClass() != this.getClass()) return false;
            final var o1 = (PointOnlyX) o;
            return this.x == o1.x;
            // поля `y` нет!
        }
    }

}