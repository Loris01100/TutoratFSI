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
import com.example.tutoratfsi.Model.BO.Etudiant;
import com.example.tutoratfsi.Model.DAO.DAOBilanDeux;
import com.example.tutoratfsi.Model.DAO.DAOBilanUn;

public class NotesActivity extends AppCompatActivity {
    private TextView textViewNotes;
    private Button buttonBilan1;
    private Button buttonBilan2;
    private Button buttonRetour;
    private DAOBilanUn daoBilanUn;
    private DAOBilanDeux daoBilanDeux;
    private BilanUn b1;
    private BilanDeux b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix);
        initialisation();
    }

    public void initialisation() {
        buttonBilan1 = (Button) findViewById(R.id.buttonBilan1);
        buttonBilan2 = (Button) findViewById(R.id.buttonBilan2);
        buttonRetour = (Button) findViewById(R.id.buttonRetour);

        buttonBilan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationBilanUn(b1);
            }
        });

        buttonBilan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationBilanDeux(b2);
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
    private void navigationBilanUn(BilanUn b1) {
        Intent intent = new Intent(NotesActivity.this, BilanUnActivity.class);
        intent.putExtra("BilanUn", b1);
        startActivity(intent);
    }

    private void navigationBilanDeux(BilanDeux b2) {
        Intent intent = new Intent(NotesActivity.this, BilanDeuxActivity.class);
        intent.putExtra("BilanDeux", b2);
        startActivity(intent);
    }
}
