package com.gt.microservicios.app.pedidos.service;

import com.gt.microservicios.app.pedidos.models.entity.Pedido;
import com.gt.microservicios.app.pedidos.models.repository.PedidoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cristian
 */
@Service
public class PedidoSeviceImpl implements PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Pedido> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Pedido save(Pedido entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
