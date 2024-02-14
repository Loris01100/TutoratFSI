package com.example.tutoratfsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AccueilActivity extends AppCompatActivity {
    private TextView textViewBienvenu;
    private Button buttonInfos;
    private Button buttonNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        initialisation();
    }

    public void initialisation() {
        textViewBienvenu = (TextView)findViewById(R.id.textViewBienvenu);
        buttonInfos = (Button) findViewById(R.id.buttonInfos);
        buttonNotes = (Button) findViewById(R.id.buttonNotes);

        buttonNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, NotesActivity.class);
                startActivity(intent);
            }

        });

        buttonInfos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, InfosActivity.class);
                startActivity(intent);
            }
        });
    }
}
