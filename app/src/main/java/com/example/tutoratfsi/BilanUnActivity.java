package com.example.tutoratfsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tutoratfsi.Model.BO.BilanUn;

public class BilanUnActivity extends AppCompatActivity {
    Button buttonRetour4;

    private TextView textViewNoteD1DB;
    private TextView TextViewNoteO1DB;
    private TextView textViewDB1BD;
    private TextView textViewNoteEtsDB;
    private TextView textViewRQ1DB;
    private BilanUn b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilanun);
        b1 = getIntent().getParcelableExtra("BilanUn");

        if (b1 != null) {
            setupTextViews();
        }

        initialisation();
    }

    private void setupTextViews() {
        textViewNoteD1DB = findViewById(R.id.textViewNoteD1DB);
        TextViewNoteO1DB= findViewById(R.id.TextViewNoteO1DB);
        //textViewDB1BD = findViewById(R.id.textViewDB1BD);
        textViewNoteEtsDB = findViewById(R.id.textViewTelDiff);
        textViewRQ1DB = findViewById(R.id.textViewNoteEtsDB);

        textViewNoteD1DB.setText(b1.getNoteDossierUn());
        TextViewNoteO1DB.setText(b1.getNoteOralUn());
        //textViewDB1BD.setText(b1.getDateBilanUn());
        textViewNoteEtsDB.setText(b1.getNoteEts());
        textViewRQ1DB.setText(b1.getRqBilanUn());
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
