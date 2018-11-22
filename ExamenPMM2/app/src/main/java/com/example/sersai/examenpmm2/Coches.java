package com.example.sersai.examenpmm2;

import java.io.Serializable;

public class Coches implements Serializable {
    private int id;
    private String modelo;
    private String marca;
    private int precioTotal;
    private int imagen;

    public Coches (int id, String modelo, String marca, int precioTotal, int imagen) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.precioTotal = precioTotal;
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

    public int getPrecioTotal() {
        return precioTotal;
    }

    public int getImagen() {
        return imagen;
    }

    @Override
    public String toString() {
        return "Modelo: " + this.modelo + "Marca: " + this.marca + "Precio total: " + precioTotal;
    }
}