package com.example.Edu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Academic extends AppCompatActivity
{
    ImageView imageView;
    ImageView imageView6;
    ImageView imageView3;
    ImageView image4;
    ImageView image7;
    ImageView image5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic);

        imageView = findViewById(R.id.imageView);

        imageView3 = findViewById(R.id.imageView3);

        image4 = findViewById(R.id.image4);

        imageView6 = findViewById(R.id.imageView6);

        image7 = findViewById(R.id.image7);

        image5 = findViewById(R.id.image5);



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://drive.google.com/file/d/1F4GDYlDQ5DWNqLF57BLN-hVG5tAPCr9E/view?usp=sharing");
            }
        });



        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://laudea.psgcas.ac.in/exams/result.html#!/get_result");
            }
        });


        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://laudea.psgcas.ac.in/sis/#!/electiveEnrollment");
            }
        });

        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://laudea.psgcas.ac.in/sis/#!/invoices");
            }
        });

        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://laudea.psgcas.ac.in/exams/seating.html?fbclid=PAAaYe6pfpJt8D5haR5Skysi7v2CrPEajfXnIxP0W2bzpFkIHo8s0U6nUuYI4%23%21%2Fcheck_seating#!/check_seating");
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://laudea.psgcas.ac.in/sis/#!/studentHallTicket");
            }
        });
}
        private void gotoUrl(String s) {
            Uri uri = Uri.parse(s);
            startActivity(new Intent(Intent.ACTION_VIEW,uri));
        }

    }

