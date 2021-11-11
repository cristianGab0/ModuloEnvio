package com.gt.microservicios.app.pedidos.controllers;

import com.gt.microservicios.app.pedidos.models.entity.BitacoraDetPedEnvio;
import com.gt.microservicios.app.pedidos.models.entity.Cliente;
import com.gt.microservicios.app.pedidos.models.entity.DetallePedidos;
import com.gt.microservicios.app.pedidos.models.entity.DetallePedidosId;
import com.gt.microservicios.app.pedidos.models.entity.Pedido;
import com.gt.microservicios.app.pedidos.models.entity.Producto;
import com.gt.microservicios.app.pedidos.dto.DetallePedidoDto;
import com.gt.microservicios.app.pedidos.dto.PedidoDto;
import com.gt.microservicios.app.pedidos.service.BitacoraService;
import com.gt.microservicios.app.pedidos.service.ClienteService;
import com.gt.microservicios.app.pedidos.service.DetallePedidoService;
import com.gt.microservicios.app.pedidos.service.PedidoService;
import com.gt.microservicios.app.pedidos.service.ProductoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cristian
 */
@RestController
public class PedidoController {

    @Autowired
    private PedidoService servicePedido;

    @Autowired
    private ProductoService serviceProducto;

    @Autowired
    private DetallePedidoService serviceDetallePedido;

    @Autowired
    private ClienteService serviceCliente;

    @Autowired
    private BitacoraService serviceBitacora;

    @GetMapping("/pedidos")
    public ResponseEntity<?> obtenerPedidos() {
        Iterable<Pedido> pedidos = servicePedido.findAll();
        List<PedidoDto> pedidosDto = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            String nombreCliente = obtenerNombreCliente(pedido.getIdCliente());
            Double montoTotal = obtenerMontoTotal(pedido.getDetallePedidos());
            List<DetallePedidoDto> detalles = new ArrayList<>();

            for (DetallePedidos detalle : pedido.getDetallePedidos()) {
                DetallePedidoDto detalleDto = convertDetallePedidoDto(detalle);
                detalles.add(detalleDto);
            }

            PedidoDto pedidoDto = new PedidoDto(pedido.getIdpedido(),
                    nombreCliente,
                    pedido.getFechaPedido(),
                    pedido.getStatusPedido(), detalles, montoTotal);
            pedidosDto.add(pedidoDto);
        }

