package com.decagon.tecnicasderelajacion;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Activity_AgregarTecnica extends AppCompatActivity {
    private Button btnA;
    private EditText eNom,eDes,eDCor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_tecnica);
        eNom = findViewById(R.id.etNT);
        eDCor = findViewById(R.id.etDC);
        eDes = findViewById(R.id.etD);
        btnA = findViewById(R.id.btnAgregar);
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarDatos();
            }
        });
    }

    public boolean agregarDatos() {
        BaseDatos bd = new BaseDatos(getApplicationContext(), "relajacion.db", null, 1);
        SQLiteDatabase db = bd.getReadableDatabase();

        String nombre = eNom.getText().toString().trim();
        String descC  = eDCor.getText().toString().trim();
        String desc   = eDes.getText().toString().trim();

        ContentValues agregar = new ContentValues();
        agregar.put("NOMBRE", nombre);
        agregar.put("DESCRIPCION", descC);
        agregar.put("DESCRIPCION_CORTA", desc);

        long value = db.insert("tecnica", null, agregar);

        db.close();

        if( value != -1) {
            Toast.makeText(this, "Datos agregados", Toast.LENGTH_SHORT).show();
            Intent intent_tecnica = new Intent(this, Activity_Tecnicas_Menu.class);
            startActivity(intent_tecnica);
            finish();
        }
        else{
            Toast.makeText(this, "Datos no agregados: " + value, Toast.LENGTH_SHORT).show();
        }
        clearEditText();
        return true;
    }

    private void clearEditText() {
        eNom.setText("");
        eDCor.setText("");
        eDes.setText("");
    }

}

