package com.castle.zamek_conwy;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Random;

public class Enemies {
    private ArrayList<Enemy> enemies;

    public Enemies(){
        enemies = new ArrayList<Enemy>();
        enemies.add(new Enemy(2, "Slime", "/assets/textures/enemies/slime.png"));
        enemies.add(new Enemy(3, "Kobold", "/assets/textures/enemies/kobold.png"));
        enemies.add(new Enemy(4, "Giant Slime", "/assets/textures/enemies/giant_slime.png"));
        enemies.add(new Enemy(5, "Queen Bee", "/assets/textures/enemies/queen_bee.png"));
    }

    public Enemy getRandomEnemy(){
        Random random = new Random();
        int randomIndex = random.nextInt(enemies.size());
        return enemies.get(randomIndex);
    }


    public class Enemy{
        private int attack;
        private Image image;

        private String name;

        public Enemy(int attack, String name, String imagePath) {
            this.attack = attack;
            this.image = new Image(getClass().getResourceAsStream(imagePath));
            this.name = name;
        }

        public int getAttack() {
            return attack;
        }

        public Image getImage() {
            return image;
        }

        public String getName(){
            return name;
        }
    }
}


