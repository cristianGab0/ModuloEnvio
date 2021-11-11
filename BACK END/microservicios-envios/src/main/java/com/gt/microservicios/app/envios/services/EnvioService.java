package com.gt.microservicios.app.envios.services;

import com.gt.microservicios.app.envios.models.entity.Envio;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Cristian
 */
public interface EnvioService {
    public Iterable<Envio> findAll();
        
    public Optional<Envio> findById(Long id);
    
    public Envio save(Envio entity);

    public void deleteById(Long id);
        
    public List<Envio> findProductosByEstado(String estado);
}
