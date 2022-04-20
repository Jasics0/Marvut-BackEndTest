package com.items;

public class Default extends Item {
    public Default(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void modifyItem() {
        decrementDay(1);
        decrementIncrementQuality(2, 1);
        verifyQuality();
    }
}
