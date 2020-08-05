package com.example.imagica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Button level1;
        level1= (Button) findViewById(R.id.level1button);
        Button level2;
        level2= (Button) findViewById(R.id.level2button);
        Button level3;
        level3= (Button) findViewById(R.id.level3button);
        Button level4;
        level4= (Button) findViewById(R.id.level4button);
        Button level5;
        level5= (Button) findViewById(R.id.level5button);
        Button level6;
        level6= (Button) findViewById(R.id.level6button);

        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(".Level1");
                startActivity(intent);
            }
        });

        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(".Level2");
                startActivity(intent);
            }
        });

        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(".Level3");
                startActivity(intent);
            }
        });

        level4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(".Level4");
                startActivity(intent);
            }
        });

        level5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(".Level5");
                startActivity(intent);
            }
        });

        level6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(".Level6");
                startActivity(intent);
            }
        });
    }
}
