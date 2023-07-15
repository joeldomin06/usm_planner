package com.example.usm_planner;

import android.os.Bundle;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HorarioActivity extends AppCompatActivity {
    private TableLayout tableLayout;
    private final String[] bloques = {"1-2","3-4","5-6","7-8","9-10","11-12","13-14","15-16","17-18","19-20"};
    private final String[] horas = {"8:15-9:25","9:35-10:45","10:55-12:05","12:15-13:25","14:30-15:40","15:50-17:00","17:10-18:20","18:30-19:40","19:50-21:00","21:10-22:20"};
    private final String[] head = {"Bloques","Lunes","Martes","Miércoles","Jueves","Viernes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);
        // Viculación de la tabla
        tableLayout = findViewById(R.id.tabla);
        // Definición de la tabla dinámica
        TablaDinamica tabla = new TablaDinamica(tableLayout, getApplicationContext());
        tabla.addHeader(head);
        ArrayList<String[]> rows = CreateRows();
        tabla.addData(rows);
        System.out.println("Awa");
    }
    private ArrayList<String[]> CreateRows(){
        String bloque;
        ArrayList<String[]> rows = new ArrayList<>();
        for (int i = 0; i < bloques.length; i++){
            bloque = bloques[i] + "\n" + horas[i];
            rows.add(new String[]{bloque,"","","","",""});
        }
        return rows;
    }
}
