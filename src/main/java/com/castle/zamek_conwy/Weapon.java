package com.castle.zamek_conwy;
public class Weapon {
    public int attack;
    public String texturePath;

    private static Weapon[] weapons = {
            new Weapon(0, "/assets/textures/mic/empty.png"),             // Weapon 1
            new Weapon(1, "/assets/textures/items/weapon1.png"),     // Weapon 2
            new Weapon(2, "/assets/textures/items/weapon2.png"),     // Weapon 3
            new Weapon(3, "/assets/textures/items/weapon3.png")      // Weapon 4
    };


    public Weapon () {
        this.attack = weapons[0].getAttack();
        this.texturePath = weapons[0].getTexturePath();
    }

    public Weapon(int attack, String texturePath) {
        this.attack = attack;
        this.texturePath = texturePath;
    }

    public int getAttack() {
        return attack;
    }

    public String getTexturePath() {
        return texturePath;
    }

    public Weapon getWeapon(int attack) {
        return weapons[attack];
    }

    public void setWeapon(int attack) {
        this.attack = attack;
        this.texturePath = weapons[attack].getTexturePath();
        //player4.inventory.getWeapon().setWeapon(3);
    }

}