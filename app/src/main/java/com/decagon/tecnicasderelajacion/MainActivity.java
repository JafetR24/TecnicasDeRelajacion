package com.decagon.tecnicasderelajacion;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonA,buttonR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonA = findViewById(R.id.btnMA);
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_acc = new Intent(view.getContext(), Login.class);
                startActivity(intent_acc);
                finish();
            }
        });

        buttonR = findViewById(R.id.btnMReg);
        buttonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_reg = new Intent(view.getContext(), Registro.class);
                startActivity(intent_reg);
                finish();
            }
        });
    }
}
