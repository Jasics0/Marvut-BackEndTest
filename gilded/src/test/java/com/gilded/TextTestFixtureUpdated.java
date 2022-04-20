package com.gilded;

import com.items.Item;
import com.facotry.FactoryItem;

public class TextTestFixtureUpdated {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");
        FactoryItem factory= new FactoryItem();
        Item[] items = new Item[] {
                factory.getItem ("+5 Dexterity Vest", 10, 20), //
                factory.getItem("Aged Brie", 2, 0), //
                factory.getItem("Elixir of the Mongoose", 5, 10), //
                factory.getItem("Sulfuras, Hand of Ragnaros", 0, 80), //
                factory.getItem("Sulfuras, Hand of Ragnaros", -1, 80),
                factory.getItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                factory.getItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                factory.getItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                factory.getItem("Conjured Mana Cake", 3, 10) };

        GildedRoseUpdated app = new GildedRoseUpdated(items);

        int days = 15;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
