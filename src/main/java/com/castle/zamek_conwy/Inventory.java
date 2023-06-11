package com.castle.zamek_conwy;


public class Inventory {
    private Weapon weapon;
    private Armor armor;

    public Inventory() {
        this.weapon = new Weapon();
        this.armor = new Armor();
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setGotChestplate() {
        this.armor.chestplate.setOwned(true);
    }

    public void setGotLeggings() {
        this.armor.leggings.setOwned(true);
    }

    public void setGotBoots() {
        this.armor.boots.setOwned(true);
    }

    public void setGotHelmet() {
        this.armor.helmet.setOwned(true);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }
}
