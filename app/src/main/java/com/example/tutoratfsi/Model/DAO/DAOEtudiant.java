package com.example.tutoratfsi.Model.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tutoratfsi.Model.BO.Etudiant;

import java.util.ArrayList;

public class DAOEtudiant {
    public SQLiteDatabase database;

    private Etudiant cursorToEtudiant(Cursor curseur) {
        return null;
    }


    public Etudiant insertEtudiant(Etudiant monEtu) {
        ContentValues valeur = new ContentValues();
        valeur.put("login", monEtu.getLogin());
        valeur.put("mdp", monEtu.getMdp());
        valeur.put("nomEtu", monEtu.getNomEts());
        valeur.put("preEtu", monEtu.getPreEtu());
        valeur.put("mail", monEtu.getMail());
        valeur.put("tel", monEtu.getTel());
        valeur.put("nomTut", monEtu.getNomTut());
        valeur.put("nomMai", monEtu.getNomMai());
        valeur.put("nomEts", monEtu.getNomEts());
        int id =(int) database.insert("Etudiant", null, valeur);
        monEtu.setIdEtu(id);

        return monEtu;
    }

    public ArrayList<Etudiant> getAllEtu() {
        ArrayList<Etudiant> listEtu = new ArrayList<>();
        Cursor curseur = database.query(true, "Etudiant", new String[]{"idEtu", "login", "mdp", "nomEtu", "preEtu", "mail", "tel", "nomTut", "nomMai", "nomEts"},
                null, null, null, null, null, null);
                while (curseur.moveToNext()) {
                    Etudiant unEtu = cursorToEtudiant(curseur);
                    listEtu.add(unEtu);
                }
                curseur.close();

                return listEtu;
    }

    public Etudiant getIdByEtu(int id) {
        Etudiant unEtu=null;
        Cursor cursor = database.query(true, "Etudiant", new String[]{"idEtu", "nomEtu", "preEtu","mail", "tel", "nomTut", "nomMai", "nomEts"},
                "idEtu = "+id, null, null, null, null, null);
        while (cursor.moveToNext()){
            unEtu = cursorToEtudiant(cursor);
        }
        cursor.close();
        return unEtu;
    }

    public void deleteEtu(Etudiant unEtu){
        int id = unEtu.getIdEtu();
        database.delete(MySQLiteHelper.TABLE_ETUDIANT,"idEtu= "+id,null);
    }
}
