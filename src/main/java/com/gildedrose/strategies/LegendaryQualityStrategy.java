package com.gildedrose.strategies;

import com.gildedrose.Item;

public class LegendaryQualityStrategy implements ItemQualityStrategy {

    @Override
    public void update(Item item) {
        item.setQuality(80);
    }
}
