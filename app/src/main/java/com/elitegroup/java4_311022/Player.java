package com.elitegroup.java4_311022;

public class Player {

    int health = 100;
    int defence =40;

    int attack = 15;

    Player(){

    }

    Player(int h,int defence,int a){
        health = h;
        this.defence = defence;
        attack = a;
    }


    void battleTo(Player player2){
        if(player2.getClass() == Knight.class){
            if(player2.defence>0) {
                player2.health -= attack / 3;
                player2.defence -= attack / 3 * 2;
            }else {
                player2.health -= attack;
            }
        }else {
            if(player2.defence>0) {
                player2.health -= attack / 2;
                player2.defence -= attack / 2;
            }else {
                player2.health -= attack;
            }
        }
    }
}
