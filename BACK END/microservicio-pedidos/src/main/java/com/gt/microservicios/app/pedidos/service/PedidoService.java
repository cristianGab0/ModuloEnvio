package com.gt.microservicios.app.pedidos.service;

import com.gt.microservicios.app.pedidos.models.entity.Cliente;
import com.gt.microservicios.app.pedidos.models.entity.Pedido;
import com.gt.microservicios.app.pedidos.models.entity.Producto;
import java.util.Optional;

/**
 *
 * @author Cristian
 */
public interface PedidoService {
    public Iterable<Pedido> findAll();
        
    public Optional<Pedido> findById(Long id);
    
    public Pedido save(Pedido entity);

    public void deleteById(Long id);
}
