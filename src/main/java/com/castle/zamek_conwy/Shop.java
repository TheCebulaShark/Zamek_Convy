package com.castle.zamek_conwy;
import java.util.Random;
public class Shop {
    private Item item1 = new Item();
    private Item item2 = new Item();
    private Item item3 = new Item();
    private int price1;
    private int price2;
    private int price3;
    private boolean isBought1;
    private boolean isBought2;
    private boolean isBought3;
    Random random = new Random();

    public Shop() {
        this.item1.generateItem();
        this.item2.generateItem();
        this.item3.generateItem();
        this.price1 = generatePrice(item1);
        this.price2 = generatePrice(item2);
        this.price3 = generatePrice(item3);
        this.isBought1 = false;
        this.isBought2 = false;
        this.isBought3 = false;
    }

    public int generatePrice(Item item){
        if(item.getItemType() == 0)
        {
            return random.nextInt(2) + 2 * item.getWeapon().getAttack() + 2;
        }
        else
        {
            return random.nextInt(3) + 5;
        }
    }

    public Item getItem1() {
        return item1;
    }

    public Item getItem2() {
        return item2;
    }

    public Item getItem3() {
        return item3;
    }

    public int getPrice1() {
        return price1;
    }

    public int getPrice2() {
        return price2;
    }

    public int getPrice3() {
        return price3;
    }

    public boolean isBought1() {
        return isBought1;
    }

    public void setBought1(boolean bought1) {
        isBought1 = bought1;
    }

    public boolean isBought2() {
        return isBought2;
    }

    public void setBought2(boolean bought2) {
        isBought2 = bought2;
    }

    public boolean isBought3() {
        return isBought3;
    }

    public void setBought3(boolean bought3) {
        isBought3 = bought3;
    }

    public void setItem1(Item item1) {
        this.item1 = item1;
        price1 = generatePrice(item1);
        this.isBought1 = false;
    }

    public void setItem2(Item item2) {
        this.item2 = item2;
        price2 = generatePrice(item2);
        this.isBought2 = false;
    }

    public void setItem3(Item item3) {
        this.item3 = item3;
        price3 = generatePrice(item3);
        this.isBought3 = false;
    }
}
