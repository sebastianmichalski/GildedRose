package com.gildedrose;

import com.gildedrose.strategies.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedRose {

    List<SackSlot> sackSlots;

    public GildedRose(com.gildedrose.Item[] items ) {
        this.sackSlots = Arrays.stream(items)
            .map(item -> new SackSlot(item, pickQualityStrategy(item), pickSellInStrategy(item)))
            .collect(Collectors.toList());
    }

    private ItemSellInStrategy pickSellInStrategy(com.gildedrose.Item item) {
        switch (item.getName()){
            case "Aged Brie":
            case "Backstage passes to a TAFKAL80ETC concert":
                return new AgingWellSellInStrategy();
            case "Sulfuras, Hand of Ragnaros":
                return new LegendarySellInStrategy();
            default:
                return new NormalSellInStrategy();
        }
    }

    private ItemQualityStrategy pickQualityStrategy(Item item) {
        switch (item.getName()){
            case "Aged Brie":
            case "Backstage passes to a TAFKAL80ETC concert":
                return new AgingWellQualityStrategy();
            case "Sulfuras, Hand of Ragnaros":
                return new LegendaryQualityStrategy();
            default:
                return new NormalQualityStrategy();
        }
    }

    public void updateQuality() {
        sackSlots.forEach(SackSlot::updateQuality);
    }
}
