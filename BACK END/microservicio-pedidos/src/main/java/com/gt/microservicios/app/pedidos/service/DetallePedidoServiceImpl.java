/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.microservicios.app.pedidos.service;

import com.gt.microservicios.app.pedidos.models.entity.DetallePedidos;
import com.gt.microservicios.app.pedidos.models.entity.DetallePedidosId;
import com.gt.microservicios.app.pedidos.models.repository.DetallePedidoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian
 */
@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

    @Autowired
    private DetallePedidoRepository repository;

    @Override
    public Iterable<DetallePedidos> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<DetallePedidos> findById(DetallePedidosId id) {
        return repository.findById(id);
    }

    @Override
    public DetallePedidos save(DetallePedidos entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(DetallePedidosId id) {
        repository.deleteById(id);
    }

    @Override
    public List<DetallePedidos> findDetalleByIdPedido(Long idPedido) {
        return repository.findDetalleByIdPedido(idPedido);
    }

}
