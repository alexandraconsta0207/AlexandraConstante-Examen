package com.uisrael.alexandraconstante_examen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText txtUser;
    EditText txtPassword;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnEntrar= (Button) findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = txtUser.getText().toString();
                String password= txtPassword.getText().toString();

                if(user.equals("estudiante2020") && password.equals("uisrael2020")) {
                    Intent intentEnvio = new Intent(getApplicationContext(), Registro.class);
                    intentEnvio.putExtra("datoEnviado", txtUser.getText().toString());
                    startActivity(intentEnvio);
                }else{

                    Toast.makeText(getApplicationContext(),"Dato Incorrecto", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }
}
