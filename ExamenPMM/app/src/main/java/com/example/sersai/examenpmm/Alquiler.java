package com.example.sersai.examenpmm;

import java.io.Serializable;

public class Alquiler implements Serializable {
    private int id;
    private String modelo;
    private String marca;
    private float precio;
    private int imagen;

    public Alquiler (int id, String modelo, String marca, float precio, int imagen) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setPrecio(float precio){
        this.precio=precio;
    }
    public float getPrecio() {
        return precio;
    }

    public int getImagen() {
        return imagen;
    }
}