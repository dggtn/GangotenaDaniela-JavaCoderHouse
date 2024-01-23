package com.coderhouse.java.repositorios;

import com.coderhouse.java.modelo.ProductoVenta;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductoVentaRepositorio extends JpaRepository<ProductoVenta, Long> {
}

