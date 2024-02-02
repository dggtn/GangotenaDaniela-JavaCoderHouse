package com.coderhouse.java.controladores;
import com.coderhouse.java.modelo.Producto;
import com.coderhouse.java.servicios.ServicioDeProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ControladorDeProductos {

    @Autowired
    private ServicioDeProductos servicioDeProductos;

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable(name = "id")Long id) {
        return this.servicioDeProductos.obtenerProductoPorId(id);
    }
    @GetMapping()
    public List<Producto> obtenerTodos() {
        return this.servicioDeProductos.obtenerTodos();
    }

    // Endpoint que devuelva todos los clientes
    // Crear un ControladorDeProductos y armar endpoints para:
    // Obtener todos los productos
    // Obtener producto por id

}

