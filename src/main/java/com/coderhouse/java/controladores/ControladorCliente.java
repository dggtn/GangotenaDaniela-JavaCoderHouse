package com.coderhouse.java.controladores;

import com.coderhouse.java.DTO.ClienteDTO;
import com.coderhouse.java.modelo.Cliente;
import com.coderhouse.java.modelo.Producto;
import com.coderhouse.java.servicios.ServicioDeClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ControladorCliente {

    @Autowired
    private ServicioDeClientes servicioDeClientes;

    @GetMapping("/{id}")
    public ClienteDTO obtenerClientePorId(@PathVariable(name = "id")Long id) {
        return this.servicioDeClientes.obtenerClientePorId(id);
    }
    @GetMapping
    public List<Cliente> obtenerTodos() {
        return this.servicioDeClientes.obtenerClientes();
    }
}

