package com.example.splashactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {
    Button b1 , b3 , b4 , b5 , b6 , b7 , b8 , b9 , b10 , b11 , b12 , b13 , b14 , b15 , b16 , b17 , b18 , b19 , b20;
    EditText edit ;
    Boolean add , sub , mul , div , rem , point , flag = true ;
    double input1 = 0 , input2 = 0 , result = 0 ;
    RelativeLayout main_layout ;
    int a = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        main_layout = findViewById(R.id.main_layout);
        edit = findViewById(R.id.et_cal);
        b1 = findViewById(R.id.b1);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b10 = findViewById(R.id.b10);
        b11 = findViewById(R.id.b11);
        b12 = findViewById(R.id.b12);
        b13 = findViewById(R.id.b13);
        b14 = findViewById(R.id.b14);
        b15 = findViewById(R.id.b15);
        b16 = findViewById(R.id.b16);
        b17 = findViewById(R.id.b17);
        b18 = findViewById(R.id.b18);
        b19 = findViewById(R.id.b19);
        b20 = findViewById(R.id.b20);

        //AC Button (Clear Edit Text)
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.setText("");
                input1 = 0.0;
                input2 = 0.0;
            }
        });

        //Reminder Button : %
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = 5 ;
                rem=true;
                if(edit.getText().length()!=0)
                {
                    input1 = Float.parseFloat(edit.getText() + "");
                    rem = true ;
                    point = false ;
                    edit.setText(null);
                }
            }
        });

        //Division Button : /
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = 4 ;
                div = true;
                if(edit.getText().length()!=0)
                {
                    input1 = Float.parseFloat(edit.getText() + "");
                    div = true ;
                    point = false ;
                    edit.setText(null);
                }
            }
        });

        //Digit - 7
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.setText(edit.getText() + "7");
            }
        });

        //Digit - 8
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.setText(edit.getText() + "8");
            }
        });

        //Digit - 9
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.setText(edit.getText() + "9");
            }
        });

        //Multiplication Button : X
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = 3 ;
                mul = true;
                if(edit.getText().length()!=0)
                {
                    input1 = Float.parseFloat(edit.getText() + "");
                    mul = true ;
                    point = false ;
                    edit.setText(null);
                }
            }
        });

        //Digit - 4
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.setText(edit.getText() + "4");
            }
        });

        //Digit - 5
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.setText(edit.getText() + "5");
            }
        });

        //Digit - 4
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.setText(edit.getText() + "6");
            }
        });

        //Addition Button : +
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = 1 ;
                if(edit.getText().length()!=0)
                {
                    input1 = Float.parseFloat(edit.getText() + "");
                    add = true ;
                    point = false ;
                    edit.setText(null);
                }
            }
        });

        //Digit - 1
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.setText(edit.getText() + "1");
            }
        });

        //Digit - 2
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.setText(edit.getText() + "2");
            }
        });

        //Digit - 3
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.setText(edit.getText() + "3");
            }
        });

        //Subtraction Button : -
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = 2 ;
                sub = true;
                if(edit.getText().length()!=0)
                {
                    input1 = Float.parseFloat(edit.getText() + "");
                    sub = true ;
                    point = false ;
                    edit.setText(null);
                }
            }
        });

        //Equals Button = (To Show Result)
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    /*if(add || sub || mul || div || rem )
                    {
                        Toast.makeText(HomePage.this, "Value : "+edit.getText().toString(), Toast.LENGTH_LONG).show();
                        System.out.println(edit.getText().toString() + " " + div);
                        input2 = Float.parseFloat(edit.getText().toString());
                    }*/

                    input2 = Float.parseFloat(edit.getText().toString() + "");
                    switch (a)
                    {
                        case 1 : edit.setText((input1+input2) + "");
                                 add = false ;
                                 break;
                        case 2 : edit.setText((input1-input2) + "");
                                 sub = false ;
                                 break;
                        case 3 : edit.setText((input1*input2) + "");
                                 mul = false ;
                                 break;
                        case 4 : edit.setText((input1/input2) + "");
                                 div = false ;
                                 break;
                        case 5 : edit.setText((input1%input2) + "");
                                 rem = false ;
                                 break;
                        default:
                            Toast.makeText(HomePage.this, "Wrong Choice ! Sorry", Toast.LENGTH_SHORT).show();
                    }

                    /*if(add==true)
                    {
                        //result = input1+input2;
                        edit.setText((input1+input2) + "");
                        add = false ;
                    }
                    else if(sub==true)
                    {
                        //result = input1-input2;
                        edit.setText((input1-input2) + "");
                        sub = false ;
                    }
                    else if(mul==true)
                    {
                        //result = input1*input2;
                        edit.setText((input1*input2) + "");
                        mul = false ;
                    }
                    else if(div==true)
                    {
                        //result = input1/input2;
                        edit.setText((input1/input2) + "");
                        div = false ;
                    }
                    else if(rem==true)
                    {
                        //result = input1%input2;
                        edit.setText((input1%input2) + "");
                        rem = false ;
                    }*/
                }
                catch (NullPointerException e){

                }

            }
        });

        //Digit - 0
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.setText(edit.getText() + "0");
            }
        });

        //Dot Button : .
        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(point)
                {
                    //do Nothing
                }
                else {
                    edit.setText(edit.getText() + ".");
                    point = true;
                }
            }
        });

        //Notes Button (To Navigate to Notes Page)
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePage.this , Notes.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}