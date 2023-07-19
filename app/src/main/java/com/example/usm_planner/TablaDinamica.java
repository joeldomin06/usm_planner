package com.example.usm_planner;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class TablaDinamica {
    private final TableLayout tableLayout;
    private final Context context;
    private String[] header;
    private ArrayList<String[]> data;
    private TableRow tableRow;
    private TextView texto_celda;
    private final int ancho;
    private final int alto;
    private int[] colores;

    public TablaDinamica(TableLayout tableLayout, Context context, String[] header, ArrayList<String[]> data, int[] colores, int ancho, int alto){
        this.tableLayout = tableLayout;
        this.context = context;
        this.header = header;
        this.data = data;
        this.colores = colores;
        this.ancho = ancho;
        this.alto = alto;
    }

    private void newRow(){
        tableRow = new TableRow(context);
    }

    private void newCell(){
        texto_celda = new TextView(context);
        texto_celda.setGravity(Gravity.CENTER);
        // Tamaño del texto
        texto_celda.setTextSize(25);
    }

    public void createHeader(){
        int columnas = 0;
        newRow();
        while (columnas < ancho){
            newCell();
            texto_celda.setText(header[columnas++]);
            texto_celda.setBackgroundColor(Color.rgb(255, 128, 0));
            tableRow.addView(texto_celda,newTableRowParams());
        }
        tableLayout.addView(tableRow);
    }

    public void CreateDataTable(){
        int contador = 0;
        String[] fila;
        for (int filas = 1; filas < alto; filas++){
            // Definición de una fila en base a columnas
            newRow();
            for (int columnas = 0; columnas < ancho; columnas++){
                // Definición de una celda de la tabla
                newCell();
                fila = data.get(filas - 1);
                texto_celda.setText(fila[columnas]);
                // Bloque
                if (columnas == 0){
                    texto_celda.setBackgroundColor(Color.rgb(243,182,93));
                }
                // Ramos encontrados
                else if (!fila[columnas].equals("\n")){
                    texto_celda.setBackgroundColor(colores[contador++]);
                }
                // No hay ramos
                else{
                    texto_celda.setBackgroundColor(Color.rgb(247,208,151));
                }
                tableRow.addView(texto_celda,newTableRowParams());
            }
            tableLayout.addView(tableRow);
        }

    }
    private TableRow.LayoutParams newTableRowParams(){
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        // Parámetros de las dimensiones respecto a los bordes
        params.setMargins(5,3,5,3);
        params.weight = 1;
        return  params;
    }
}

