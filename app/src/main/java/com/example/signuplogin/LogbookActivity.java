package com.example.signuplogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class LogbookActivity extends AppCompatActivity {

    Button saveButton;
    EditText uploadTopic, uploadDesc, uploadLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_book);

        uploadDesc = findViewById(R.id.uploadDesc);
        uploadTopic = findViewById(R.id.uploadTopic);
        uploadLang = findViewById(R.id.uploadLang);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }

    public void saveData() {
        String title = uploadTopic.getText().toString().trim();
        String desc = uploadDesc.getText().toString().trim();
        String lang = uploadLang.getText().toString().trim();

        // Validasi input
        if (title.isEmpty() || desc.isEmpty() || lang.isEmpty()) {
            Toast.makeText(LogbookActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Membuat objek data
        String currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        DataClass dataClass = new DataClass(title, desc, lang, ""); // Kosongkan URL gambar

        // Menyimpan ke Firebase Realtime Database
        FirebaseDatabase.getInstance().getReference("Android Tutorials").child(currentDate)
                .setValue(dataClass)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(LogbookActivity.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                        finish(); // Kembali ke layar sebelumnya
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(LogbookActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }
}
