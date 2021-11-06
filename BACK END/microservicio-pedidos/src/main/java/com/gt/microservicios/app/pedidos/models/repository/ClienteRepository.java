/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.microservicios.app.pedidos.models.repository;

import com.gt.microservicios.app.pedidos.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Cristian
 */
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
    
}
