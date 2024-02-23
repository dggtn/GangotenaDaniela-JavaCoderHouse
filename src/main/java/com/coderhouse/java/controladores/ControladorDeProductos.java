package com.coderhouse.java.controladores;
import com.coderhouse.java.DTO.ActualizarProductoDTO;
import com.coderhouse.java.excepciones.ProductoInexistenteException;
import com.coderhouse.java.modelo.Producto;
import com.coderhouse.java.servicios.ServicioDeProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable(name = "id") Long id, @RequestBody ActualizarProductoDTO productoActualizado) {
        ResponseEntity<?> respuesta = null;
        try {

            Producto producto = servicioDeProductos.actualizar(id, productoActualizado);
            respuesta = ResponseEntity.ok(producto);

        } catch (ProductoInexistenteException e) {
            respuesta = ResponseEntity.badRequest().body("Producto inexistente");
        } catch (Exception e) {
            respuesta = ResponseEntity.internalServerError().body("Ocurrio un error inesperado");
        }

        return respuesta;
    }

    // Endpoint que devuelva todos los clientes
    // Crear un ControladorDeProductos y armar endpoints para:
    // Obtener todos los productos
    // Obtener producto por id

}

