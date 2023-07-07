package com.castle.zamek_conwy;

import java.util.Random;

public class Item {

    private String texturePath;
    private int itemType;
    private int armorType;
    private Weapon weapon = new Weapon();
    private Armor.ArmorPart armor;

    public Item() {}

    public void generateItem() {
        Random random = new Random();
        this.itemType = random.nextInt(2);
        if(this.itemType == 0)
        {
            int rand = random.nextInt(10);
            if(rand <= 5)
            {
                this.weapon.setWeapon(1);
            }
            else if(rand <= 8)
            {
                this.weapon.setWeapon(2);
            }
            else
            {
                this.weapon.setWeapon(3);
            }
            texturePath = this.weapon.getTexturePath();
        }
        else
        {
            armorType = random.nextInt(4);
            Armor textureArmor = new Armor();
            if(armorType == 0)
            {
                this.armor = new Armor.ArmorPart(true, textureArmor.helmet.getTexturePath());
            }
            else if(armorType == 1)
            {
                this.armor = new Armor.ArmorPart(true, textureArmor.chestplate.getTexturePath());
            }
            else if(armorType == 2)
            {
                this.armor = new Armor.ArmorPart(true, textureArmor.leggings.getTexturePath());
            }
            else
            {
                this.armor = new Armor.ArmorPart(true, textureArmor.boots.getTexturePath());
            }
            texturePath = this.armor.getTexturePath();
        }
    }

    public String getTexturePath() {
        return texturePath;
    }

    public int getItemType() {
        return itemType;
    }

    public int getArmorType() {
        return armorType;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor.ArmorPart getArmor() {
        return armor;
    }
}
