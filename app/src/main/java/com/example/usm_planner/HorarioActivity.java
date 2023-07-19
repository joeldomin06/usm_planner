package com.example.usm_planner;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class HorarioActivity extends AppCompatActivity {
    private TableLayout tableLayout;
    private final String[] bloques = {"1-2","3-4","5-6","7-8","9-10","11-12","13-14","15-16","17-18","19-20"};
    private final String[] horas = {"8:15-9:25","9:35-10:45","10:55-12:05","12:15-13:25","14:30-15:40","15:50-17:00","17:10-18:20","18:30-19:40","19:50-21:00","21:10-22:20"};
    private final String[] head = {"Bloques","Lunes","Martes","Miércoles","Jueves","Viernes"};
    private ArrayList<String[]> filas;
    private int[] colores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);
        // Viculación de la tabla
        tableLayout = findViewById(R.id.tabla);
        // Definición de los colores y de las filas
        CreateRows();
        // Definición de la tabla dinámica
        TablaDinamica tabla = new TablaDinamica(tableLayout, getApplicationContext(),head,filas,colores, head.length, bloques.length);
        // Creación del encabezado
        tabla.createHeader();
        // Creación de los otros datos de la tabla incluidos los colores
        tabla.CreateDataTable();
        System.out.println("Listo");
    }
    private void CreateRows(){
        String bloque;
        String[] fila;
        Random random = new Random();
        int r, g, b, contador = 0;
        filas = new ArrayList<>();
        colores = new int[bloques.length * head.length];
        for (int i = 0; i < bloques.length; i++){
            // Filas de ejemplo
            bloque = bloques[i] + "\n" + horas[i];
            fila = new String[]{bloque,"ramo ejemplo\nsala","\n","\n","\n","\n"};
            filas.add(fila);
            // Colores aleatorios
            for (int j = 0; j < head.length; j++){
                r = random.nextInt(256);
                g = random.nextInt(256);
                b = random.nextInt(256);
                colores[contador++] = Color.rgb(r,g,b);
            }
        }
    }
}
