package com.coderhouse.java.DTO;


public class LineaDeProducto {

    private int cantidad;
    private ProductoDTO producto;

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public ProductoDTO getProducto() {
        return producto;
    }
}
