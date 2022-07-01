package com.example.blisssound;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=(Button) findViewById(R.id.aboutbutton);
        Button button2=(Button) findViewById(R.id.bluetoothbutton);
        Button button3=(Button) findViewById(R.id.guidebutton);
        Button button4=(Button) findViewById(R.id.helpbutton);
        Button button5=(Button) findViewById(R.id.chatbotbutton);
        TextView textView=findViewById(R.id.wlcmtext);

        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("key");

        textView.setText("Welcome"+" "+username);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AboutPageActivity.class);
                startActivity(intent);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,BluetoothPageActivity.class);
                startActivity(intent);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,GuidePageActivity.class);
                startActivity(intent);

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, HelpPageActivity.class);
                startActivity(intent);

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ChatBotActivity.class);
                startActivity(intent);

            }
        });


    }
}