/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.microservicios.app.pedidos.service;

import com.gt.microservicios.app.pedidos.models.entity.BitacoraDetPedEnvio;
import com.gt.microservicios.app.pedidos.models.repository.BitacoraRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian
 */
@Service
public class BitacoraServiceImpl implements BitacoraService{

    @Autowired
    private BitacoraRepository repository;
    @Override
    public Iterable<BitacoraDetPedEnvio> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<BitacoraDetPedEnvio> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public BitacoraDetPedEnvio save(BitacoraDetPedEnvio entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<BitacoraDetPedEnvio> findBitacoraByIdEnvio(Long idEnvio) {
        return repository.findBitacoraByIdEnvio(idEnvio);
    }
    
}
