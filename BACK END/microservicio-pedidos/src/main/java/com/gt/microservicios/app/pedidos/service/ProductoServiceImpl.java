package com.gt.microservicios.app.pedidos.service;

import com.gt.microservicios.app.pedidos.models.entity.DetallePedidos;
import com.gt.microservicios.app.pedidos.models.entity.Producto;
import com.gt.microservicios.app.pedidos.models.repository.ProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian
 */
@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository repository; 
            
            
    @Override
    public Iterable<Producto> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Producto save(Producto entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Producto> findProductosByIdPedido(Long idPedido) {
        return repository.findProductosByIdPedido(idPedido);
    }

    
}
