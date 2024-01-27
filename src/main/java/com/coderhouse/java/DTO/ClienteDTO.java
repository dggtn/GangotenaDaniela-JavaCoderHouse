package com.coderhouse.java.DTO;

import jakarta.persistence.*;

import java.util.Date;


public class ClienteDTO {

    private String nombre;

    private String apellido;
    private Integer edad;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }


    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
    }
}


