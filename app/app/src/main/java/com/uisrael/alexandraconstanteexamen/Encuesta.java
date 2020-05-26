package com.uisrael.alexandraconstanteexamen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Encuesta extends AppCompatActivity {

    TextView usuario,razon;
    Bundle datoRecibir;
    CheckBox basket,esgrima,tenis;
    RadioButton si,no;
    StringBuffer deportesP= new StringBuffer();
    StringBuffer idioma=new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        usuario=findViewById(R.id.tvUsuario);
        tenis=findViewById(R.id.cbTenis);
        esgrima=findViewById(R.id.cbEsgrima);
        basket=findViewById(R.id.cbBasket);

        si=findViewById(R.id.rbSi);
        no=findViewById(R.id.rbNo);
        razon=findViewById(R.id.etRazon);
        datoRecibir=getIntent().getExtras();
        String recibirDatos=datoRecibir.getString("usuario");
        usuario.setText(recibirDatos);

    }
    public void mostrarRespuestas(){

        if(basket.isChecked()==true){
            deportesP.append(basket.getText().toString()).append(" - ");
        }
        if(tenis.isChecked()==true){
            deportesP.append(tenis.getText().toString()).append(" - ");
        }
        if(esgrima.isChecked()==true){
            deportesP.append(esgrima.getText().toString()).append(" - ");
        }

        if(si.isChecked()==true){
            idioma.append("SI me gustaria");
        }
        if(no.isChecked()==true){
            idioma.append("NO me gustan los idiomas");
        }
    }

    public void envioDatos(View v){
        mostrarRespuestas();
        Intent intentEnvio= new Intent(Encuesta.this,Resumen.class);
        intentEnvio.putExtra("usuario",usuario.getText().toString());
        intentEnvio.putExtra("razon",razon.getText().toString());
        intentEnvio.putExtra("deportes",deportesP.toString());
        intentEnvio.putExtra("idioma",idioma.toString());
        startActivity(intentEnvio);
    }
}
