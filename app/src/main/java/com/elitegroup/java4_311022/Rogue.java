package com.elitegroup.java4_311022;

public class Rogue extends Player{

    int defence = 30;
    int attack = 10;

    @Override
    void battleTo(Player player2) {
        super.battleTo(player2);
        player2.attack-=attack;
    }
}
