package com.example.tutoratfsi.Model.DAO;

import static com.example.tutoratfsi.Model.DAO.MySQLiteHelper.TABLE_ETUDIANT;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.tutoratfsi.Model.BO.Etudiant;
import com.example.tutoratfsi.Model.DAO.ConnexionSQL;

import java.util.ArrayList;

public class DAOEtudiant {
    private MySQLiteHelper dbHelper;
    private SQLiteDatabase database;

    public DAOEtudiant(Context context) {
        dbHelper = new MySQLiteHelper(context);
        database = dbHelper.getWritableDatabase();
    }


    public void open(){
        database=dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }

    private Etudiant cursorToEtudiant(Cursor cursor) {
        Etudiant unEtu = new Etudiant();
        unEtu.setNumEtu(cursor.getInt(0));
        unEtu.setIdentifiant(cursor.getString(1));
        unEtu.setMdpUtilisateur(cursor.getString(2));
        unEtu.setNomEtu(cursor.getString(3));
        unEtu.setPreEtu(cursor.getString(4));
        unEtu.setMailEtu(cursor.getString(5));
        unEtu.setTelEtu(cursor.getString(6));
        unEtu.setNomMaitreApp(cursor.getString(7));
        unEtu.setNomEts(cursor.getString(8));
        return unEtu;
    }
    public Etudiant getIdByEtu(int id) {
        Etudiant unEtu = null;
        Cursor cursor = database.query(true, "Etudiant", new String[]{"idEtu", "nomEtu", "preEtu","mail", "tel", "nomTut", "nomMai", "nomEts"},
                "idEtu = ?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            unEtu = cursorToEtudiant(cursor);
        }
        cursor.close();
        return unEtu;
    }
    public ArrayList<Etudiant> getAllEtu() {
        ArrayList<Etudiant> listEtu = new ArrayList<>();
        Cursor curseur = database.query(true, "Etudiant", new String[]{"numEtu", "identifiant", "mdpUtilisateur", "nomEtu", "preEtu", "mailEtu", "telEtu", "nomMaitreApp", "nomEts"},
                null, null, null, null, null, null);
        while (curseur.moveToNext()) {
            Etudiant unEtu = cursorToEtudiant(curseur);
            listEtu.add(unEtu);
        }
        curseur.close();

        return listEtu;
    }

    public void deleteEtu(Etudiant unEtu){
        int id = unEtu.getNumEtu();
        database.delete(MySQLiteHelper.TABLE_ETUDIANT,"numEtu= "+id,null);
    }

    public void insertEtudiants(ArrayList<Etudiant> etudiants) {
        database.beginTransaction();
        try {
            for (Etudiant etudiant : etudiants) {
                ContentValues valeur = new ContentValues();
                valeur.put("identifiant", etudiant.getIdentifiant());
                valeur.put("mdpUtilisateur", etudiant.getMdpUtilisateur());
                valeur.put("nomEtu", etudiant.getNomEts());
                valeur.put("preEtu", etudiant.getPreEtu());
                valeur.put("mailEtu", etudiant.getMailEtu());
                valeur.put("telEtu", etudiant.getTelEtu());
                valeur.put("nomMaitreApp", etudiant.getNomMaitreApp());
                valeur.put("nomEts", etudiant.getNomEts());
                long id = database.insert("Etudiant", null, valeur);
                if (id != -1) {
                    etudiant.setNumEtu((int) id);
                }
            }
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }
    public void saveToDatabase(Etudiant etudiant) {

        if (etudiant == null || etudiant.getIdentifiant() == null || etudiant.getMdpUtilisateur() == null) {
            Log.e("DAOEtudiant", "Attempted to save null student or required fields are null");
            return;
        }

        Cursor cursor = dbHelper.getReadableDatabase().rawQuery("SELECT * FROM " + MySQLiteHelper.TABLE_ETUDIANT + " WHERE identifiant = ?", new String[]{etudiant.getIdentifiant()});
        if (cursor.getCount() == 0) {
            ContentValues values = new ContentValues();
            values.put("identifiant", etudiant.getIdentifiant());
            values.put("mdpUtilisateur", etudiant.getMdpUtilisateur());
            values.put("nomEtu", etudiant.getNomEtu());
            values.put("preEtu", etudiant.getPreEtu());
            values.put("mailEtu", etudiant.getMailEtu());
            values.put("telEtu", etudiant.getTelEtu());
            values.put("nomMaitreApp", etudiant.getNomMaitreApp());
            values.put("nomEts", etudiant.getNomEts());
            dbHelper.getWritableDatabase().insert(MySQLiteHelper.TABLE_ETUDIANT, null, values);
        }
        cursor.close();
    }


   }
