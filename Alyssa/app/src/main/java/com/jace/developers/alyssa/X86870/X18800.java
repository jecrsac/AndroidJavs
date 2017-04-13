package com.jace.developers.alyssa.X86870;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.sql.SQLException;

public class X18800 {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME="l0038018f0416104m99x";
    private static final String TABLE_CREDENTIAL = "xNXTlai_AD_AJCT";


    /* Definición Tabla Credencial */
    public static final class Credentials implements BaseColumns {
        private Credentials() {}
        public static final String ID = "id";
        public static final String IX = "ix";
        public static final String NO = "no";
        public static final String AP = "ap";
        public static final String TL = "tl";
        public static final String CE = "ce";
        public static final String MV = "mv";
    }

    /* Creacion de Tablas */
    private static final String TABLE_CREDENTIAL_CREATE = "create table " + TABLE_CREDENTIAL
            + " (" + Credentials.ID + " integer primary key autoincrement, "
            + Credentials.IX + " bigint not null, "
            + Credentials.NO + " text not null, "
            + Credentials.AP + " text not null, "
            + Credentials.TL + " text not null, "
            + Credentials.CE + " text not null, "
            + Credentials.MV + " text not null );";

    private Context context;
    private SQLiteDatabase db;
    private DBHandler openHelper; //Gestor de base de datos

    public X18800(Context ctx){
        this.context = ctx;
        openHelper = new DBHandler(context);
    }

    public X18800 open() throws SQLException {
        db = openHelper.getWritableDatabase();
        return this;
    }

    public void close(){ this.db.close(); }

    private class DBHandler extends SQLiteOpenHelper {

        DBHandler(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(TABLE_CREDENTIAL_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLA IF EXISTS "+TABLE_CREDENTIAL);
            onCreate(db);
        }
    }


    /** CREDENTIAL ********************************************************************************/
    /* DELETE */
    public void X126132700(){ db.delete(TABLE_CREDENTIAL, null, null); }

    /* INSERT */
    public long X126132701(String ix, String no, String ap, String tl, String ce, String mv){
        ContentValues values = new ContentValues();
        values.put(Credentials.IX, ix);
        values.put(Credentials.NO, no);
        values.put(Credentials.AP, ap);
        values.put(Credentials.TL, tl);
        values.put(Credentials.CE, ce);
        values.put(Credentials.MV, mv);
        return db.insert(TABLE_CREDENTIAL, null, values);
    }

    /* UPDATE */
    public long X126132702(String ix, String no, String ap, String tl, String ce) {
        ContentValues values = new ContentValues();
        values.put(Credentials.NO, no);
        values.put(Credentials.AP, ap);
        values.put(Credentials.TL, tl);
        values.put(Credentials.CE, ce);
        return db.update(TABLE_CREDENTIAL, values, Credentials.IX + "=?", new String[]{ix});
    }

    /* SELECT */
    public Cursor X810634302() {
        return db.query(TABLE_CREDENTIAL, new String[]{Credentials.ID, Credentials.IX, Credentials.NO, Credentials.AP, Credentials.TL, Credentials.CE, Credentials.MV}
                , null, null, null, null, null, null);
    }

}
