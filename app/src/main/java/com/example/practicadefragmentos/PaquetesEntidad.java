package com.example.practicadefragmentos;

import java.io.Serializable;

public class PaquetesEntidad implements Serializable {

    private String Nombre;
    private String Info;
    private String Descripcion;
    private int ImagenID;
    private int ImagenDetalle;

    public PaquetesEntidad(){

    }

    public PaquetesEntidad(String nombre, String info, String descripcion, int imagenID, int imagenDetalle){
        this.Nombre = nombre;
        this.Info = info;
        this.Descripcion = descripcion;
        this.ImagenID = imagenID;
        this.ImagenDetalle = imagenDetalle;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public int getImagenID() {
        return ImagenID;
    }

    public void setImagenID(int imagenID) {
        ImagenID = imagenID;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getImagenDetalle() {
        return ImagenDetalle;
    }

    public void setImagenDetalle(int imagenDetalle) {
        ImagenDetalle = imagenDetalle;
    }
}
