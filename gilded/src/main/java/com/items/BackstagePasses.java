package com.items;

public class BackstagePasses extends Item{

    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void modifyItem() {
        decrementDay(1);
        if (this.sellIn<0){
            this.quality=0;
        }else{
            if (this.sellIn <= 5) { //If 5 days or less, increase by 3 units
                this.quality += 3;
            } else if (this.sellIn <= 10) { //If 10 days or less, increase by 2 units
                this.quality += 2;
            } else { //If more than 10 days to deadline, increase by 1 unit.
                this.quality += 1;
            }
        }
       verifyQuality();
    }
}
