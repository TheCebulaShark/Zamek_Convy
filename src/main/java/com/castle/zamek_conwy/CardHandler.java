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
        COINS(1),
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

        int monsterChance = 85;
        if (randomNumber <= monsterChance) {
            type = Type.MONSTER;
            Enemies enemies = new Enemies();
            enemy = enemies.getRandomEnemy();
            cardDisplay.displayEnemyInfo(enemy);
        } else {
            randomNumber = random.nextInt(3);
            if (randomNumber == 0) {
                type = Type.COINS;
                int randomCoins = random.nextInt(3) + 1;
                player.character.setMoney(Math.min(player.character.getMoney() + randomCoins, 9));

                cardDisplay.displayCoins(randomCoins);
            }
            else {
                type = Type.ITEM;
                int randomItem = random.nextInt(2);
                if (randomItem == 0) {
                    Weapon weapon;
                    int randomWeapon = random.nextInt(4);

                    if (randomWeapon == 0) {
                        weapon = new Weapon(2, "/assets/textures/items/weapon2.png");
                    } else {
                        weapon = new Weapon(1, "/assets/textures/items/weapon1.png");
                    }

                    cardDisplay.displayWeaponInfo(weapon);
                    if (player.inventory.getWeapon().getAttack() < weapon.attack) {
                        player.inventory.setWeapon(weapon);
                    }
                } else {
                    Armor armor = new Armor();
                    int randomArmor = random.nextInt(4);
                    if (randomArmor == 0) {
                        cardDisplay.displayArmorInfo(armor.helmet, "Hełm");
                        player.inventory.setGotHelmet();
                    } else if (randomArmor == 1) {
                        cardDisplay.displayArmorInfo(armor.chestplate, "Zbroja");
                        player.inventory.setGotChestplate();
                    } else if (randomArmor == 2) {
                        cardDisplay.displayArmorInfo(armor.leggings, "Nogawice");
                        player.inventory.setGotLeggings();
                    } else {
                        cardDisplay.displayArmorInfo(armor.boots, "Buty");
                        player.inventory.setGotBoots();
                    }

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
