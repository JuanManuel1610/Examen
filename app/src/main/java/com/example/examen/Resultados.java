package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Resultados extends AppCompatActivity {

    TextView aciertos, errores, resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        aciertos = findViewById(R.id.lblaci);
        errores = findViewById(R.id.lblerror);
        resultado = findViewById(R.id.lblcali);

        int aciertosValor = getIntent().getIntExtra("aciertos", 0);
        int erroresValor = getIntent().getIntExtra("errores", 0);
        int puntosValor = getIntent().getIntExtra("puntos", 0);

        aciertos.setText("Aciertos: " + aciertosValor);
        errores.setText("Errores: " + erroresValor);
        resultado.setText("Calificación: " + puntosValor);


    }
}