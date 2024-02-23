package com.coderhouse.java.DTO;


import java.util.List;

public class PedidoDeCompra {

    private CompradorDTO cliente;
    private List<LineaDeProducto> lineas;
    public void setCliente(CompradorDTO cliente) {
        this.cliente = cliente;
    }

    public long getClienteId(){
        return cliente.getclienteid();

    }

    public void setLineas(List<LineaDeProducto> lineas) {
        this.lineas = lineas;
    }

    public List<LineaDeProducto> getLineas() {
        return lineas;
    }
}
