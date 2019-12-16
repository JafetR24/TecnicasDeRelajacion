package com.decagon.tecnicasderelajacion;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper{
    public static final String DataBaseName="Relajacion.db";
    public static final int dbversion=1;

    public BaseDatos(Context context, String name, CursorFactory factory, int version) {
        super(context, DataBaseName, factory, dbversion);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        //Se ejecuta la primera vez para crear la BD
        db.execSQL("Create table usuario(_id INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE TEXT, CORREO TEXT, CONTRASEÑA TEXT);");
        db.execSQL("Create table tecnico(_id INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE TEXT, DESCRIPCION TEXT, RATING INTEGER);");
        db.execSQL("Create table comentario(_id INTEGER PRIMARY KEY AUTOINCREMENT, COMENTARIO TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS usuario;");
        db.execSQL("DROP TABLE IF EXISTS contacto;");
        db.execSQL("DROP TABLE IF EXISTS comentario;");
        onCreate(db);
    }

}
