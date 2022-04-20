package com.items;

public abstract class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    protected void decrementDay(int day){
        this.sellIn-=day;
    }

    protected void verifyQuality(){
        if (this.quality > 50) { // If the quality reaches 50, it is because it has reached its peak.
            this.quality = 50;
        }
        if (this.quality < 0) { //If the quality reaches 0, it is because it has reached its minimum point.
            this.quality = 0;
        }
    }

    protected void decrementIncrementQuality(int case1,int case2){
        if (this.sellIn<0){
            this.quality-=case1;
        }else{
            this.quality-=case2;
        }
    }

    public abstract void modifyItem();

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
