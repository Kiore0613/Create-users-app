package com.example.kiore.lab3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtUser, edtPass;
    String user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUser = findViewById(R.id.edtUsuario);
        edtPass = findViewById(R.id.edtClave);
    }

    public void Ingresar(View btnIngresar){

        user = edtUser.getText().toString().trim();
        pass = edtPass.getText().toString().trim();

        if(TextUtils.isEmpty(user)){
            edtUser.setError("Campo obligatorio");
            edtUser.requestFocus();
        }
        else if(TextUtils.isEmpty(pass)){
            edtPass.setError("Campo obligatorio");
            edtPass.requestFocus();
        }
        else{

            if(user.equals("admin") && pass.equals("admin")){

            }
            else{
                AlertDialog.Builder alerta = new AlertDialog.Builder(this);

                alerta.setTitle("Error");
                alerta
                        .setMessage("El usuario o clave son incorrectos")
                        .setCancelable(false)
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });


               AlertDialog alertD = alerta.create();
               alertD.show();

                edtUser.setText("");
                edtPass.setText("");
                edtUser.requestFocus();
            }
            
        }

    }
}
