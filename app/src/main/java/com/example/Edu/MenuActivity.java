package com.example.Edu;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    ImageView imageView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageView imageView5 = findViewById(R.id.imageView5);
        imageView7 = findViewById(R.id.imageView7);
        ImageView LectureButton = findViewById(R.id.imageView6);
        Button b1 = findViewById(R.id.button1);
        Button b2 = findViewById(R.id.button2);
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        LectureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, LectureActivity.class);
                startActivity(i);
            }
        });

        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://meet.google.com/zzp-shdb-fqc");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if assignments are posted (you can replace this condition with your logic)
                if (assignmentsArePosted()) {
                    // If assignments are posted, navigate to the Assignments activity
                    Intent i = new Intent(MenuActivity.this, Assignments.class);
                    startActivity(i);
                } else {
                    // If no assignments are posted, show a pop-up dialog
                    showNoAssignmentsDialog();
                }
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, Academic.class);
                startActivity(i);
            }
        });
    }
    private boolean assignmentsArePosted() {
        // You can implement your logic to check if assignments are posted here.
        // For this example, let's assume assignments are not posted.
        return false;
    }
    private void showNoAssignmentsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("No Assignments Posted");
        builder.setMessage("There are currently no assignments posted.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Do nothing or add any action you want here
            }
        });
        builder.show();
    }

    // Example function to show a toast message
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void gotoUrl(String url) {
        // Code to open the URL in a browser
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}