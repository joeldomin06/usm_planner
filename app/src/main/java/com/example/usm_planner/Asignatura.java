package com.example.usm_planner;

public class Asignatura {
    private String nombre;
    private String sala;
    private String bloque;
    private String dia;

    public Asignatura(String nombre, String sala, String bloque, String dia) {
        this.nombre = nombre;
        this.sala = sala;
        this.bloque = bloque;
        this.dia = dia;
    }
    //gets
    public String getNombre() {
        return nombre;
    }

    public String getBloque() {
        return bloque;
    }

    public String getDia() {
        return dia;
    }

    public String getSala() {
        return sala;
    }
    //sets
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}
