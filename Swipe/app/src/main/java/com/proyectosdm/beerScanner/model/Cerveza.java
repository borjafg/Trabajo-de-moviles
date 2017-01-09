package com.proyectosdm.beerScanner.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Cerveza implements Parcelable {

    public String codigo;
    public String nombre;
    public String descripcion;
    public String estilo;
    public double graduacion;
    public String malta;
    public String lupulo;

    public Cerveza() {
    }

    public Cerveza(String codigo, String nombre, String descricpion, String estilo, double graduacion, String malta, String lupulo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descricpion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstilo() {
        return estilo;
    }

    public double getGraduacion() {
        return graduacion;
    }

    public String getMalta() {
        return malta;
    }

    public String getLupulo() {
        return lupulo;
    }

    // ==========================================
    // Parcelable
    // ==========================================

    protected Cerveza(Parcel in) {
        this.codigo = in.readString();
        this.nombre = in.readString();
        this.descripcion = in.readString();
        this.estilo = in.readString();
        this.graduacion = in.readDouble();
        this.malta = in.readString();
        this.lupulo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(codigo);
        dest.writeString(nombre);
        dest.writeString(descripcion);
        dest.writeString(estilo);
        dest.writeDouble(graduacion);
        dest.writeString(malta);
        dest.writeString(lupulo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Cerveza> CREATOR = new Parcelable.Creator<Cerveza>() {
        @Override
        public Cerveza createFromParcel(Parcel in) {
            return new Cerveza(in);
        }

        @Override
        public Cerveza[] newArray(int size) {
            return new Cerveza[size];
        }
    };
}