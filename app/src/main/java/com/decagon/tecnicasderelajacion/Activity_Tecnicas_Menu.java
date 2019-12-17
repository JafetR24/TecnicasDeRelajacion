package com.decagon.tecnicasderelajacion;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.decagon.tecnicasderelajacion.Utils.Alert;

public class Activity_Tecnicas_Menu extends AppCompatActivity {

    Alert alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__tecnicas__menu);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
