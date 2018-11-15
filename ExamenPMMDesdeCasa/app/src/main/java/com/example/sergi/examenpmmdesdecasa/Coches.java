package com.example.sergi.examenpmmdesdecasa;

import java.io.Serializable;

public class Coches implements Serializable{
    public String nombre, marca;
    public float precio, precioTotal;
    public int horas, imagen;
    public boolean seguro, aire, gps, radio;

    public Coches(String modelo, String marca, float precio , float precioTotal, int horas, boolean seguro, boolean aire, boolean gps, boolean radio, int imagen){
        this.nombre = modelo;
        this.marca = marca;
        this.precio = precio;
        this.horas = horas;
        this.seguro = seguro;
        this.aire = aire;
        this.gps = gps;
        this.radio = radio;
        this.imagen = imagen;
        this.precioTotal = precioTotal;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }



    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    public boolean isAire() {
        return aire;
    }

    public void setAire(boolean aireAcon) {
        this.aire = aireAcon;
    }

    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }

    public boolean isRadio() {
        return radio;
    }

    public void setRadio(boolean radio) {
        this.radio = radio;
    }
}
