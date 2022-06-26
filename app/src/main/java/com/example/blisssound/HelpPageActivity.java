package com.example.blisssound;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HelpPageActivity extends AppCompatActivity {

    Button callbutton, reportbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_page);
        callbutton= findViewById(R.id.calltbutton);
        reportbutton= findViewById(R.id.reportbutton);


        callbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:01558699567"));
                startActivity(intent);
            }
        });

        reportbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","mohamed.ghanem44@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hearing-Aid issue !!");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "write your report here");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });
    }
}