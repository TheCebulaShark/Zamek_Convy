package com.castle.zamek_conwy;

import javafx.scene.image.Image;

public class Armor {
    public ArmorPart helmet;
    public ArmorPart chestplate;
    public ArmorPart leggings;
    public ArmorPart boots;

    public Armor() {
        this.helmet = new ArmorPart(false, "/assets/textures/items/armor1.png");
        this.chestplate  = new ArmorPart(false, "/assets/textures/items/armor2.png");
        this.leggings = new ArmorPart(false, "/assets/textures/items/armor3.png");
        this.boots = new ArmorPart(false, "/assets/textures/items/armor4.png");
    }
    public static class ArmorPart {
        public boolean owned;
        public String texturePath;

        public ArmorPart(boolean owned, String texturePath) {
            this.owned = owned;
            this.texturePath = texturePath;
        }

        public void setOwned(boolean owned) {
            this.owned = owned;
        }

        public boolean isOwned() {
            return owned;
        }

        public String getTexturePath() {
            return texturePath;
        }
    }
}