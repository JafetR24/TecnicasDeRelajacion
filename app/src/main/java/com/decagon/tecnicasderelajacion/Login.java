package com.decagon.tecnicasderelajacion;
import android.content.Intent;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Login extends AppCompatActivity {
    private Button btnL;
    private EditText eCr,eCn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eCr = findViewById(R.id.edLCr);
        eCn = findViewById(R.id.edLCn);

        btnL = findViewById(R.id.btnAcc);
        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View view) {
                verificarlogin();
                  }

             });
        }

    public boolean verificarlogin() {
        BaseDatos bd = new BaseDatos(this, "Relajacion.db", null, 1);
        final SQLiteDatabase db = bd.getWritableDatabase();
        String correo= eCr.getText().toString();
        String contraseña=eCn.getText().toString();
        final Cursor c = db.query("usuario",// Selecting Table
                new String[]{"NOMBRE, CORREO, CONTRASEÑA"},//Selecting columns want to query
                "CORREO" + " = ? "+" AND "+"CONTRASEÑA"+"= ?",
                new String[]{correo,contraseña},//Where clause
                null, null, null);

        if (c != null && c.moveToFirst()) {
            //if cursor has value then in user database there is user associated with this given email so return true
            Toast.makeText(this, "Bienvenido/a", Toast.LENGTH_SHORT).show();
            Intent intent_tecnica = new Intent(this,Activity_Tecnicas_Menu.class);
            startActivity(intent_tecnica);
            finish();
            return true;
        }else{
            Toast.makeText(this, "Lo sentimos, no existe la información de usuario", Toast.LENGTH_SHORT).show();
            bd.close();
            return false;
        }
    }}

