package com.decagon.tecnicasderelajacion;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity {
    private Button btnR;
    private EditText eCr,eCn,eNm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eCr = findViewById(R.id.edRCr);
        eCn = findViewById(R.id.edRCn);
        eNm = findViewById(R.id.edRN);

        btnR = findViewById(R.id.btnR);
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrardatos();
            }

        });
    }

    private void registrardatos() {
        BaseDatos bd = new BaseDatos(this, "Relajacion.db", null, 1);
        final SQLiteDatabase db = bd.getWritableDatabase();
        String nombre = eCr.getText().toString();
        String correo = eCn.getText().toString();
        String contra = eNm.getText().toString();
        ContentValues registrar = new ContentValues();
        registrar.put("NOMBRE", nombre);
        registrar.put("CORREO", correo);
        registrar.put("CONTRASEÑA", contra);
        db.insert("votantes", null, registrar);
        db.close();
        Toast.makeText(this, "Datos agregados", Toast.LENGTH_SHORT).show();
        Intent intent_tecnica = new Intent(this,MainActivity.class);
        startActivity(intent_tecnica);
        finish();
    }

}

