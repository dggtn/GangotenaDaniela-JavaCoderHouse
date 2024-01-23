package com.coderhouse.java.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;

@Entity
@Table(name="PRODUCTOVENTA")
public class ProductoVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

    @Column(name = "cantidad_comprada")
    private int cantidadComprada;

    @Digits(integer = 9, fraction = 2)
    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }
}
