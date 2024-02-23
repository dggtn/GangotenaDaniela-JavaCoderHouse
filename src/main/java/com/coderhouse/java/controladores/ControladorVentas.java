package com.coderhouse.java.controladores;

import com.coderhouse.java.DTO.ComprobanteDTO;
import com.coderhouse.java.DTO.PedidoDeCompra;
import com.coderhouse.java.excepciones.ClienteInexistenteException;
import com.coderhouse.java.excepciones.ProductoInexistenteException;
import com.coderhouse.java.excepciones.StockInsuficienteException;
import com.coderhouse.java.excepciones.VentaInexistenteException;
import com.coderhouse.java.servicios.ServicioDeVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ventas")
public class ControladorVentas {
    @Autowired
    private ServicioDeVenta servicioDeVenta;
    @PostMapping
    public ResponseEntity<?> realizarVenta(@RequestBody PedidoDeCompra pedidoDeCompra) {

        ResponseEntity<?> respuesta = null;

        try {

            ComprobanteDTO comprobante = servicioDeVenta.registrarVenta(pedidoDeCompra);
            respuesta = ResponseEntity.ok(comprobante);

        } catch (ClienteInexistenteException e) {
            respuesta = ResponseEntity.badRequest().body("Cliente no encontrado");
        } catch (ProductoInexistenteException e) {
            respuesta = ResponseEntity.badRequest().body("Alguno de los productos solicitados no existe");
        } catch (StockInsuficienteException e) {
            respuesta = ResponseEntity.badRequest().body("El stock actual no es suficiente para completar la venta");
        }

        return respuesta;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> obtenerComprobante(@PathVariable(name = "id") Long id) {

        ResponseEntity<?> respuesta = null;
        try {
                ComprobanteDTO comprobante = servicioDeVenta.obtenerComprobantePorId(id);
                respuesta = ResponseEntity.ok(comprobante);
        } catch(VentaInexistenteException e) {
            respuesta = ResponseEntity.badRequest().body("El comprobante solicitado no existe");
        } catch (Exception e) {
            respuesta = ResponseEntity.internalServerError().body("Ocurrió un error inesperado");
        }

        return respuesta;
    }
}

