package com.example.tutoratfsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.tutoratfsi.Model.BO.Etudiant;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InfosActivity extends AppCompatActivity {
    private Button buttonRetour2;
    private TextView textViewPreDiff;
    private TextView textViewTutDiff;
    private TextView textViewMaiDiff;
    private TextView textViewEtsDiff;
    private TextView textViewTelDiff;
    private TextView textViewMailDiff;
    private TextView textViewNomDiff;

    private Etudiant etu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);
        etu = getIntent().getParcelableExtra("Etudiant");

        if (etu != null) {
            setupTextViews();
        }

        initialisation();
    }

    private void setupTextViews() {
        textViewPreDiff = findViewById(R.id.textViewPreDiff);
        textViewNomDiff = findViewById(R.id.textViewNomDiff);
        textViewMailDiff = findViewById(R.id.textViewMailDiff);
        textViewTelDiff = findViewById(R.id.textViewTelDiff);
        textViewEtsDiff = findViewById(R.id.textViewEtsDiff);
        textViewMaiDiff = findViewById(R.id.textViewMaiDiff);

        textViewPreDiff.setText(etu.getPreEtu());
        textViewNomDiff.setText(etu.getNomEtu());
        textViewMailDiff.setText(etu.getMailEtu());
        textViewTelDiff.setText(etu.getTelEtu());
        textViewEtsDiff.setText(etu.getNomEts());
        textViewMaiDiff.setText(etu.getNomMaitreApp());
    }

    public void initialisation(){
        buttonRetour2 = findViewById(R.id.buttonRetour2);
        buttonRetour2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}