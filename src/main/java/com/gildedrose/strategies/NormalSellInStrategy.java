package com.gildedrose.strategies;

import com.gildedrose.Item;

public class NormalSellInStrategy implements ItemSellInStrategy {

    @Override
    public void update(Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }
}
