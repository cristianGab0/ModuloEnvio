/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.microservicios.app.pedidos.service;

import com.gt.microservicios.app.pedidos.models.entity.BitacoraDetPedEnvio;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Cristian
 */
public interface BitacoraService {
    public Iterable<BitacoraDetPedEnvio> findAll();
        
    public Optional<BitacoraDetPedEnvio> findById(Long id);
    
    public BitacoraDetPedEnvio save(BitacoraDetPedEnvio entity);

    public void deleteById(Long id);
    
    public List<BitacoraDetPedEnvio> findBitacoraByIdEnvio(Long idEnvio);
    
}
