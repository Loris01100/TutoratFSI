package com.example.tutoratfsi.Model.DAO;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.example.tutoratfsi.Model.BO.BilanUn;
import com.example.tutoratfsi.Model.BO.Etudiant;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Date;

public class DAOBilanUn {
    public SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    public DAOBilanUn(Context context) {
        dbHelper = new MySQLiteHelper(context);
        database = dbHelper.getWritableDatabase();
    }



    public void open(){
        database=dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }
    private BilanUn cursorToBilanUn(Cursor cursor) {
        BilanUn unBUn = new BilanUn();
        unBUn.setIdBilanUn(cursor.getInt(0));
        unBUn.setNoteEts(cursor.getInt(1));
        long dateTimestamp = cursor.getLong(2);
        Date date = new Date(dateTimestamp);
        unBUn.setDateBilanUn(date);
        unBUn.setNoteDossierUn(cursor.getInt(3));
        unBUn.setNoteOralUn(cursor.getInt(4));
        unBUn.setRqBilanUn(cursor.getString(5));
        return unBUn;
    }


    public BilanUn getIdByBUn(int id) {
        BilanUn unBUn=null;
        Cursor cursor = database.query(true, "BilanUn", new String[]{"idBilanUn", "noteEts", "dateBilanUn", "noteDossierUn", "noteOralUn", "rqBilanUn"},
                "idBilanUn = "+id, null, null, null, null, null);
        while (cursor.moveToNext()){
            unBUn = cursorToBilanUn(cursor);
        }
        cursor.close();
        return unBUn;
    }
}
