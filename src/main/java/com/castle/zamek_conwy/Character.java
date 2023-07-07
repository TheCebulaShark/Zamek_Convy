package com.castle.zamek_conwy;

public class Character {

    private static Character[] characterStats = {
            new Character(3, 3, 5),    // Character 1
            new Character(3, 4, 0),    // Character 2
            new Character(4, 3, 2),    // Character 3
            new Character(2, 3, 9)     // Character 4
    };

    private int health;
    private int attack;
    private int money;
    public Color color;

    public enum Color {
        YELLOW(0),
        LIMEGREEN(1),
        DEEPSKYBLUE(2),
        RED(3);

        private final int value;

        private Color(int value) {
            this.value = value;
        }

        public int getColor() {
            return value;
        }
    }

    public Character(int character_type, Color color) {
        this.color = color;

        if (character_type >= 1 && character_type <= characterStats.length) {
            Character selectedCharacter = characterStats[character_type - 1];
            this.attack = selectedCharacter.attack;
            this.health = selectedCharacter.health;
            this.money = selectedCharacter.money;
        }
        else {
            this.attack = 0;
            this.health = 0;
            this.money = 0;
        }
    }

    public Character(int health, int attack, int money) {
        this.attack = attack;
        this.health = health;
        this.money = money;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getMoney() {
        return money;
    }

    public Color getColor() {
        return color;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
