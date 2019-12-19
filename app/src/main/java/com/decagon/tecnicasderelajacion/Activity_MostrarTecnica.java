package com.decagon.tecnicasderelajacion;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_MostrarTecnica extends AppCompatActivity {
    private Button btnBorrar;
    private TextView tvN,tvDC,tvD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_tecnica);
        tvN = findViewById(R.id.tvNombre);
        tvDC = findViewById(R.id.tvDesCorta);
        tvD = findViewById(R.id.tvDesc);
        BaseDatos bd = new BaseDatos(getApplicationContext(), "relajacion.db", null, 1);
        SQLiteDatabase db = bd.getReadableDatabase();
        Bundle bundle = getIntent().getExtras();
        String nom = bundle.getString("nombre");

        Cursor c = db.query("tecnica",// Selecting Table
                new String[]{"NOMBRE,DESCRIPCION,DESCRIPCION_CORTA"},//Selecting columns want to query
                "NOMBRE" + " = "+nom+"",null,null,//Where clause
                null, null, null);
        if (c.moveToFirst()) {
            tvN.setText(c.getString(1));
            tvDC.setText(c.getString(3));
            tvD.setText(c.getString(2));
        } else
            Toast.makeText(this, "No existe una persona con dicho dni",
                    Toast.LENGTH_SHORT).show();
        bd.close();

        if (c.moveToFirst()) {
            //if cursor has value then in user database there is user associated with this given email so return true
            Toast.makeText(this, "Bienvenido " + c.getString(0), Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Lo sentimos, no existe la información de usuario", Toast.LENGTH_SHORT).show();
            bd.close();
        }
        btnBorrar = findViewById(R.id.btnAgregar);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                borrarDatos();
            }
        });
    }

    public boolean borrarDatos() {
        BaseDatos bd = new BaseDatos(getApplicationContext(), "relajacion.db", null, 1);
        SQLiteDatabase db = bd.getReadableDatabase();

        String nombre = tvN.getText().toString().trim();
        int num = db.delete("tecnica","NOMBRE="+nombre+"",null);
        db.close();

        if (num==1) {
            Toast.makeText(this, "Se borró la tecnica", Toast.LENGTH_SHORT).show();
            Intent intent_tecnica = new Intent(this, Activity_Tecnicas_Menu.class);
            startActivity(intent_tecnica);
            finish();
        }else{
            Toast.makeText(this, "No existe una persona con dicho documento", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
