package com.example.tutoratfsi.Model.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ConnexionSQL {
    private MySQLiteHelper openHelper;
    private SQLiteDatabase db;
    private static ConnexionSQL instance;
    Cursor c = null;

    private ConnexionSQL(Context context) {this.openHelper = new MySQLiteHelper(context);}

    public static ConnexionSQL getInstance(Context context){
        if(instance==null){
            instance = new ConnexionSQL(context);
        }
        return instance;
    }

    public void open(){this.db= openHelper.getWritableDatabase();}

    public void close(){
        if(db!=null){
            this.db.close();
        }
    }
}
