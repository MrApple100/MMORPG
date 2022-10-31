package com.elitegroup.java4_311022;

public class Wizard extends Player{
    int defence = 50;

    int attack = 40;

    @Override
    void battleTo(Player player2) {
        if(player2.defence>0) {
            player2.health -= attack / 3*2;
            player2.defence -= attack / 3;
        }else {
            player2.health -= attack;
        }
    }
}
