package com.decagon.tecnicasderelajacion;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper{

    public BaseDatos(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("CREATE TABLE  usuario(_id INTEGER, NOMBRE TEXT NOT NULL, CORREO TEXT NOT NULL, CONTRA TEXT NOT NULL);");
        db.execSQL("Create table tecnica(_id INTEGER, NOMBRE TEXT, DESCRIPCION TEXT, DESCRIPCION_CORTA TEXT,RATING INTEGER);");
        db.execSQL("Create table comentario(_id INTEGER, COMENTARIO TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS usuario;");
        db.execSQL("DROP TABLE IF EXISTS tecnica;");
        db.execSQL("DROP TABLE IF EXISTS comentario;");
        onCreate(db);
    }

}
