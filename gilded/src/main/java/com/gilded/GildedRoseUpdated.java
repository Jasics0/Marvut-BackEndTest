package com.gilded;

public class GildedRoseUpdated {
    Item[] items;

    public GildedRoseUpdated(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) { //Due to the immutability of the item it is discarded.
                item.sellIn -= 1;
                if (item.sellIn < 0) {
                    switch (item.name) {
                        case "Aged Brie":
                            item.quality += 2; //Increases by 2 when the deadline expires.
                            break;
                        case "Backstage passes to a TAFKAL80ETC concert":
                            item.quality = 0; //Drop to 0 when the deadline expires.
                            break;
                        case "Conjured Mana Cake":
                            item.quality -= 4; //Decreases by 4 when the deadline expires, because it decreases twice as much as it already did.
                            break;
                        default:
                            item.quality -= 2;//Decreases by 2 when the deadline expires.
                            break;
                    }
                } else {
                    switch (item.name) {
                        case "Aged Brie":
                            item.quality += 1; //Decrease by 1 each day.
                            break;
                        case "Backstage passes to a TAFKAL80ETC concert": //As long as the deadline has not yet expired
                            if (item.sellIn <= 5) { //If 5 days or less, increase by 3 units
                                item.quality += 3;
                            } else if (item.sellIn <= 10) { //If 10 days or less, increase by 2 units
                                item.quality += 2;
                            } else { //If more than 10 days to deadline, increase by 1 unit.
                                item.quality += 1;
                            }
                            break;
                        case "Conjured Mana Cake":
                            item.quality -= 2; //Decreases by 2 before the expiration of deadline.
                            break;
                        default:
                            item.quality -= 1; //Decreases by 1 before the expiration of deadline.
                            break;
                    }
                }
                if (item.quality > 50) { // If the quality reaches 50, it is because it has reached its peak.
                    item.quality = 50;
                }
                if (item.quality < 0) { //If the quality reaches 0, it is because it has reached its minimum point.
                    item.quality = 0;
                }
            }
        }
    }
}
