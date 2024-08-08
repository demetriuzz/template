package ru.demetriuzz.template.other;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShipCounterTest {

    /**
     * Поле для кораблей (аля "Морской бой") (частный случай, 6 на 6)
     */
    private final byte[][] matrix = new byte[][]{
            {1, 1, 0, 0, 1, 0}, // x=0
            {0, 0, 0, 0, 1, 0},
            {1, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 0},
            {0, 0, 1, 0, 1, 1}  // x=5
    };

    /**
     * Задача: посчитать количество кораблей на поле<br>
     * Условие:<br>
     *  - поле это матрица X на Y;<br>
     *  - значения в ячейках матрицы 1 и 0;<br>
     *  - корабль это последовательность 1: либо по горизонтали, либо по вертикали;<br>
     *  - пустая ячейка это 0;<br>
     *  - корабли не должны стоять вплотную: должно быть расстояние в один 0, минимум.
     */
    @Test
    void shipCounter() {
        byte counter = 0;
        for (int y = 0; y < matrix.length; y++) {

            for (int x = 0; x < matrix[y].length; x++) {

                if (matrix[y][x] == 0) {
                    // System.out.printf("0 ==> %dx%d%n", y, x);
                    continue;
                }

                var right = x + 1;
                var down = y + 1;

                if (right < matrix[y].length
                        && down < matrix.length) {

                    if (matrix[y][right] == 0
                            && matrix[down][x] == 0) {
                        counter++;
                    }

                } else if (right == matrix[y].length
                        && down < matrix.length) {
                    if (matrix[y][x] == 1 && matrix[down][x] == 0) {
                        counter++;
                    }

                } else if (down == matrix.length
                        && right < matrix[y].length) {
                    if (matrix[y][x] == 1 && matrix[y][right] == 0) {
                        counter++;
                    }
                } else {
                    if (matrix[y][x] == 1) {
                        counter++;
                    }
                }

            }

        }
        Assertions.assertEquals(7, counter);
        //System.out.println(counter);
    }

}
