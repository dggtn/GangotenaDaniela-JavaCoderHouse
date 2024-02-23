package com.coderhouse.java.DTO;

import java.math.BigDecimal;

public class ActualizarProductoDTO {

    private BigDecimal precio;
    private String nombre;
    private int stock;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }
}
