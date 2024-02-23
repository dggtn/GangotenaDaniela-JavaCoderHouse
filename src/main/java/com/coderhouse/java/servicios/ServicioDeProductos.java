package com.coderhouse.java.servicios;

import com.coderhouse.java.DTO.ActualizarProductoDTO;
import com.coderhouse.java.excepciones.ProductoInexistenteException;
import com.coderhouse.java.modelo.Producto;
import com.coderhouse.java.repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioDeProductos {
    @Autowired
    private ProductoRepositorio productoRepositorio;


    public Producto  obtenerProductoPorId(Long id) {
        Optional<Producto> opcional = productoRepositorio.findById(id);
        return opcional.orElseThrow(ProductoInexistenteException::new);
    }

    public List<Producto>obtenerTodos() {
        return productoRepositorio.findAll();
    }

    public Producto actualizar(Long id, ActualizarProductoDTO productoActualizado) {
        Producto producto = obtenerProductoPorId(id);
        producto.setStock(productoActualizado.getStock());
        producto.setPrecio(productoActualizado.getPrecio());
        producto.setNombre(productoActualizado.getNombre());
        productoRepositorio.save(producto);
        return producto;
    }
}



