package com.gilded;

import com.items.Item;

public class GildedRoseUpdated {
    Item[] items;

    public GildedRoseUpdated(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
                item.modifyItem();
    }
}}
