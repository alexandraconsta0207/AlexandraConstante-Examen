package com.uisrael.alexandraconstante_examen;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Resumen extends AppCompatActivity {
    Bundle datoRecibir;
    TextView usuario,apagartv,estudiantetv,res1,res2,res3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        usuario=findViewById(R.id.tvUsuario);
        estudiantetv=findViewById(R.id.tvNombreEstudiante);
        apagartv=findViewById(R.id.tvPagoTotal);
        res1=findViewById(R.id.tvRespuesta1);
        res2=findViewById(R.id.tvRespuesta2);
        res3=findViewById(R.id.tvResouesta3);

        datoRecibir=getIntent().getExtras();
        String recibirDatos=datoRecibir.getString("usuario");
        String apagar=datoRecibir.getString("cuota");
        String estu=datoRecibir.getString("nombre");
        String p1=datoRecibir.getString("razon");
        String p2=datoRecibir.getString("deportes");
        String p3=datoRecibir.getString("idioma");
        usuario.setText(recibirDatos);
        apagartv.setText(apagar);
        estudiantetv.setText(estu);
        res1.setText(p1);
        res2.setText(p2);
        res3.setText(p3);
    }
}
