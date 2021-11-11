/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.microservicios.app.pedidos.models.repository;

import com.gt.microservicios.app.pedidos.models.entity.DetallePedidos;
import com.gt.microservicios.app.pedidos.models.entity.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Cristian
 */
public interface ProductoRepository extends CrudRepository<Producto, Long>{
    
    @Query("SELECT p FROM Producto p, DetallePedidos d where p.idProducto=d.id.idProducto and d.id.idPedido = ?1")
    public List<Producto> findProductosByIdPedido(Long idPedido);
}
