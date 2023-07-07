package com.castle.zamek_conwy;

import java.util.ArrayList;
import java.util.List;

public class Combat {
    private Dice dice = new Dice();
    public Combat(){}

    public int getArmour(Player player){
        int armour1 = 0;

        if(player.inventory.getArmor().boots.isOwned()) armour1++;
        if(player.inventory.getArmor().chestplate.isOwned()) armour1++;
        if(player.inventory.getArmor().helmet.isOwned()) armour1++;
        if(player.inventory.getArmor().leggings.isOwned()) armour1++;

        return armour1;
    }
    public List<Integer> vsEnemy(Enemies.Enemy enemy, Player player) {
        List<Integer> statistic = new ArrayList<>();
        int weapon1 = player.inventory.getWeapon().getAttack();
        
        int monsterRoll = dice.rollDice();
        int playerRoll = dice.rollDice();
        int monsterResult = enemy.getAttack() + monsterRoll - getArmour(player);
        int playerResult = player.getAttack() + playerRoll + weapon1;

        int res = Integer.compare(playerResult, monsterResult);

        if(res == -1) {
            player.setHealth(player.getHealth() - 1);
            if(player.getHealth() == 0)
                player.setDead();
        }

        statistic.add(res);
        statistic.add(playerRoll);
        statistic.add(playerResult);
        statistic.add(monsterRoll);
        statistic.add(monsterResult);

        return statistic;
    }

    public List<Integer> vsPlayer(Player player1, Player player2) {
        List<Integer> statistic = new ArrayList<>();
        int weapon1 = player1.inventory.getWeapon().getAttack();
        
        int weapon2 = player2.inventory.getWeapon().getAttack();
        
        int player1Roll = dice.rollDice();
        int player2Roll = dice.rollDice();
        int player1Result = player1.getAttack() + player1Roll + weapon1 - getArmour(player2);
        int player2Result = player2.getAttack() + player2Roll + weapon2 - getArmour(player1);

        int res = Integer.compare(player1Result, player2Result);

        if(res == -1) {
            player1.setHealth(player1.getHealth() - 1);
            if (player1.getHealth() == 0)
                player1.setDead();
        }
        else if(res == 1){
            player2.setHealth(player2.getHealth() - 1);
                if(player2.getHealth() == 0)
                    player2.setDead();
        }

        statistic.add(res);
        statistic.add(player1Roll);
        statistic.add(player1Result);
        statistic.add(player2Roll);
        statistic.add(player2Result);

        return statistic;
    }
}
