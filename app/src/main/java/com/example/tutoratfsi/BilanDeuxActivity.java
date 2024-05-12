package com.example.tutoratfsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tutoratfsi.Model.BO.BilanDeux;
import com.example.tutoratfsi.Model.BO.BilanUn;

public class BilanDeuxActivity extends AppCompatActivity {
    Button buttonRetour3;
    private TextView textViewSMDB;
    private TextView TextViewDB2DB;
    private TextView textViewNoteO2DB;
    private TextView textViewNoteD2DB;
    private TextView textViewRQ2DB;
    private BilanDeux b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilandeux);
        b2 = getIntent().getParcelableExtra("BilanDeux");

        if (b2 != null) {
            setupTextViews();
        }


        initialisation();


    }

    private void setupTextViews() {
        textViewSMDB = findViewById(R.id.textViewNoteD1DB);
        textViewNoteD2DB= findViewById(R.id.TextViewNoteO1DB);
        textViewRQ2DB = findViewById(R.id.textViewDB1BD);
        textViewNoteO2DB = findViewById(R.id.textViewTelDiff);
        //TextViewDB2DB = findViewById(R.id.textViewNoteEtsDB);

        textViewSMDB.setText(b2.getSujetMemoire());
        textViewNoteD2DB.setText(b2.getNoteDossierDeux());
        textViewRQ2DB.setText(b2.getRqBilanDeux());
        textViewNoteO2DB.setText(b2.getNoteOralDeux());
        //TextViewDB2DB.setText(b2.getDateBilanDeux());
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
