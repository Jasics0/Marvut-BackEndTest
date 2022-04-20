package com.items;

public class ConjuredManaCakes extends Item {
    public ConjuredManaCakes(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void modifyItem() {
        decrementDay(1);
        decrementIncrementQuality(4, 2);
        verifyQuality();
    }
}
