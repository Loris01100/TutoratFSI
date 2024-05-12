package com.example.tutoratfsi.Model.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.tutoratfsi.Model.BO.BilanDeux;
import com.example.tutoratfsi.Model.BO.BilanUn;

import java.util.ArrayList;
import java.util.Date;

public class DAOBilanDeux {
    public SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    public DAOBilanDeux(Context context) {
        dbHelper = new MySQLiteHelper(context);
        database = dbHelper.getWritableDatabase();
    }



    public void open(){
        database=dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }

    private BilanDeux cursorToBilanDeux(Cursor cursor) {
        BilanDeux unBDeux = new BilanDeux();
        unBDeux.setIdBilanDeux(cursor.getInt(0));
        unBDeux.setNoteOralDeux(cursor.getInt(1));
        unBDeux.setNoteDossierDeux(cursor.getInt(2));
        long dateTimestamp = cursor.getLong(3);
        Date date = new Date(dateTimestamp);
        unBDeux.setDateBilanDeux(date);
        unBDeux.setRqBilanDeux(cursor.getString(4));
        unBDeux.setSujetMemoire(cursor.getString(5));
        return unBDeux;
    }


    public BilanDeux getIdByBDeux(int id) {
        BilanDeux unBDeux=null;
        Cursor cursor = database.query(true, "BilanDeux", new String[]{"idBilanDeux", "noteOralDeux", "noteDossierDeux", "dateBilanDeux", "rqBilanDeux", "sujetMemoire"},
                "idBilanDeux = "+id, null, null, null, null, null);
        while (cursor.moveToNext()){
            unBDeux = cursorToBilanDeux(cursor);
        }
        cursor.close();
        return unBDeux;
    }
}
