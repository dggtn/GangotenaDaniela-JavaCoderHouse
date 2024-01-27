package com.coderhouse.java;

import com.coderhouse.java.modelo.Cliente;
import com.coderhouse.java.modelo.Producto;
import com.coderhouse.java.modelo.ProductoVenta;
import com.coderhouse.java.modelo.Venta;
import com.coderhouse.java.repositorios.ClienteRepositorio;
import com.coderhouse.java.repositorios.ProductoRepositorio;
import com.coderhouse.java.repositorios.ProductoVentaRepositorio;
import com.coderhouse.java.repositorios.VentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class Runner implements ApplicationRunner {
    @Autowired
    private ClienteRepositorio repositorio;

    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Autowired
    private VentaRepositorio ventaRepositorio;
    @Autowired
    private ProductoVentaRepositorio productoVentarepositorio;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Date fechaDeNacimiento = Date.from(LocalDate.parse("1997-06-06")
                                                    .atStartOfDay()
                                                    .atZone(ZoneId.systemDefault()).toInstant());
        Cliente cliente = new Cliente();
        cliente.setNombre("Daniela");
        cliente.setApellido("Gangotena");
        cliente.setEmail("dh@yahoo.com");
        cliente.setFechaDeNacimiento(fechaDeNacimiento);
        repositorio.save(cliente);

        Producto producto = new Producto();
        producto.setNombre("Shampoo natural jazmin rizos definidos");
        producto.setStock(645);
        producto.setPrecio(BigDecimal.valueOf(1500));
        productoRepositorio.save(producto);

        Venta venta = new Venta();
        venta.setFecha(new Date());
        venta.setCliente(cliente);

        ventaRepositorio.save(venta);

        ProductoVenta productoVenta= new ProductoVenta();
        productoVenta.setProducto(producto);
        productoVenta.setVenta(venta);
        productoVenta.setCantidadComprada(3);
        productoVenta.setPrecioUnitario(BigDecimal.valueOf(3000));
        productoVentarepositorio.save(productoVenta);
    }
}
