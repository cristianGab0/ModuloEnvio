package com.gt.microservicios.app.pedidos.models.repository;

import com.gt.microservicios.app.pedidos.models.entity.Cliente;
import com.gt.microservicios.app.pedidos.models.entity.Pedido;
import com.gt.microservicios.app.pedidos.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Cristian
 */
public interface PedidoRepository extends CrudRepository<Pedido, Long>{
    
}
