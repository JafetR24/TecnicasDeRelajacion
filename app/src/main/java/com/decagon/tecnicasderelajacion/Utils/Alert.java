package com.decagon.tecnicasderelajacion.Utils;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.decagon.tecnicasderelajacion.R;

public class Alert {

    AlertDialog.Builder mDialog;
    AppCompatActivity mActivity;

    public Alert(AppCompatActivity mContext){
        mActivity = mContext;
        mDialog = new AlertDialog.Builder(mActivity);
    }

    public void show(String title, String msg) {
        mDialog.setMessage(msg).
                setTitle(title).
                setCancelable(false).
                setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mActivity.finish();
                        Toast.makeText(mActivity,"Salio del sistema.",
                                Toast.LENGTH_SHORT).show();
                    }
                })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //  Action for 'NO' Button
                dialog.cancel();
            }
        });

        AlertDialog alert = mDialog.create();
        alert.setTitle(R.string.app_title);
        alert.show();
    }
}
