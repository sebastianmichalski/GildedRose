package com.gildedrose.strategies;

import com.gildedrose.Item;

public class NormalQualityStrategy implements ItemQualityStrategy {

    @Override
    public void update(Item item) {
        int quality = item.getQuality();
        if (item.getSellIn() >= 0) {
            item.setQuality(quality - 1);
        } else {
            item.setQuality(quality - 2);
        }
    }
}
