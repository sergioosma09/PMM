package com.example.sersai.examenprueba;

public class Zona {
        private String zona;
        private String continente;
        private int precio;

        public Zona(String zon, String contin, int prec) {
            zona=zon;
            continente = contin;
            precio = prec;
        }

        public String getZona() {
            return zona;
        }

        public String getContinente() {
            return continente;
        }

        public int getPrecio() {
            return precio;
        }
    }


