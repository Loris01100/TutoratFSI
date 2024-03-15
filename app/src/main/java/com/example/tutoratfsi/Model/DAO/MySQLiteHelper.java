package com.example.tutoratfsi.Model.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_ETUDIANT = "Etudiant";
    public static final String TABLE_BILANUN = "BilanUn";
    public static final String TABLE_BILANDEUX = "BilanDeux";
    private static final String DATABASE_NAME = "tutoratfsi.db";
    private static final int DATABASE_VERSION = 1;
    private static final String ETUDIANT_CREATE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_ETUDIANT + "( idEtu integer primary key autoincrement, " +
            "login text, mdp text, nomEtu text, preEtu text, mail text, tel text, nomTut text, nomMai text, nomEts text);";

    public static final String BILANUN_CREATE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_BILANUN + "( idBilanUn integer primary key autoincrement, " +
            "noteEts integer, dateBilanUn date, noteDossierUn integer, noteOralUn integer, rqBilanUn text);" ;

    public static final String BILANDEUX_CREATE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_BILANDEUX + "( idBilanDeux integer primary key autoincrement, " +
            "noteOralDeux integer, dateBilanDeux date, noteDossierDeux integer, rqBilanDeux text , sujetMemoire text);" ;

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(ETUDIANT_CREATE);
        database.execSQL(BILANUN_CREATE);
        database.execSQL(BILANDEUX_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version" + oldVersion + "to"
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ETUDIANT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BILANUN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BILANDEUX);
        onCreate(db);
    }
}
