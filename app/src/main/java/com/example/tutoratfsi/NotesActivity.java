package com.example.tutoratfsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NotesActivity extends AppCompatActivity {
    private TextView textViewNotes;
    private Button buttonBilan1;
    private Button buttonBilan2;
    private Button buttonRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix);
        initialisation();
    }

    public void initialisation(){
        buttonBilan1 = (Button) findViewById(R.id.buttonBilan1);
        buttonBilan2 = (Button) findViewById(R.id.buttonBilan2);
        buttonRetour = (Button) findViewById(R.id.buttonRetour);

        buttonBilan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotesActivity.this, BilanUnActivity.class);

                startActivity(intent);
            }
        });
        buttonBilan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotesActivity.this, BilanDeuxActivity.class);

                startActivity(intent);
            }
        });

        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotesActivity.this, AccueilActivity.class);

                startActivity(intent);
            }
        });
    }
}
