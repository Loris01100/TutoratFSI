package com.example.tutoratfsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BilanDeuxActivity extends AppCompatActivity {
    Button buttonRetour3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilandeux);
        initialisation();
    }

    public void initialisation() {
        buttonRetour3 = (Button) findViewById(R.id.buttonRetour3);

        buttonRetour3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BilanDeuxActivity.this, NotesActivity.class);
        
                startActivity(intent);
            }
        });
    }
}
