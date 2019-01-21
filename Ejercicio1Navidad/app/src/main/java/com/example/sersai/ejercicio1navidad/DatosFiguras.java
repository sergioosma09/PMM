package com.example.sersai.ejercicio1navidad;

import java.io.Serializable;

public class DatosFiguras implements Serializable {

    public int altura, base, imagen;
    public String forma;

    public DatosFiguras(String forma, int altura, int base, int imagen){
        this.forma = forma;
        this.altura = altura;
        this.base = base;
        this.imagen = imagen;
    }

    public int getImagen() {
        return imagen;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public String getForma() {
        return forma;
    }

}