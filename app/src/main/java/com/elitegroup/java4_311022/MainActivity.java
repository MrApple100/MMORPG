package com.elitegroup.java4_311022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Knight knight = new Knight();
    Wizard wizard = new Wizard();
    Rogue rogue = new Rogue();

    int khh = 100;
    int whh = 100;
    int rhh = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button battle = findViewById(R.id.Battle);
        TextView result = findViewById(R.id.Result);

        EditText kh = findViewById(R.id.KH);
        EditText wh = findViewById(R.id.WH);
        EditText rh = findViewById(R.id.RH);

        kh.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                khh = Integer.parseInt(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        wh.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                whh = Integer.parseInt(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        rh.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                rhh = Integer.parseInt(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        ArrayList<Player> players = new ArrayList<Player>();
        players.add(knight);
        players.add(wizard);
        players.add(rogue);

        Random random = new Random();
        random.setSeed(13);

        battle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                knight.health=khh;
                wizard.health=whh;
                rogue.health=rhh;
                while(knight.health>0 && wizard.health>0 && rogue.health>0){
                    int i = Math.abs(random.nextInt()) % players.size();
                    int i2 = 0;
                    do{
                        i2 = Math.abs(random.nextInt()) % players.size();
                    }while(i==i2);
                    players.get(i).battleTo(players.get(i2));
                }
                if(knight.health<1 || wizard.health<1){
                    if(knight.health<1){
                        result.setText("Knight is lose");
                        System.out.println("Knight is lose");
                    }else{
                        result.setText("Wizard is lose");
                        System.out.println("Wizard is lose");

                    }
                }else{
                    result.setText("Rogue is lose");
                    System.out.println("Rogue is lose");
                }
                knight = new Knight();
                wizard = new Wizard();
                rogue = new Rogue();
                players.clear();
                players.add(knight);
                players.add(wizard);
                players.add(rogue);
            }
        });


    }
}