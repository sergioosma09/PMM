package com.example.sersai.adaptadortitulares;

import java.io.Serializable;

public class Titular implements Serializable{
    private String titulo;
    private String subtitulo;
    private int imagen;

    public Titular(String tit, String sub, int img1) {
        titulo = tit;
        subtitulo = sub;
        imagen = img1;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubTitulo() {
        return subtitulo;
    }

    public int getImagen() {
        return imagen;
    }
}