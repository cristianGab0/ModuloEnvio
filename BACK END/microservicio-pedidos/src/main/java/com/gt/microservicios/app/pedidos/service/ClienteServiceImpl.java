/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.microservicios.app.pedidos.service;

import com.gt.microservicios.app.pedidos.models.entity.Cliente;
import com.gt.microservicios.app.pedidos.models.repository.ClienteRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian
 */
@Service
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    private ClienteRepository repository;
    
    @Override
    public Iterable<Cliente> findAll() {
        return repository.findAll();
    }
    
    @Override
    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }
    
    @Override
    public Cliente save(Cliente entity) {
        return repository.save(entity);
    }
    
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
}
