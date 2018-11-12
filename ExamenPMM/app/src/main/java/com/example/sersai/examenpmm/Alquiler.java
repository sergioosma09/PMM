package com.example.sersai.examenpmm;

import java.io.Serializable;
public class Alquiler implements Serializable{
    public String modelo,seguro,marca;
    public float precioHora;
    public float tiempo;
    public boolean extras;
    public float precio;
    public int imagen;
    public Alquiler(String modelo,String marca, float precio, float tiempo, boolean extras, String seguro, float precioHora, boolean b, int imagen){
        this.modelo = modelo;
        this.marca=marca;
        this.seguro = seguro;
        this.precio = precio;
        this.precioHora=precioHora;
        this.tiempo = tiempo;
        this.extras = extras;
        this.imagen = imagen;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public String getModelo(){
        return this.modelo;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public String getMarca(){
        return this.marca;
    }
    public void setSeguro(String seguro){
        this.seguro = seguro;
    }
    public String getSeguro(){
        return this.seguro;
    }
    public void setPrecio(int precio){
        this.precio = precio;
    }
    public float getPrecio(){
        return this.precio;
    }
    public void setPrecioHora(int precioHora){
        this.precioHora = precioHora;
    }
    public float getPrecioHora(){
        return this.precioHora;
    }
    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }
    public float getTiempo(){
        return this.tiempo;
    }
    public void setExtras(boolean extras){
        this.extras = extras;
    }
    public boolean getExtras(){
        return this.extras;
    }

    public void setImagen(int imagen){
        this.imagen = imagen;
    }
    public int getImagen(){
        return this.imagen;
    }
    public String toString(){
        return "Modelo: " + this.modelo + ". Precio por hora: " + this.precioHora + " Extras: " + this.extras
                + ". Tiempo: " + this.tiempo + ". Coste Total: " + this.precio;
    }
}