/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.microservicios.app.pedidos.service;

import com.gt.microservicios.app.pedidos.models.entity.DetallePedidos;
import com.gt.microservicios.app.pedidos.models.entity.Producto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Cristian
 */
public interface ProductoService {
    public Iterable<Producto> findAll();
        
    public Optional<Producto> findById(Long id);
    
    public Producto save(Producto entity);

    public void deleteById(Long id);
    
    public List<Producto> findProductosByIdPedido(Long idPedido);
    
}
