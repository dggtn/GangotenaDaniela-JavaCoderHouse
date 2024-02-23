package com.coderhouse.java.DTO;


import java.time.LocalDateTime;

public class ComprobanteDTO {

    private LocalDateTime fecha;
    private double importe;

    private int cantidadTotal;

    private String nombreCompletoCliente;

    private Long id;

    public void setFecha( LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public  LocalDateTime getFecha() {
        return fecha;
    }
    public void setImporte( double importe) {
        this.importe = importe;
    }

    public  double getImporte() {
        return importe;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }
    public  int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setNombreCompletoCliente(String nombreCompletoCliente) {
        this.nombreCompletoCliente = nombreCompletoCliente;
    }

    public String getNombreCompletoCliente() {
        return nombreCompletoCliente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}


