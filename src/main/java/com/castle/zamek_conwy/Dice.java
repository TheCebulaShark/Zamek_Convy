package com.castle.zamek_conwy;

import java.util.Random;

public class Dice {
    private final Random random;

    public Dice() {
        random = new Random();
    }

    public int rollDice() {
        return random.nextInt(6) + 1;
    }
}

