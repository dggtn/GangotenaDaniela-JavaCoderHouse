package com.coderhouse.java.controladores;

import com.coderhouse.java.DTO.ClienteDTO;
import com.coderhouse.java.modelo.Cliente;
import com.coderhouse.java.servicios.ServicioDeClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ControladorCliente {

    @Autowired
    private ServicioDeClientes servicioDeClientes;

    @GetMapping("/{id}")
    public ClienteDTO obtenerClientePorId(@PathVariable(name = "id")Long id) {
        return this.servicioDeClientes.obtenerClientePorId(id);
    }


    //nombre,apellido,edad
    //servicio debe obtener modelo y pasar al controller ¨clienteResponse¨
}

