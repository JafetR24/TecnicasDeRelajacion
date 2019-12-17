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
        BaseDatos bd = new BaseDatos(getApplicationContext(), "relajacion.db", null, 1);
        SQLiteDatabase db = bd.getReadableDatabase();
        String correo = eCr.getText().toString();
        String contra = eCn.getText().toString();

        Cursor c = db.query("usuario",// Selecting Table
                new String[]{"nombre, correo, contra"},//Selecting columns want to query
                "correo" + " = ? "+" AND "+"contra"+" = ?",
                new String[]{correo,contra},//Where clause
                null, null, null);

        if (c.moveToFirst()) {
            //if cursor has value then in user database there is user associated with this given email so return true
            Toast.makeText(this, "Bienvenido " + c.getString(0), Toast.LENGTH_SHORT).show();
            Intent intent_tecnica = new Intent(this,Activity_Tecnicas_Menu.class);
            startActivity(intent_tecnica);
            finish();
            clearEditText();
            return true;
        }else{
            Toast.makeText(this, "Lo sentimos, no existe la información de usuario", Toast.LENGTH_SHORT).show();
            bd.close();
            clearEditText();
            return false;
        }
    }

    private void clearEditText() {
        eCr.setText("");
        eCn.setText("");
    }
}

