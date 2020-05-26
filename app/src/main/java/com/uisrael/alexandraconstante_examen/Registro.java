package com.uisrael.alexandraconstante_examen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity {

    TextView txtUser;
    Bundle datoRecibido;
    EditText recibir,etNombre1,etMonto1,pagoMensual1;
    double abono, saldo, iva,cuotaTotal, pagoTotal;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        txtUser=findViewById(R.id.txtUser);
        datoRecibido = getIntent().getExtras();
        String RecibirUser = datoRecibido.getString("datoEnviado");
        recibir.setText(RecibirUser);
            etNombre1=findViewById(R.id.etNombre);
            etMonto1=findViewById(R.id.etMonto);
            pagoMensual1 = findViewById(R.id.etCuotaMensual);

    }


    public void Calcular(View v) {

         int valorTotal=1800;
        abono = Double.parseDouble(etMonto1.getText().toString());
        saldo = valorTotal - abono;
        iva = (saldo * 5/100);
        cuotaTotal = saldo + iva;
        pagoTotal = cuotaTotal / 3;
        pagoMensual1.setText(Double.toString(pagoTotal));

    }
    public void Guardar(){
        Intent registro = new Intent (getApplicationContext(), Encuesta.class);
        registro.putExtra("usuario",txtUser.getText().toString());
        registro.putExtra("nombre",etNombre1.getText().toString());
        registro.putExtra("cuota", String.valueOf(cuotaTotal));
    startActivity(registro);

        Toast.makeText(getApplicationContext(),"Elemento guardada con exito",Toast.LENGTH_SHORT).show();
}
}