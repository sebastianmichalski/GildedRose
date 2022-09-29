package com.gildedrose.strategies;

import com.gildedrose.Item;

public class LegendarySellInStrategy implements ItemSellInStrategy {

    @Override
    public void update(Item item) {
        int sellIn = item.getSellIn();
        if (sellIn > 0) {
            item.setSellIn(sellIn - 1);
        }
    }
}
