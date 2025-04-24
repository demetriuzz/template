package ru.demetriuzz.template.other;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class ProductBuyerTest {

    // список продуктов
    private final List<Integer> productIds = List.of(1, 2, 3);

    // покупатель
    private record Buyer(
            Integer buyerId,
            Integer productId
    ) {
    }

    // список покупок
    private final List<Buyer> shoppingList = List.of(
            new Buyer(10, 1),
            new Buyer(10, 1),
            new Buyer(20, 3),
            new Buyer(20, 1),
            new Buyer(30, 2),
            new Buyer(40, 3),
            new Buyer(40, 1),
            new Buyer(40, 2),
            new Buyer(50, 3),
            new Buyer(50, 1),
            new Buyer(60, 2),
            new Buyer(60, 3),
            new Buyer(70, 1),
            new Buyer(80, 1),
            new Buyer(80, 2),
            new Buyer(80, 2)
    );

    @Test
    @DisplayName("Поиск покупателя, который купил ВСЕ продукты")
    void productWinnerDetect() {
        // список покупателей
        final var buyerIds = shoppingList.stream().map(Buyer::buyerId).distinct().toList();
        System.out.printf("buyerIds=%s%n".formatted(buyerIds));

        buyerIds.forEach(id -> {
            final var distinct = shoppingList.stream()
                    .filter(f -> f.buyerId.equals(id))
                    .map(Buyer::productId)
                    .distinct()
                    .sorted()
                    .toList();

            if (productIds.equals(distinct)) {
                System.out.printf("Победитель по продуктам: %d%n".formatted(id));
            }
        });
    }

}
