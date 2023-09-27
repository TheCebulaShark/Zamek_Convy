package com.castle.zamek_conwy;

//import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Player extends Character {
    private boolean isDead;
    private int position;
    public Character character;
    public Inventory inventory;
    private Image image;
    private String name;

    private int trophies;

    public Player(int characterType, Color color, boolean isDead, int position, String name) {
        super(characterType, color);
        this.isDead = isDead;
        this.character = this;
        this.inventory = new Inventory();
        this.position = position;
        this.name = name;
    }

    public void addBonusAttackOfTrophies() {
        if (this.trophies >= 7) {
            this.trophies = 0;
            if (this.character.getAttack() < 9)
                this.character.setAttack(this.character.getAttack() + 1);
        }
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    public boolean isDead() {
        return isDead;
    }

    public void setDead() {
        isDead = true;
        this.setAttack(0);
        this.setMoney(0);
    }

    public void playerGetItem(Item item) {
        if(item.getItemType() == 0)
        {
            if (this.inventory.getWeapon().getAttack() < item.getWeapon().attack)
            {
                this.inventory.setWeapon(item.getWeapon());
            }
        }
        else
        {
            int armorType = item.getArmorType();
            if(armorType == 0)
            {
                this.inventory.setGotHelmet();
            }
            else if(armorType == 1)
            {
                this.inventory.setGotChestplate();
            }
            else if(armorType == 2)
            {
                this.inventory.setGotLeggings();
            }
            else
            {
                this.inventory.setGotBoots();
            }
        }
    }

    public void setImage(Image image){
        this.image = image;
    }
    public Image getImage() {
        return image;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getTrophies() {
        return trophies;
    }

    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }

}
