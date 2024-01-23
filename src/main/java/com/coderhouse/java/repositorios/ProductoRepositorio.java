package com.coderhouse.java.repositorios;
import org.springframework.stereotype.Repository;
import com.coderhouse.java.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
}
