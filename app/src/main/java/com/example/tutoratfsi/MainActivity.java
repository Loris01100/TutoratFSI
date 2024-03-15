package com.example.tutoratfsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tutoratfsi.Model.BO.Etudiant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editTextLogin;
    private EditText editTextMdp;
    private Button buttonConnexion;
    private String login;
    private String mdp;
    private List<Etudiant> listUser;

    private void initUtilisateur() {
        listUser = new ArrayList<>();

        listUser.add(new Etudiant(1, "Bach", "Bach","Bach","Loris","lolo@gmail.com","0622272194","Ostorerro","Thouverez","IPC"));
    }

    private boolean controle(String login, String mdp){
        for (Etudiant etudiant : listUser) {
            if(etudiant.getLogin().equals(login) && etudiant.getMdp().equals(mdp)){
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUtilisateur();
        controle(login, mdp);
        initialisation();
    }

    public void initialisation() {
        editTextLogin = (EditText) findViewById(R.id.editTextLogin);
        editTextMdp = (EditText) findViewById(R.id.editTextMdp);
        buttonConnexion = (Button) findViewById(R.id.Connexion);

        buttonConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login = editTextLogin.getText().toString();
                mdp = editTextMdp.getText().toString();

                if (controle(login, mdp)) {
                    Toast.makeText(MainActivity.this, "Connexion réussie", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, AccueilActivity.class);

                    startActivity(intent);
                }
                else{

                    Toast.makeText(MainActivity.this, "identifiant incorrects", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}