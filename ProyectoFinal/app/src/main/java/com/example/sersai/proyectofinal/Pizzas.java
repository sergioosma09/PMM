package com.example.sersai.proyectofinal;
import java.io.Serializable;

    public class Pizzas implements Serializable{
        public String nombre;
        public float precio, precioTotal;
        public int imagen;
        public boolean seguro,salsa, patatas, bebida, domicilio;

        public Pizzas(String nombre,float precio , float precioTotal, boolean seguro,boolean domicilio ,boolean salsa, boolean patatas, boolean bebida, int imagen){
            this.nombre = nombre;
            this.precio = precio;
            this.salsa = salsa;
            this.patatas = patatas;
            this.bebida = bebida;
            this.imagen = imagen;
            this.precioTotal = precioTotal;
            this.seguro=seguro;
            this.domicilio=domicilio;
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


        public float getPrecio() {
            return precio;
        }

        public void setPrecio(float precio) {
            this.precio = precio;
        }


        public boolean isSalsa() {
            return salsa;
        }

        public void setSalsa(boolean salsa) {
            this.salsa = salsa;
        }

        public boolean isPatatas() {
            return patatas;
        }

        public void setPatatas(boolean patatas) {
            this.patatas = patatas;
        }

        public boolean isBebida() {
            return bebida;
        }

        public void setBebida(boolean bebida) {
            this.bebida = bebida;
        }

        public boolean isSeguro() {
            return seguro;
        }

        public void setSeguro(boolean seguro) {
            this.seguro = seguro;
        }

        public boolean isDomicilio() {
            return domicilio;
        }
        public void setDomicilio(boolean domicilio){
            this.domicilio=domicilio;
        }
    }
