package com.gt.microservicios.app.envios.services;

import com.gt.microservicios.app.envios.models.entity.Envio;
import com.gt.microservicios.app.envios.models.repository.EnvioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian
 */
@Service
public class EnvioServiceImp implements EnvioService{

    @Autowired
    private EnvioRepository repository;
    
    @Override
    public Iterable<Envio> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Envio> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Envio save(Envio entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Envio> findProductosByEstado(String estado) {
        return repository.findProductosByEstado(estado);
    }
    
}
