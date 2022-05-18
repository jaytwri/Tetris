package com.example.block_mover;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ImageView block0 = findViewById(R.id.block0);
        ImageView block1 = findViewById(R.id.block2);
        ImageView block2 = findViewById(R.id.block3);
        ImageView block3 = findViewById(R.id.block4);
        ImageView block4 = findViewById(R.id.block5);
        ImageView block5 = findViewById(R.id.block6);
        ImageView block6 = findViewById(R.id.block7);
        ImageView block7 = findViewById(R.id.block8);
        ImageView block8 = findViewById(R.id.block9);
        ImageView block9 = findViewById(R.id.block10);
        ImageView block10 = findViewById(R.id.block11);
        ImageView block11 = findViewById(R.id.block12);
        ImageView block12 = findViewById(R.id.block13);
        ImageView block13 = findViewById(R.id.block14);
        ImageView block14 = findViewById(R.id.block15);
        ImageView block15 = findViewById(R.id.block16);
        ImageView block16 = findViewById(R.id.block17);
        ImageView block17 = findViewById(R.id.block18);
        ImageView block18 = findViewById(R.id.block19);
        ImageView block19 = findViewById(R.id.block20);
        ImageView block20 = findViewById(R.id.block21);
        ImageView block21 = findViewById(R.id.block22);
        ImageView block22 = findViewById(R.id.block23);
        ImageView block23 = findViewById(R.id.block24);
        ImageView block24 = findViewById(R.id.block25);
        Button ButtonUp = findViewById(R.id.ButtonUp);
        Button ButtonRight = findViewById(R.id.ButtonRight);
        Button ButtonDown = findViewById(R.id.ButtonDown);
        Button ButtonLeft = findViewById(R.id.ButtonLeft);
        int[][] grid = new int[5][5];
        ImageView[] imgGrid = new ImageView[25];
        imgGrid[0] = block0;
        imgGrid[1] = block1;
        imgGrid[2] = block2;
        imgGrid[3] = block3;
        imgGrid[4] = block4;
        imgGrid[5] = block5;
        imgGrid[6] = block6;
        imgGrid[7] = block7;
        imgGrid[8] = block8;
        imgGrid[9] = block9;
        imgGrid[10] = block10;
        imgGrid[11] = block11;
        imgGrid[12] = block12;
        imgGrid[13] = block13;
        imgGrid[14] = block14;
        imgGrid[15] = block15;
        imgGrid[16] = block16;
        imgGrid[17] = block17;
        imgGrid[18] = block18;
        imgGrid[19] = block19;
        imgGrid[20] = block20;
        imgGrid[21] = block21;
        imgGrid[22] = block22;
        imgGrid[23] = block23;
        imgGrid[24] = block24;
        for (ImageView imageView : imgGrid) {
            imageView.setVisibility(View.INVISIBLE);
        }
        imgGrid[12].setVisibility(View.VISIBLE);
        int[] curSquare = {12};
        grid[2][2] = 1;

        ButtonUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(curSquare[0] > 4)
                {
                    imgGrid[curSquare[0]].setVisibility(View.INVISIBLE);
                    curSquare[0] -=5;
                    imgGrid[curSquare[0]].setVisibility(View.VISIBLE);
                }



            }
        });
        ButtonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(curSquare[0] < 20)
                {
                    imgGrid[curSquare[0]].setVisibility(View.INVISIBLE);
                    curSquare[0] +=5;
                    imgGrid[curSquare[0]].setVisibility(View.VISIBLE);
                }
            }
        });
        ButtonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curSquare[0]%5 != 0)
                {
                    imgGrid[curSquare[0]].setVisibility(View.INVISIBLE);
                    curSquare[0] -= 1;
                    imgGrid[curSquare[0]].setVisibility(View.VISIBLE);
                }
            }
        });
        ButtonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((curSquare[0] + 1)%5 != 0)
                {
                    imgGrid[curSquare[0]].setVisibility(View.INVISIBLE);
                    curSquare[0] +=1;
                    imgGrid[curSquare[0]].setVisibility(View.VISIBLE);
                }
            }
        });



    }

}