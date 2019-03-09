package com.example.kiore.lab3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ver extends AppCompatActivity {

    TextView tvNombre, tvCorreo, tvClave, tvTipo;
    String nombre, correo, pass, tipo;

    final static String N = "name";
    final static String M = "mail";
    final static String P = "password";
    final static String C = "confirm";
    final static String T = "type";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        Bundle datos = getIntent().getExtras();

        tvNombre = findViewById(R.id.tvName);
        tvCorreo = findViewById(R.id.tvMail);
        tvClave  = findViewById(R.id.tvPass);
        tvTipo   = findViewById(R.id.tvType);

        nombre = datos.getString(N);
        correo = datos.getString(M);
        pass   = datos.getString(P);
        tipo   = datos.getString(T);

        tvNombre.setText("Nombre: " + nombre);
        tvCorreo.setText("Correo: " + correo);
        tvClave.setText("Password: " + pass);
        tvTipo.setText("Tipo: " + tipo);
    }

    public void Confirmar(View btnConfirmar){

        Toast.makeText(getApplicationContext(),"Datos Guardados", Toast.LENGTH_LONG).show();
        setResult(RESULT_OK);
        finish();

    }

    public void Cancelar(View btnCancel){

        AlertDialog.Builder cancel = new AlertDialog.Builder(this);

        cancel
                .setTitle("Cancelar")
                .setMessage("Desea Cancelar la operacion?")
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
        AlertDialog alertD = cancel.create();
        alertD.show();






    }
}
