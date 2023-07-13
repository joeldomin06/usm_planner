package com.example.usm_planner;

import android.os.Bundle;

public class HorarioActivity {

    private final String[] bloques = {"1-2","3-4","5-6","7-8","9-10","11-12","13-14","15-16","17-18","19-20"};
    private final String[] horarios = {"8:15-9:25","9:35-10:45","10:55-12:05","12:15-13:25","14:30-15:40","15:50-17:00","17:10-18:20","18:30-19:40","19:50-21:00","21:10-22:20"};
    private final String[] dias = {"Lunes","Martes","Miércoles","Jueves","Viernes"};

    // Algo respecto a la creación y que se genere la tabla usando el layout predefinido

    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        // Se recorren los bloques
        for (int i = 0; i < bloques.length; i++) {
            String bloque = bloques[i];
            String horario = horarios[i];

            System.out.println(bloque + " " + horario);
            // Se recorren los horarios
            for (int j = 0; j < dias.length; j++) {
                String dia = dias[j];
                // Tomar los datos guardados (si hay)
                System.out.println(dia);
                // Guardar hasta mostrar
            }
            // Hacer algo para usar la plantilla, mostrando solo si hay ramos en x horario
        }
    }

}
