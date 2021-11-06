/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.microservicios.app.pedidos.service;

import com.gt.microservicios.app.pedidos.models.entity.Cliente;
import java.util.Optional;

/**
 *
 * @author Cristian
 */
public interface ClienteService {
    public Iterable<Cliente> findAll();
        
    public Optional<Cliente> findById(Long id);
    
    public Cliente save(Cliente entity);

    public void deleteById(Long id);
    
}
