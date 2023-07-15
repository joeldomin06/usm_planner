package com.example.usm_planner;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class TablaDinamica {
    private TableLayout tableLayout;
    private Context context;
    private String[] header;
    private ArrayList<String[]> data;
    private TableRow tableRow;
    private TextView texto_celda;

    public TablaDinamica(TableLayout tableLayout, Context context){
        this.tableLayout = tableLayout;
        this.context = context;
    }

    public void addHeader(String[] header){
        this.header = header;
    }

    public void addData(ArrayList<String[]> data){
        this.data = data;
    }

    private void newRow(){
        tableRow = new TableRow(context);
    }

    private void newCell(){
        texto_celda = new TextView(context);
        texto_celda.setGravity(Gravity.CENTER);
        texto_celda.setTextSize(25);
    }

    private void createHeader(){
        int columnas = 0;
        newRow();
        while (columnas < header.length){
            newCell();
            texto_celda.setText(header[columnas++]);
            texto_celda.setBackgroundColor(Color.rgb(255, 128, 0));
            tableRow.addView(texto_celda,newTableRowParams());
        }
        tableLayout.addView(tableRow);
    }

    private void CreateDataTable(){
        String info;
        for (int filas = 1; filas <= header.length; filas++){
            newRow();
            for (int columnas = 0; columnas <= header.length; columnas++){
                newCell();
                String[] fila = data.get(filas - 1);
                info = (columnas < fila.length)?fila[columnas]:"";
                texto_celda.setText(info);
                texto_celda.setBackgroundColor(Color.rgb(247, 208, 151));
                tableRow.addView(texto_celda,newTableRowParams());
            }
            tableLayout.addView(tableRow);
        }
    }
    private TableRow.LayoutParams newTableRowParams(){
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.setMargins(1,1,1,1);
        params.weight = 1;
        return  params;
    }
}

