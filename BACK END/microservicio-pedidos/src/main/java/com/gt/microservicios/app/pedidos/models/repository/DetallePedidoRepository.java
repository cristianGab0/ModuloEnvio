/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.microservicios.app.pedidos.models.repository;

import com.gt.microservicios.app.pedidos.models.entity.DetallePedidos;
import com.gt.microservicios.app.pedidos.models.entity.DetallePedidosId;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Cristian
 */
public interface DetallePedidoRepository extends CrudRepository<DetallePedidos, DetallePedidosId>{
    
    @Query("SELECT d FROM DetallePedidos d where d.id.idPedido = ?1")
    public List<DetallePedidos> findDetalleByIdPedido(Long idPedido);
}
