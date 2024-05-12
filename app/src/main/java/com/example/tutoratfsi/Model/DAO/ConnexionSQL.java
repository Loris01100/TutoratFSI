package com.example.tutoratfsi.Model.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ConnexionSQL {
    private MySQLiteHelper openHelper;
    private SQLiteDatabase db;
    Cursor c = null;


    public ConnexionSQL(Context context) {
        openHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        db = openHelper.getWritableDatabase();
    }
    public enum TableType {
        ETUDIANT, BILANUN, BILANDEUX
    }
    public String info(TableType type) {
        switch (type) {
            case ETUDIANT:
                return openHelper.TABLE_ETUDIANT;
            case BILANUN:
                return openHelper.TABLE_BILANUN;
            case BILANDEUX:
                return openHelper.TABLE_BILANDEUX;
            default:
                return null;
        }
    }
    public void close(){
        openHelper.close();
    }
}
