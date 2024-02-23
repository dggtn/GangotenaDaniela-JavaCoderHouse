package com.coderhouse.java.servicios;
import com.coderhouse.java.DTO.ComprobanteDTO;
import com.coderhouse.java.DTO.LineaDeProducto;
import com.coderhouse.java.DTO.PedidoDeCompra;
import com.coderhouse.java.excepciones.ClienteInexistenteException;
import com.coderhouse.java.excepciones.ProductoInexistenteException;
import com.coderhouse.java.excepciones.StockInsuficienteException;
import com.coderhouse.java.excepciones.VentaInexistenteException;
import com.coderhouse.java.modelo.Cliente;
import com.coderhouse.java.modelo.Producto;
import com.coderhouse.java.modelo.ProductoVenta;
import com.coderhouse.java.modelo.Venta;
import com.coderhouse.java.repositorios.ClienteRepositorio;
import com.coderhouse.java.repositorios.ProductoRepositorio;
import com.coderhouse.java.repositorios.ProductoVentaRepositorio;
import com.coderhouse.java.repositorios.VentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioDeVenta {

    @Autowired
    private ServicioDeFechas servicioDeFechas;
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Autowired
    private VentaRepositorio ventaRepositorio;
    @Autowired
    private ProductoVentaRepositorio productoVentaRepositorio;

    @Transactional
    public ComprobanteDTO registrarVenta(PedidoDeCompra pedidoDeCompra) {

        LocalDateTime ahora = servicioDeFechas.obtenerFechaActual();
        ComprobanteDTO comprobanteDTO = new ComprobanteDTO();

        Optional<Cliente> clienteOpcional = clienteRepositorio.findById(pedidoDeCompra.getClienteId());
        Cliente cliente = clienteOpcional.orElseThrow(ClienteInexistenteException::new);
        comprobanteDTO.setNombreCompletoCliente(cliente.getNombre() + " " + cliente.getApellido());

        Venta venta = new Venta();
        venta.setCliente(cliente);
        venta.setFecha(Date.from(ahora.atZone(ZoneId.systemDefault()).toInstant()));
        ventaRepositorio.save(venta);

        double importeTotal = 0.0;
        int cantidadTotal = 0;

        for(LineaDeProducto linea: pedidoDeCompra.getLineas()) {

            Long idProducto = linea.getProducto().getProductoid();
            Optional<Producto> productoOpcional =  productoRepositorio.findById(idProducto);
            Producto producto = productoOpcional.orElseThrow(ProductoInexistenteException::new);
            int cantidad = linea.getCantidad();

            if (cantidad > producto.getStock()) {
                throw new StockInsuficienteException();
            }

            importeTotal += producto.getPrecio().multiply(new BigDecimal(cantidad)).doubleValue();
            cantidadTotal += cantidad;

            producto.setStock(producto.getStock() - cantidad);
            productoRepositorio.save(producto);

            ProductoVenta productoVenta = new ProductoVenta();
            productoVenta.setVenta(venta);
            productoVenta.setProducto(producto);
            productoVenta.setCantidadComprada(cantidad);
            productoVenta.setPrecioUnitario(producto.getPrecio());
            productoVentaRepositorio.save(productoVenta);
        }

        comprobanteDTO.setFecha(ahora);
        comprobanteDTO.setImporte(importeTotal);
        comprobanteDTO.setCantidadTotal(cantidadTotal);
        comprobanteDTO.setId(venta.getId());
        return comprobanteDTO;
    }

    public ComprobanteDTO obtenerComprobantePorId(Long id) {
        ComprobanteDTO comprobanteDTO = new ComprobanteDTO();
        Venta venta = ventaRepositorio.findById(id).orElseThrow(VentaInexistenteException::new);

        comprobanteDTO.setId(venta.getId());
        comprobanteDTO.setFecha(venta.getFecha().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime());

        List<ProductoVenta> productosVendidos = productoVentaRepositorio.findByVenta(venta);
        double importeTotal = 0.0;
        int cantidadTotal = 0;
        for(ProductoVenta productoVendido :productosVendidos) {
            int cantidad = productoVendido.getCantidadComprada();
            importeTotal += productoVendido.getPrecioUnitario().multiply(new BigDecimal(cantidad)).doubleValue();
            cantidadTotal += cantidad;
        }

        comprobanteDTO.setImporte(importeTotal);
        comprobanteDTO.setCantidadTotal(cantidadTotal);

        Optional<Cliente> clienteOptional = clienteRepositorio.findById(venta.getCliente().getId());
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            comprobanteDTO.setNombreCompletoCliente(cliente.getNombre() + " " + cliente.getApellido());
        }


        return comprobanteDTO;
    }
}



