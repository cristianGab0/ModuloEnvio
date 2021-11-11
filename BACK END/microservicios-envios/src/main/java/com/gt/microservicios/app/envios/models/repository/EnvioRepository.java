package com.gt.microservicios.app.envios.models.repository;

import com.gt.microservicios.app.envios.models.entity.Envio;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Cristian
 */
public interface EnvioRepository extends CrudRepository<Envio, Long>{
    
    @Query("SELECT e FROM Envio e where e.estado = ?1")
    public List<Envio> findProductosByEstado(String estado);
}
