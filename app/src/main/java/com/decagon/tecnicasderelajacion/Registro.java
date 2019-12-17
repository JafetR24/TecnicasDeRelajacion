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
        BaseDatos bd = new BaseDatos(this, "relajacion.db", null, 1);
        final SQLiteDatabase db = bd.getWritableDatabase();

        String nombre = eNm.getText().toString().trim();
        String correo = eCr.getText().toString().trim();
        String contra = eCn.getText().toString().trim();

        ContentValues registrar = new ContentValues();

        registrar.put("NOMBRE", nombre);
        registrar.put("CORREO", correo);
        registrar.put("CONTRA", contra);

        long value = db.insert("usuario", null, registrar);

        db.close();

        if( value != -1) {
            Toast.makeText(this, "Datos agregados", Toast.LENGTH_SHORT).show();
            Intent intent_tecnica = new Intent(this, MainActivity.class);
            startActivity(intent_tecnica);
            finish();
        }
        else{
            Toast.makeText(this, "Datos no agregados: " + value, Toast.LENGTH_SHORT).show();
        }
        clearEditText();
    }

    private void clearEditText() {
        eCr.setText("");
        eCn.setText("");
        eNm.setText("");
    }

}

