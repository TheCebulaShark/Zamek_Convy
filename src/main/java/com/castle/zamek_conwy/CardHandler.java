package com.castle.zamek_conwy;

import java.util.Random;
import javafx.scene.image.Image;

public class CardHandler {
    private String name;
    private Type type;
    private Image texture;
    private Enemies.Enemy enemy;
    private CardDisplay cardDisplay;
    public enum Type{
        MONSTER(0),
        EVENT(1),
        ITEM(2);

        private final int value;

        Type(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    public CardHandler(String name) {
        this.name = name;
    }
    public CardHandler(String name, String texturePath) {
        this.name = name;
        this.texture = new Image(texturePath);
    }
    public void drawCard(Player player) {
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        cardDisplay = new CardDisplay();

        int monsterChance = 90;
        if (randomNumber <= monsterChance) {
            type = Type.MONSTER;
            Enemies enemies = new Enemies();
            enemy = enemies.getRandomEnemy();
            cardDisplay.displayEnemyInfo(enemy);
        } else {
            type = Type.ITEM;
            int randomItem = random.nextInt(7) + 1;
            if (randomItem <= 3) {
                Weapon weapon;
                if (randomItem == 1) {
                    weapon = new Weapon(1, "/assets/textures/items/weapon1.png");
                } else if (randomItem == 2) {
                    weapon = new Weapon(2, "/assets/textures/items/weapon2.png");
                } else {
                    weapon = new Weapon(3, "/assets/textures/items/weapon3.png");
                }
                cardDisplay.displayWeaponInfo(weapon);
                if(player.inventory.getWeapon().getAttack() < weapon.attack) {
                    player.inventory.setWeapon(weapon);
                }
            } else {
                Armor armor = new Armor();
                if (randomItem == 4) {
                    cardDisplay.displayArmorInfo(armor.helmet, "Hełm");
                    player.inventory.setGotHelmet();
                } else if (randomItem == 5) {
                    cardDisplay.displayArmorInfo(armor.chestplate, "Zbroja");
                    player.inventory.setGotChestplate();
                } else if (randomItem == 6) {
                    cardDisplay.displayArmorInfo(armor.leggings, "Nogawice");
                    player.inventory.setGotLeggings();
                } else {
                    cardDisplay.displayArmorInfo(armor.boots, "Buty");
                    player.inventory.setGotBoots();
                }

            }
        }
    }
    public Type getType() {
        return type;
    }
    public Image getTexture() {
        return texture;
    }
    public String getName() {
        return name;
    }
    public CardDisplay getCardDisplay() {
        return cardDisplay;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Enemies.Enemy getEnemy(){
        return this.enemy;
    }
}
