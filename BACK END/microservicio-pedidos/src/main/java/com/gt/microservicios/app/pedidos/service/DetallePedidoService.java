/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.microservicios.app.pedidos.service;

import com.gt.microservicios.app.pedidos.models.entity.DetallePedidos;
import com.gt.microservicios.app.pedidos.models.entity.DetallePedidosId;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Cristian
 */
public interface DetallePedidoService {
    public Iterable<DetallePedidos> findAll();
        
    public Optional<DetallePedidos> findById(DetallePedidosId id);
    
    public DetallePedidos save(DetallePedidos entity);

    public void deleteById(DetallePedidosId id);
    
    public List<DetallePedidos> findDetalleByIdPedido(Long idPedido);
    
}
