package com.example.signuplogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    CardView card1, card2;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi tombol Floating Action Button
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LogbookActivity.class);
                startActivity(intent); // Memulai LogbookActivity
            }
        });

        // Inisialisasi CardViews
        setLayout();

        // Menetapkan klik listener untuk CardView
        setClick();
    }

    // Inisialisasi CardView
    void setLayout() {
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
    }

    // Menetapkan klik listener untuk CardViews
    void setClick() {
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameFromDb = getIntent().getStringExtra("username");
                String nameFromDB = getIntent().getStringExtra("Name");
                String emailFromDB = getIntent().getStringExtra("email");
                String passwordFromDb = getIntent().getStringExtra("pasword");

                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("name", nameFromDB);
                intent.putExtra("email", emailFromDB);
                intent.putExtra("username", usernameFromDb);
                intent.putExtra("password", passwordFromDb);
                startActivity(intent);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LogbookActivity.class);
                startActivity(intent);
            }
        });
    }
}
