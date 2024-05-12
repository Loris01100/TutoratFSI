package com.example.tutoratfsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tutoratfsi.Model.BO.Etudiant;
import com.example.tutoratfsi.Model.DAO.APITutorat;
import com.example.tutoratfsi.Model.DAO.DAOEtudiant;
import com.example.tutoratfsi.Model.DAO.MySQLiteHelper;
import com.example.tutoratfsi.Model.DAO.RetroFitEtudiant;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity {
    private EditText editTextLogin;
    private EditText editTextMdp;
    private Button buttonConnexion;
    private MySQLiteHelper dbHelper;
    private DAOEtudiant daoEtudiant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MySQLiteHelper(this);
        daoEtudiant = new DAOEtudiant(this);
        dbHelper.open();
        initialisation();
        AllEtu();
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }

    private void initialisation() {
        editTextLogin = findViewById(R.id.editTextLogin);
        editTextMdp = findViewById(R.id.editTextMdp);
        buttonConnexion = findViewById(R.id.Connexion);

        buttonConnexion.setOnClickListener(v -> {
            String login = editTextLogin.getText().toString().trim();
            String password = editTextMdp.getText().toString().trim();
            if (!login.isEmpty() && !password.isEmpty()) {
                fetchStudentData(login, password);
            } else {
                Toast.makeText(MainActivity.this, "Les champs login et mot de passe ne doivent pas être vides", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void fetchStudentData(String login, String password) {
        APITutorat apiService = RetroFitEtudiant.getApiTutorat();
        Call<Etudiant> call = apiService.getEtudiant(login, password);

        call.enqueue(new Callback<Etudiant>() {
            @Override
            public void onResponse(Call<Etudiant> call, Response<Etudiant> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Etudiant etudiant = response.body();
                    daoEtudiant.saveToDatabase(etudiant);
                    navigateToHome(etudiant);
                } else {
                    Toast.makeText(MainActivity.this, "Erreur d'authentification. Veuillez vérifier vos identifiants.", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Etudiant> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Erreur réseau: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void navigateToHome(Etudiant etudiant) {
        Intent intent = new Intent(MainActivity.this, AccueilActivity.class);
        intent.putExtra("Etudiant", etudiant);
        startActivity(intent);
    }

    private void AllEtu() {
        APITutorat apiService = RetroFitEtudiant.getApiTutorat();
        Call<ArrayList<Etudiant>> call = apiService.getAllEtudiants();

        call.enqueue(new Callback<ArrayList<Etudiant>>() {
            @Override
            public void onResponse(Call<ArrayList<Etudiant>> call, Response<ArrayList<Etudiant>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<Etudiant> lesEtudiants = response.body();
                    for (Etudiant etudiant : lesEtudiants) {
                        daoEtudiant.saveToDatabase(etudiant);
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Etudiant>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Erreur réseau", Toast.LENGTH_LONG).show();
            }
        });
    }
}
