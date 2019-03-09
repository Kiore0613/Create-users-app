package com.example.kiore.lab3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class Editar extends AppCompatActivity {

    EditText edtName, edtMail, edtPass, edtConfir;
    RadioButton rdbUsers, rdbAdmins, rdbAsists;

    String name, mail, pass, confir, tipo;

    static final int id = 1;
    final static String N = "name";
    final static String M = "mail";
    final static String P = "password";
    final static String C = "confirm";
    final static String T = "type";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        edtName   = findViewById(R.id.edtNombre);
        edtMail   = findViewById(R.id.edtCorreo);
        edtPass   = findViewById(R.id.edtClave);
        edtConfir = findViewById(R.id.edtConfClave);

        rdbUsers  = findViewById(R.id.rdbUser);
        rdbAsists = findViewById(R.id.rdbAsist);
        rdbAdmins = findViewById(R.id.rdbAdmin);
    }

    public void Guardar (View btnGuardar) {

        name = edtName.getText().toString().trim();
        mail = edtMail.getText().toString().trim();
        pass = edtPass.getText().toString().trim();
        confir = edtConfir.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            edtName.setError("Campo obligatorio");
            edtName.requestFocus();
        } else if (TextUtils.isEmpty(mail)) {
            edtMail.setError("Campo obligatorio");
            edtMail.requestFocus();
        } else if (TextUtils.isEmpty(pass)) {
            edtPass.setError("Campo obligatorio");
            edtPass.requestFocus();
        } else if (TextUtils.isEmpty(confir)) {
            edtConfir.setError("Campo obligatorio");
            edtConfir.requestFocus();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){

                edtMail.setError("Formato no valido");
                edtMail.setText("");
                edtMail.requestFocus();

        } else if (!pass.equals(confir)) {
                AlertDialog.Builder error = new AlertDialog.Builder(this);
                error
                        .setTitle("Error")
                        .setMessage("el password no coincide")
                        .setCancelable(false)
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                edtPass.setText("");
                                edtConfir.setText("");
                                edtPass.requestFocus();
                            }
                        });
                AlertDialog mostrar = error.create();
                mostrar.show();
        }
        else{
            if(rdbUsers.isChecked()){
                tipo = "Usuario";
            }
            else if(rdbAsists.isChecked()){
                tipo = "Asistente";
            }
            else if(rdbAdmins.isChecked()){
                tipo = "Administrador";
            }

            Intent obj = new Intent(getApplicationContext(), Ver.class);

            obj.putExtra(N,name);
            obj.putExtra(M,mail);
            obj.putExtra(P,pass);
            obj.putExtra(C,confir);
            obj.putExtra(T,tipo);

            startActivityForResult(obj, id);
        }
    }
    @Override
    public void onActivityResult(int codigoActividad,int codigoResultado,Intent data){
        if(codigoActividad == id){
            if(codigoResultado == RESULT_OK){
                finish();
            }
        }

    }



    public void Cancelar (View btnCancelar){

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
