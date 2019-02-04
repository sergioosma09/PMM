package com.example.sersai.proyectopmmfinall;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String name, edad, descripcion;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
