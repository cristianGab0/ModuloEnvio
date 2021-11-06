/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.microservicios.app.pedidos.models.repository;

import com.gt.microservicios.app.pedidos.models.entity.BitacoraDetPedEnvio;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Cristian
 */
public interface BitacoraRepository extends CrudRepository<BitacoraDetPedEnvio, Long>{
    
    @Query("SELECT b FROM BitacoraDetPedEnvio b where b.id_envio = ?1")
    public List<BitacoraDetPedEnvio> findBitacoraByIdEnvio(Long idEnvio);
}
