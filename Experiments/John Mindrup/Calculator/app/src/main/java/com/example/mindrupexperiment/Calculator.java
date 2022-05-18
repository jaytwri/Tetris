package com.example.mindrupexperiment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity
{


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        int[] Num1 = {0};
        int[] Num2 = {0};
        int[] Operator = {0};
        Boolean[] OpEntered = {false};
        Boolean DecEntered = false;

        TextView txt = findViewById(R.id.Calculator_Window);

        Button btn0 = findViewById(R.id.Calculator_Button_0);
        Button btn1 = findViewById(R.id.Calculator_Button_1);
        Button btn2 = findViewById(R.id.Calculator_Button_2);
        Button btn3 = findViewById(R.id.Calculator_Button_3);
        Button btn4 = findViewById(R.id.Calculator_Button_4);
        Button btn5 = findViewById(R.id.Calculator_Button_5);
        Button btn6 = findViewById(R.id.Calculator_Button_6);
        Button btn7 = findViewById(R.id.Calculator_Button_7);
        Button btn8 = findViewById(R.id.Calculator_Button_8);
        Button btn9 = findViewById(R.id.Calculator_Button_9);
        Button btnAdd = findViewById(R.id.Calculator_Button_Add);
        Button btnSub = findViewById(R.id.Calculator_Button_Minus);
        Button btnMul = findViewById(R.id.Calculator_Button_Mult);
        Button btnDiv = findViewById(R.id.Calculator_Button_Div);
        Button btnDec = findViewById(R.id.Calculator_Button_Dec);
        Button btnNeg = findViewById(R.id.Calculator_Button_Neg);
        Button btnEq = findViewById(R.id.Calculator_Button_Equal);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {


                if(!OpEntered[0])
                {
                    Num1[0] = Num1[0] * 10 + 0;
                    txt.setText(Integer.toString(Num1[0]));
                }
                else
                {
                    Num2[0] = Num2[0] * 10 + 0;
                    switch(Operator[0])
                    {
                        case 0:
                            txt.setText(Integer.toString(Num1[0]) + " + " + Integer.toString(Num2[0]));
                            break;
                        case 1:
                            txt.setText(Integer.toString(Num1[0]) + " - " + Integer.toString(Num2[0]));
                            break;
                        case 2:
                            txt.setText(Integer.toString(Num1[0]) + " * " + Integer.toString(Num2[0]));
                            break;
                        case 3:
                            txt.setText(Integer.toString(Num1[0]) + " / " + Integer.toString(Num2[0]));
                    }
                }

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(!OpEntered[0])
                {
                    Num1[0] = Num1[0] * 10 + 1;
                    txt.setText(Integer.toString(Num1[0]));
                }
                else
                {
                    Num2[0] = Num2[0] * 10 + 1;
                    switch(Operator[0])
                    {
                        case 0:
                            txt.setText(Integer.toString(Num1[0]) + " + " + Integer.toString(Num2[0]));
                            break;
                        case 1:
                            txt.setText(Integer.toString(Num1[0]) + " - " + Integer.toString(Num2[0]));
                            break;
                        case 2:
                            txt.setText(Integer.toString(Num1[0]) + " * " + Integer.toString(Num2[0]));
                            break;
                        case 3:
                            txt.setText(Integer.toString(Num1[0]) + " / " + Integer.toString(Num2[0]));
                    }
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(!OpEntered[0])
                {
                    Num1[0] = Num1[0] * 10 + 2;
                    txt.setText(Integer.toString(Num1[0]));
                }
                else
                {
                    Num2[0] = Num2[0] * 10 + 2;
                    switch(Operator[0])
                    {
                        case 0:
                            txt.setText(Integer.toString(Num1[0]) + " + " + Integer.toString(Num2[0]));
                            break;
                        case 1:
                            txt.setText(Integer.toString(Num1[0]) + " - " + Integer.toString(Num2[0]));
                            break;
                        case 2:
                            txt.setText(Integer.toString(Num1[0]) + " * " + Integer.toString(Num2[0]));
                            break;
                        case 3:
                            txt.setText(Integer.toString(Num1[0]) + " / " + Integer.toString(Num2[0]));
                    }
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(!OpEntered[0])
                {
                    Num1[0] = Num1[0] * 10 + 3;
                    txt.setText(Integer.toString(Num1[0]));
                }
                else
                {
                    Num2[0] = Num2[0] * 10 + 3;
                    switch(Operator[0])
                    {
                        case 0:
                            txt.setText(Integer.toString(Num1[0]) + " + " + Integer.toString(Num2[0]));
                            break;
                        case 1:
                            txt.setText(Integer.toString(Num1[0]) + " - " + Integer.toString(Num2[0]));
                            break;
                        case 2:
                            txt.setText(Integer.toString(Num1[0]) + " * " + Integer.toString(Num2[0]));
                            break;
                        case 3:
                            txt.setText(Integer.toString(Num1[0]) + " / " + Integer.toString(Num2[0]));
                    }
                }

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(!OpEntered[0])
                {
                    Num1[0] = Num1[0] * 10 + 4;
                    txt.setText(Integer.toString(Num1[0]));
                }
                else
                {
                    Num2[0] = Num2[0] * 10 + 4;
                    switch(Operator[0])
                    {
                        case 0:
                            txt.setText(Integer.toString(Num1[0]) + " + " + Integer.toString(Num2[0]));
                            break;
                        case 1:
                            txt.setText(Integer.toString(Num1[0]) + " - " + Integer.toString(Num2[0]));
                            break;
                        case 2:
                            txt.setText(Integer.toString(Num1[0]) + " * " + Integer.toString(Num2[0]));
                            break;
                        case 3:
                            txt.setText(Integer.toString(Num1[0]) + " / " + Integer.toString(Num2[0]));
                    }
                }

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(!OpEntered[0])
                {
                    Num1[0] = Num1[0] * 10 + 5;
                    txt.setText(Integer.toString(Num1[0]));
                }
                else
                {
                    Num2[0] = Num2[0] * 10 + 5;
                    switch(Operator[0])
                    {
                        case 0:
                            txt.setText(Integer.toString(Num1[0]) + " + " + Integer.toString(Num2[0]));
                            break;
                        case 1:
                            txt.setText(Integer.toString(Num1[0]) + " - " + Integer.toString(Num2[0]));
                            break;
                        case 2:
                            txt.setText(Integer.toString(Num1[0]) + " * " + Integer.toString(Num2[0]));
                            break;
                        case 3:
                            txt.setText(Integer.toString(Num1[0]) + " / " + Integer.toString(Num2[0]));
                    }
                }

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(!OpEntered[0])
                {
                    Num1[0] = Num1[0] * 10 + 6;
                    txt.setText(Integer.toString(Num1[0]));
                }
                else
                {
                    Num2[0] = Num2[0] * 10 + 6;
                    switch(Operator[0])
                    {
                        case 0:
                            txt.setText(Integer.toString(Num1[0]) + " + " + Integer.toString(Num2[0]));
                            break;
                        case 1:
                            txt.setText(Integer.toString(Num1[0]) + " - " + Integer.toString(Num2[0]));
                            break;
                        case 2:
                            txt.setText(Integer.toString(Num1[0]) + " * " + Integer.toString(Num2[0]));
                            break;
                        case 3:
                            txt.setText(Integer.toString(Num1[0]) + " / " + Integer.toString(Num2[0]));
                    }
                }

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(!OpEntered[0])
                {
                    Num1[0] = Num1[0] * 10 + 7;
                    txt.setText(Integer.toString(Num1[0]));
                }
                else
                {
                    Num2[0] = Num2[0] * 10 + 7;
                    switch(Operator[0])
                    {
                        case 0:
                            txt.setText(Integer.toString(Num1[0]) + " + " + Integer.toString(Num2[0]));
                            break;
                        case 1:
                            txt.setText(Integer.toString(Num1[0]) + " - " + Integer.toString(Num2[0]));
                            break;
                        case 2:
                            txt.setText(Integer.toString(Num1[0]) + " * " + Integer.toString(Num2[0]));
                            break;
                        case 3:
                            txt.setText(Integer.toString(Num1[0]) + " / " + Integer.toString(Num2[0]));
                    }
                }

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(!OpEntered[0])
                {
                    Num1[0] = Num1[0] * 10 + 8;
                    txt.setText(Integer.toString(Num1[0]));
                }
                else
                {
                    Num2[0] = Num2[0] * 10 + 8;
                    switch(Operator[0])
                    {
                        case 0:
                            txt.setText(Integer.toString(Num1[0]) + " + " + Integer.toString(Num2[0]));
                            break;
                        case 1:
                            txt.setText(Integer.toString(Num1[0]) + " - " + Integer.toString(Num2[0]));
                            break;
                        case 2:
                            txt.setText(Integer.toString(Num1[0]) + " * " + Integer.toString(Num2[0]));
                            break;
                        case 3:
                            txt.setText(Integer.toString(Num1[0]) + " / " + Integer.toString(Num2[0]));
                    }
                }

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(!OpEntered[0])
                {
                    Num1[0] = Num1[0] * 10 + 9;
                    txt.setText(Integer.toString(Num1[0]));
                }
                else
                {
                    Num2[0] = Num2[0] * 10 + 9;
                    switch(Operator[0])
                    {
                        case 0:
                            txt.setText(Integer.toString(Num1[0]) + " + " + Integer.toString(Num2[0]));
                            break;
                        case 1:
                            txt.setText(Integer.toString(Num1[0]) + " - " + Integer.toString(Num2[0]));
                            break;
                        case 2:
                            txt.setText(Integer.toString(Num1[0]) + " * " + Integer.toString(Num2[0]));
                            break;
                        case 3:
                            txt.setText(Integer.toString(Num1[0]) + " / " + Integer.toString(Num2[0]));
                    }
                }
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!OpEntered[0]) {
                    OpEntered[0] = true;
                    Operator[0] = 0;
                    txt.setText(Integer.toString(Num1[0]) + " +");
                }
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!OpEntered[0]) {
                    OpEntered[0] = true;
                    Operator[0] = 1;
                    txt.setText(Integer.toString(Num1[0]) + " -");
                }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!OpEntered[0]) {
                    OpEntered[0] = true;
                    Operator[0] = 2;
                    txt.setText(Integer.toString(Num1[0]) + " X");
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!OpEntered[0]) {
                    OpEntered[0] = true;
                    Operator[0] = 3;
                    txt.setText(Integer.toString(Num1[0]) + " /");
                }
            }
        });
        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!OpEntered[0])
                {
                    Num1[0] = Num1[0] * -1;
                }
                else
                {
                    Num2[0] = Num2[0] * -1;
                }
            }
        });
        btnEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Double ans = 0.0;
                if(Operator[0] == 0)
                    ans = Double.valueOf(Num1[0] + Num2[0]);
                else if(Operator[0] == 1)
                    ans = Double.valueOf(Num1[0] - Num2[0]);
                else if(Operator[0] == 2)
                    ans = Double.valueOf(Num1[0] * Num2[0]);
                else
                    ans = Double.valueOf(Num1[0] / Num2[0]);
                txt.setText(ans.toString());



            }
        });

    }


}
