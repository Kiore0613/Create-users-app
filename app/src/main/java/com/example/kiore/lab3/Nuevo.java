package com.example.kiore.lab3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Nuevo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
    }

    public void Nuevo(View btnNuevo){

        Intent nuevo = new Intent(getApplicationContext(), Editar.class);
        startActivity(nuevo);

    }

    public void Salir(View btnSalir){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert
                .setTitle("Salir")
                .setMessage("Desea volver al login?")
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });
        AlertDialog alertD = alert.create();
        alertD.show();

    }

}
