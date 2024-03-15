package com.example.tutoratfsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BilanUnActivity extends AppCompatActivity {
    Button buttonRetour4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilanun);
        initialisation();
    }

    public void initialisation() {
        buttonRetour4 = (Button) findViewById(R.id.buttonRetour4);

        buttonRetour4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BilanUnActivity.this, NotesActivity.class);

                startActivity(intent);
            }
        });
    }
}
