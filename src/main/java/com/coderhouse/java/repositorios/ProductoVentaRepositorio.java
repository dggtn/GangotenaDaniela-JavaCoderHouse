package com.coderhouse.java.repositorios;

import com.coderhouse.java.modelo.Producto;
import com.coderhouse.java.modelo.ProductoVenta;
import com.coderhouse.java.modelo.Venta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ProductoVentaRepositorio extends JpaRepository<ProductoVenta, Long> {
    List<ProductoVenta> findByVenta(Venta venta);
}

