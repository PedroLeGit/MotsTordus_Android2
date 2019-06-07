package com.iscb.slamsio2.app_antonin_android.outils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    //propriétés
    private String requeteCrea = "CREATE TABLE IF NOT EXISTS utilisateur ("
        + "id_utilisateur INTEGER PRIMARY KEY,"
        + "nom_utilisateur TEXT NOT NULL,"
        + "prenom_utilisateur TEXT NOT NULL,"
        + "pseudo_utilisateur TEXT NOT NULL,"
        + "email_utilisateur TEXT NOT NULL,"
        + "motdepasse_utilisateur TEXT NOT NULL,"
        + "niveau_utilisateur INTEGER NOT NULL,"
        + "codeavatar_utilisateur INTEGER NOT NULL);";

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * Si changement de base de données
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(requeteCrea);
        //vider la table
        String req_supp = "DELETE FROM utilisateur;";
        db.execSQL(req_supp);
    }

    /**
     * Si changement de version de la base de données
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
