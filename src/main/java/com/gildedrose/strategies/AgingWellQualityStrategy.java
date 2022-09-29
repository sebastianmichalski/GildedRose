package com.gildedrose.strategies;

import com.gildedrose.Item;

public class AgingWellQualityStrategy implements ItemQualityStrategy {

    @Override
    public void update(Item item) {
        item.setQuality(item.getQuality() + 1);
    }
}