        return ResponseEntity.ok(pedidosDto);
    }

    @GetMapping("/pedido/{idPedido}")
    public ResponseEntity<?> obtenerPedidoById(@PathVariable Long idPedido) {
        Optional<Pedido> p = servicePedido.findById(idPedido);

        if (p.isPresent()) {
            Pedido pedido = p.get();
            String nombreCliente = obtenerNombreCliente(pedido.getIdCliente());
            Double montoTotal = obtenerMontoTotal(pedido.getDetallePedidos());
            List<DetallePedidoDto> detallesDto = new ArrayList<>();

            for (DetallePedidos detalle : pedido.getDetallePedidos()) {
                DetallePedidoDto detalleDto = convertDetallePedidoDto(detalle);
                detallesDto.add(detalleDto);
            }

            PedidoDto pedidoDto = new PedidoDto(pedido.getIdpedido(),
                    nombreCliente,
                    pedido.getFechaPedido(),
                    pedido.getStatusPedido(), detallesDto, montoTotal);

            return ResponseEntity.ok(pedidoDto);

        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("pedido/{idEnvio}")
    public ResponseEntity<?> actualizarPedido(@RequestBody PedidoDto pedido, @PathVariable Long idEnvio) {

        Producto producto = validarCantidadStock(pedido.getDetallePedidos());

        if (producto != null) {
            return new ResponseEntity<>("No hay suficiente stock del producto: " + producto.getDescripcionProducto(), HttpStatus.OK);
        } else {
            for (DetallePedidoDto detallePedido : pedido.getDetallePedidos()) {

                DetallePedidosId id = detallePedido.getId();

                Optional<DetallePedidos> detalleTemp = serviceDetallePedido.findById(id);
                if (detalleTemp.isEmpty()) {
                    return ResponseEntity.notFound().build();
                } else {
                    DetallePedidos detalle = detalleTemp.get();

                    actualizarStock(detallePedido.getId().getIdProducto(), detallePedido.getCantidadEnviada());

                    detalle.setCantidadEnviada(detallePedido.getCantidadEnviada());
                    BitacoraDetPedEnvio bitacora = new BitacoraDetPedEnvio(detallePedido.getId().getIdPedido(),
                            detallePedido.getId().getIdProducto(), idEnvio, detallePedido.getCantidadEnviada());
                    serviceBitacora.save(bitacora);
                    serviceDetallePedido.save(detalle);

                }
            }

            Optional<Pedido> p = servicePedido.findById(pedido.getIdpedido());
            if (p.isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {

                Pedido pedidoDb = p.get();

                pedidoDb.setStatusPedido(pedido.getStatusPedido());

                return ResponseEntity.status(HttpStatus.CREATED).body(servicePedido.save(pedidoDb));
            }
        }
    }

    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<?> obtenerProductoPorId(@PathVariable Long idProducto) {
        Optional<Producto> producto = serviceProducto.findById(idProducto);
        if (producto.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(producto);
        }
    }

    @GetMapping("/productos/pedido/{idPedido}")
    public ResponseEntity<?> obtenerProductosByIdPedido(@PathVariable Long idPedido) {
        Iterable<DetallePedidos> detalleDb = serviceDetallePedido.findDetalleByIdPedido(idPedido);
        List<DetallePedidoDto> detalleDto = new ArrayList<>();

        for (DetallePedidos detallePedidos : detalleDb) {
            detalleDto.add(convertDetallePedidoDto(detallePedidos));
        }
        return ResponseEntity.ok(detalleDto);
    }

    @GetMapping("/clientes")
    public ResponseEntity<?> obtenerClientes() {
        return ResponseEntity.ok(serviceCliente.findAll());
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<?> obtenerClienteById(@PathVariable Long idCliente) {
        Optional<Cliente> cliente = serviceCliente.findById(idCliente);
        return ResponseEntity.ok(cliente);
    }

    
    
    @PutMapping("anular/{idEnvio}")
    public void anular(@PathVariable Long idEnvio) {
        List<BitacoraDetPedEnvio> bitacoras = serviceBitacora.findBitacoraByIdEnvio(idEnvio);
        
        for (BitacoraDetPedEnvio bitacora : bitacoras) {
            //actualizar la cantidad enviada
            DetallePedidosId id = new DetallePedidosId(bitacora.getId_pedido(), bitacora.getId_producto());
            Optional<DetallePedidos> d = serviceDetallePedido.findById(id);
            if(d.isPresent()){
                DetallePedidos detalle = d.get();
                detalle.setCantidadEnviada(detalle.getCantidadEnviada()-bitacora.getCantidad_enviada());
                serviceDetallePedido.save(detalle);
            }
            //actualizar el stock
            Optional<Producto> p = serviceProducto.findById(bitacora.getId_producto());
            if(p.isPresent()){
                Producto producto = p.get();
                producto.setCantidadStock(producto.getCantidadStock()+bitacora.getCantidad_enviada());
                serviceProducto.save(producto);
            }
        }
        
    }

    
    
    
    
    
    public String obtenerNombreCliente(Long idCliente) {
        Optional<Cliente> c = serviceCliente.findById(idCliente);
        if (c.isPresent()) {
            Cliente cliente = c.get();
            return cliente.getNombre();
        } else {
            return null;
        }
    }

    public Double obtenerMontoTotal(Set<DetallePedidos> detallePedidos) {
        Double montoTotal = 0.0;
        for (DetallePedidos detalle : detallePedidos) {
            Optional<Producto> p = serviceProducto.findById(detalle.getId().getIdProducto());
            if (p.isPresent()) {
                Producto producto = p.get();
                Double precio = producto.getPrecio();
                montoTotal += (detalle.getCantidadEnviada() * precio);
            }
        }
        return montoTotal;
    }

    public DetallePedidoDto convertDetallePedidoDto(DetallePedidos detalle) {
        Optional<Producto> p = serviceProducto.findById(detalle.getId().getIdProducto());
        if (p.isPresent()) {
            Producto producto = p.get();
            DetallePedidoDto detalleDto = new DetallePedidoDto(detalle.getId(), producto,
                    detalle.getCantidadEnviada(),
                    detalle.getCantidadPedida());
            return detalleDto;
        }
        return null;
    }

    public void actualizarStock(Long idProducto, Long cantidadEnviada) {
        Optional<Producto> p = serviceProducto.findById(idProducto);

        Producto producto = p.get();

        Long cantidadStockt = producto.getCantidadStock();
        producto.setCantidadStock(cantidadStockt - cantidadEnviada);

        serviceProducto.save(producto);
    }

    public Producto validarCantidadStock(List<DetallePedidoDto> detallePedidos) {
        for (DetallePedidoDto detalle : detallePedidos) {
            Optional<Producto> p = serviceProducto.findById(detalle.getId().getIdProducto());

            Producto producto = p.get();
            Long cantidadStockt = producto.getCantidadStock();

            if (cantidadStockt < detalle.getCantidadEnviada()) {
                return producto;
            }
        }
        return null;
    }
    
}
