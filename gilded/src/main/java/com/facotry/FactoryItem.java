package com.facotry;

import com.items.*;

public class FactoryItem {
    public Item getItem(String name, int sellIn,int quality){
        switch (name) {
            case "Aged Brie":
                return new AgedBrie(name,sellIn,quality);
            case "Backstage passes to a TAFKAL80ETC concert":
               return new BackstagePasses(name,sellIn,quality);
            case "Conjured Mana Cake":
                return  new ConjuredManaCakes(name,sellIn,quality);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(name, sellIn, quality);
            default:
                return new Default(name,sellIn,quality);
        }
    }
}
