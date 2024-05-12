package com.example.tutoratfsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tutoratfsi.Model.BO.Etudiant;

public class AccueilActivity extends AppCompatActivity {
    private Button buttonInfos;
    private Button buttonNotes;
    private Etudiant etu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        etu = getIntent().getParcelableExtra("Etudiant");
        initialisation();


    }

    public void initialisation() {
        buttonInfos = (Button) findViewById(R.id.buttonInfos);
        buttonNotes = (Button) findViewById(R.id.buttonNotes);

        buttonNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, NotesActivity.class);
                // intent.putExtra("Etudiant", etu);
                startActivity(intent);
            }

        });

        buttonInfos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToInfos(etu);
            }
        });
    }
    private void navigateToInfos(Etudiant etudiant) {
        Intent intent = new Intent(AccueilActivity.this, InfosActivity.class);
        intent.putExtra("Etudiant", etudiant);
        startActivity(intent);
    }

}
