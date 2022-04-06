package com.gilded;

import junit.framework.TestCase;
import org.junit.Test;

public class TestGildedRoseUpdated extends TestCase {
    private GildedRoseUpdated app;

    @Test
    public void testDefaultItem() {
        //The quality of the item when it has been on sale for more than one day decreases 1
        Item[] items = new Item[]{new Item("Foo", 1, 2)};
        app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void testDefaultItem2() {
        //The quality of the item when less than one day old decreases 2
        Item[] items = new Item[]{new Item("Foo", 0, 2)};
        app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void testSulfurasItem() {
        //The Sufras item, being a legendary item, does not undergo any modification.
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        app = new GildedRoseUpdated(items);
        app.updateQuality();
        Item itemTest = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        assertEquals(itemTest.quality, app.items[0].quality);
        assertEquals(itemTest.sellIn, app.items[0].sellIn);
    }

    @Test
    public void testAgedBrieItem() {
        //The agedBrie item increases in quality by 1 unit over the course of days as long as it has not passed its sell-by date.
        Item[] items = new Item[]{new Item("Aged Brie", 1, 0)};
        app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void testAgedBrieItem2() {
        //After its date of sale agedBrie increments 2 units
        Item[] items = new Item[]{new Item("Aged Brie", 0, 0)};
        app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    //For the BackStage item there are 4 cases

    @Test
    public void testBackStageItem() {
        //Normally the BackStage item increases the same as the AgedBrie, one unit per day.
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 12, 0)};
        app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void testBackStageItem2() {
        //When there are 10 days or less left on sale, the quality of the BackStage item increases by 2 units.
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0)};
        app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void testBackStageItem3() {
        //When there are 5 days of sales or less left, the quality of the BackStage item increases by 3 units.
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0)};
        app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void testBackStageItem4() {
        //When the sale date expires the item quality drops to 0.
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void testConjuredMagicItem() {
        //When there is more than one day left on sale, the CounjuredMagic item decreases by 2 units.
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 1, 4)};
        app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void testConjuredMagicItem2() {
        //When the sale date expires, the quality of the item is reduced by twice what it already was, it means 4 units.
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 0, 5)};
        app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }
}
