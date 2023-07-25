package com.example.usm_planner;

import java.util.ArrayList;
import java.util.Objects;

interface Consts{
    String[] head = {"Bloques","Lunes","Martes","Miércoles","Jueves","Viernes"};
    String[] bloques = {"1-2","3-4","5-6","7-8","9-10","11-12","13-14","15-16","17-18","19-20"};
    String[] horas = {"8:15-9:25","9:35-10:45","10:55-12:05","12:15-13:25","14:30-15:40","15:50-17:00","17:10-18:20","18:30-19:40","19:50-21:00","21:10-22:20"};

}
public class Horario {
    private String nombre;
    private ArrayList<Asignatura> asignaturas;

    public Horario(String nombre) {
        this.nombre = nombre;
    }
    //gets
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public String[] getNombreAsignaturas(){
        ArrayList<String> nombres = new ArrayList<String>();
        ArrayList<Asignatura> as = getAsignaturas();
        for (Asignatura a: as) {
            String nombre = a.getNombre();
            if(!(nombres.contains(nombre))){
                nombres.add(nombre);
            }
        }
        return nombres.toArray(new String[0]);
    }

    public ArrayList<Asignatura> getAsignaturasPorDia(String dia){
        ArrayList<Asignatura> as = getAsignaturas();
        ArrayList<Asignatura> asign = new ArrayList<Asignatura>();
        for(Asignatura a: as){
            String diaa = a.getDia();
            if(Objects.equals(diaa, dia)){
                asign.add(a);
            }
        }
        return asign;
    }

    public String[] getBloquesPorDia(String dia){
        ArrayList<Asignatura> asignaturas1 = getAsignaturasPorDia(dia);
        ArrayList<String> list = new ArrayList<>();
        for(Asignatura a: asignaturas1){
            String nombre = a.getNombre();
            String sala = a.getSala();
            String b = nombre+"\n"+sala;
            list.add(b);
        }
        return list.toArray(new String[0]);
    }

    //sets
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public void addAsignatura(String nombre, String dia, String bloque, String sala){
        Asignatura as = new Asignatura(nombre,sala,bloque,dia);
        ArrayList<Asignatura> asign = getAsignaturas();
        int j = 0;
        for (int i = 0; i < asign.size(); i++) {
            Asignatura a = asign.get(i);
            String bloq = a.getBloque();
            String d = a.getDia();
            if(d == dia){
                if(bloq.charAt(0) < bloque.charAt(0)){
                    j = i;
                }
            }
        }
        asign.add(j,as);
    }

}
