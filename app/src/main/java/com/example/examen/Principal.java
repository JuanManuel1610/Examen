package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import DatosExamen.EstructuraDatos;

public class Principal extends AppCompatActivity {

    TextView preguntas;

    Button regresa, siguiente, calificar;

    RadioButton r1, r2, r3;
    RadioGroup grupo;

    int contador=0, aciertos = 0, puntos = 0, errores = 10;


    ArrayList<EstructuraDatos> listadatos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal2);
        preguntas = findViewById(R.id.txtpregunta);
        regresa = findViewById(R.id.btnatras);
        siguiente = findViewById(R.id.btnsig);
        calificar = findViewById(R.id.btncal);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        grupo = findViewById(R.id.grupo);

        preguntas();
        siguiente.setEnabled(false);
        calificar.setEnabled(false);
        regresa.setEnabled(false);

        siguiente.setOnClickListener(view -> {
            String seleccion = seleccionn();
            if(seleccion != null){
                listadatos.get(contador).setSeleccion(seleccion);
            }
            contador++;
            if(contador < listadatos.size()){
                EstructuraDatos siguitentep = listadatos.get(contador);
                preguntas.setText((siguitentep.getPregunta()));
                r1.setText(siguitentep.getR1());
                r2.setText(siguitentep.getR2());
                r3.setText(siguitentep.getR3());

                grupo.clearCheck();
            }
        });

        regresa.setOnClickListener(view -> {
            contador--;

            if(contador >= 0 && contador < listadatos.size()){
                EstructuraDatos prev = listadatos.get(contador);
                preguntas.setText(prev.getPregunta());
                r1.setText(prev.getR1());
                r2.setText(prev.getR2());
                r3.setText(prev.getR3());

                grupo.clearCheck();
            }
        });

        grupo.setOnCheckedChangeListener((radioGroup, i) -> {
            if (r1.isChecked() || r2.isChecked() || r2.isChecked()){
                if(contador==9){
                    siguiente.setEnabled(false);
                    calificar.setEnabled(true);
                }else{
                    siguiente.setEnabled(true);
                }

                regresa.setEnabled(contador != 0);
            }else{
                siguiente.setEnabled(false);
            }

        });

        calificar.setOnClickListener(view -> {
            if(contador >= 0 && contador < listadatos.size()){
                EstructuraDatos actual = listadatos.get(contador);
                String seleccion = seleccionn();

                if (seleccion != null){
                    actual.setSeleccion(seleccion);
                }
            }
            puntos = 0;
            aciertos = 0;
            errores = 10;

            for (EstructuraDatos pregunta : listadatos){
                String respSeleccionada = pregunta.getSeleccion();

                if (respSeleccionada != null){
                    if (respSeleccionada.equals(pregunta.getRc())){
                        puntos++;
                        aciertos++;
                        errores++;
                    }
                }
            }

            Intent lanza = new Intent(Principal.this, Resultados.class);
            lanza.putExtra("aciertos", aciertos);
            lanza.putExtra("errores", errores);
            lanza.putExtra("puntos", puntos);
            finish();
            startActivity(lanza);
        });


    }

    private void preguntas() {
        EstructuraDatos ed;
        //pregunta1
        ed = new EstructuraDatos();
        ed.setPregunta("1.-¿Quien descubrio america?");
        ed.setR1("a) Cristobal Colon");
        ed.setR2("b) Nose");
        ed.setR3("c) El pepe");
        ed.setRc("c");
        listadatos.add(ed);
        //pregunta 2
        ed = new EstructuraDatos();
        ed.setPregunta("2.-¿Cuántos huesos hay en el cuerpo humano?");
        ed.setR1("a) 206");
        ed.setR2("b) 100");
        ed.setR3("c) 50");
        ed.setRc("c");
        listadatos.add(ed);
        //pregunta 3
        ed = new EstructuraDatos();
        ed.setPregunta("3.-¿Quién pintó “la última cena?");
        ed.setR1("a) Leonardo DaVinci");
        ed.setR2("b) Francisco");
        ed.setR3("c) Yooo");
        ed.setRc("c");
        listadatos.add(ed);
        //pregunta 4
        ed = new EstructuraDatos();
        ed.setPregunta("4.-¿Cuál es el lugar más frío de la tierra?");
        ed.setR1("a) La Antártida");
        ed.setR2("b) El corazon de tu ex");
        ed.setR3("c) El pistolas jajaja");
        ed.setRc("c");
        listadatos.add(ed);
        //pregunta 5
        ed = new EstructuraDatos();
        ed.setPregunta("5.-¿Cuál es el río más largo del mundo?");
        ed.setR1("a) Nose");
        ed.setR2("b) El canal pa ");
        ed.setR3("c) El nilo");
        ed.setRc("c");
        listadatos.add(ed);
        //pregunta 6
        ed = new EstructuraDatos();
        ed.setPregunta("6.-¿Cómo se denomina el resultado de la multiplicación?");
        ed.setR1("a) Quien sabe");
        ed.setR2("b) Residuo");
        ed.setR3("c) Producto");
        ed.setRc("c");
        listadatos.add(ed);
        //pregunta 7
        ed = new EstructuraDatos();
        ed.setPregunta("7.-¿?");
        ed.setR1("a) ");
        ed.setR2("b) ");
        ed.setR3("c) ");
        ed.setRc("c");
        listadatos.add(ed);
        //pregunta 8
        ed = new EstructuraDatos();
        ed.setPregunta("8.-¿Cuál es el océano más grande?");
        ed.setR1("a) El elba");
        ed.setR2("b) Acapulco");
        ed.setR3("c) Pacifico");
        ed.setRc("c");
        listadatos.add(ed);
        //pregunta 9
        ed = new EstructuraDatos();
        ed.setPregunta("9.-¿Qué significa FIFA?");
        ed.setR1("a) Fédération Internationale de Football Association");
        ed.setR2("b) Nose");
        ed.setR3("c) Institucion");
        ed.setRc("c");
        listadatos.add(ed);
        //pregunta 10
        ed = new EstructuraDatos();
        ed.setPregunta("10.-¿En qué se especializa la cartografía?");
        ed.setR1("a) ciencia que estudia los mapas ");
        ed.setR2("b) Mapitas chidos ");
        ed.setR3("c) De todo ");
        ed.setRc("c");
        listadatos.add(ed);
    }

    private String seleccionn() {
        if (r1.isChecked()){
            return "a";
        } else if (r2.isChecked()) {
            return "b";
        } else if (r3.isChecked()) {
            return "c";
        }else {
            return null;
        }
    }
    }
