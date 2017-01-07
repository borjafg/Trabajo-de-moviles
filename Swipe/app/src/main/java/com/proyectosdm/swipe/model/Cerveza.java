package com.proyectosdm.swipe.model;

public class Cerveza {

    public String codigo;
    public String nombre;
    public String descricpion;
    public String estilo;
    public String graduacion;
    public String malta;
    public String lupulo;

    public Cerveza() {

    }

    public Cerveza(String codigo, String nombre, String descricpion, String estilo, String graduacion, String malta, String lupulo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descricpion = descricpion;
        this.estilo = estilo;
        this.graduacion = graduacion;
        this.malta = malta;
        this.lupulo = lupulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescricpion() {
        return descricpion;
    }

    public String getEstilo() {
        return estilo;
    }

    public String getGraduacion() {
        return graduacion;
    }

    public String getMalta() {
        return malta;
    }

    public String getLupulo() {
        return lupulo;
    }
}
