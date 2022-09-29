package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.strategies.*;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GildedRoseTest {

    public static final AgingWellQualityStrategy AGING_WELL_QUALITY_STRATEGY = new AgingWellQualityStrategy();
    public static final AgingWellSellInStrategy AGING_WELL_SELL_IN_STRATEGY = new AgingWellSellInStrategy();
    public static final LegendaryQualityStrategy LEGENDARY_QUALITY_STRATEGY = new LegendaryQualityStrategy();
    public static final LegendarySellInStrategy LEGENDARY_SELL_IN_STRATEGY = new LegendarySellInStrategy();
    public static final NormalQualityStrategy NORMAL_QUALITY_STRATEGY = new NormalQualityStrategy();
    public static final NormalSellInStrategy NORMAL_SELL_IN_STRATEGY = new NormalSellInStrategy();

    @ParameterizedTest
    @MethodSource("itemsProvider")
    void test(SackSlot sackSlot, int expectedSellIn, int expectedQuality) {
        // When
        sackSlot.updateQuality();

        // Then
        assertEquals(expectedSellIn, sackSlot.getItem().getSellIn());
        assertEquals(expectedQuality, sackSlot.getItem().getQuality());
    }

    public static Stream<Arguments> itemsProvider() {
        return Stream.of(
            Arguments.of(new SackSlot(new Item("Aged Brie", 10, 20), AGING_WELL_QUALITY_STRATEGY, AGING_WELL_SELL_IN_STRATEGY), 9, 21),
            Arguments.of(new SackSlot(new Item("Aged Brie", 2, 0), AGING_WELL_QUALITY_STRATEGY, AGING_WELL_SELL_IN_STRATEGY), 1, 1),
            Arguments.of(new SackSlot(new Item("Sulfuras, Hand of Ragnaros", -1, 80), LEGENDARY_QUALITY_STRATEGY, LEGENDARY_SELL_IN_STRATEGY), -1, 80),
            Arguments.of(new SackSlot(new Item("Sulfuras, Hand of Ragnaros", 0, 80), LEGENDARY_QUALITY_STRATEGY, LEGENDARY_SELL_IN_STRATEGY), 0, 80),
            Arguments.of(new SackSlot(new Item("Elixir of the Mongoose", 5, 7), NORMAL_QUALITY_STRATEGY, NORMAL_SELL_IN_STRATEGY), 4, 6),
            Arguments.of(new SackSlot(new Item("Conjured Mana Cake", 3, 6), NORMAL_QUALITY_STRATEGY, NORMAL_SELL_IN_STRATEGY), 2, 5),
            Arguments.of(new SackSlot(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20), AGING_WELL_QUALITY_STRATEGY, AGING_WELL_SELL_IN_STRATEGY), 14, 21),
            Arguments.of(new SackSlot(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49), AGING_WELL_QUALITY_STRATEGY, AGING_WELL_SELL_IN_STRATEGY), 9, 50),
            Arguments.of(new SackSlot(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49), AGING_WELL_QUALITY_STRATEGY, AGING_WELL_SELL_IN_STRATEGY), 4, 50),
            Arguments.of(new SackSlot(new Item("+5 Dexterity Vest", 0, 20), NORMAL_QUALITY_STRATEGY, NORMAL_SELL_IN_STRATEGY), -1, 19)
        );
    }
}
