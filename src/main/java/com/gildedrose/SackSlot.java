package com.gildedrose;

import com.gildedrose.strategies.ItemQualityStrategy;
import com.gildedrose.strategies.ItemSellInStrategy;

public class SackSlot {

    private final com.gildedrose.Item item;
    private final ItemQualityStrategy itemQualityStrategy;
    private final ItemSellInStrategy sellInStrategy;

    public SackSlot(com.gildedrose.Item item, ItemQualityStrategy itemQualityStrategy, ItemSellInStrategy sellInStrategy) {
        this.item = item;
        this.itemQualityStrategy = itemQualityStrategy;
        this.sellInStrategy = sellInStrategy;
    }

    public Item getItem() {
        return item;
    }

    public void updateQuality() {
        itemQualityStrategy.update(item);
        sellInStrategy.update(item);
    }

    @Override
    public String toString() {
        return "SackSlot{" +
            "item=" + item +
            ", itemQualityStrategy=" + itemQualityStrategy +
            ", sellInStrategy=" + sellInStrategy +
            '}';
    }
}
