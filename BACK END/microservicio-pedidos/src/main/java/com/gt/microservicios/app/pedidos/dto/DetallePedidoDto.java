/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.microservicios.app.pedidos.dto;

import com.gt.microservicios.app.pedidos.models.entity.DetallePedidosId;
import com.gt.microservicios.app.pedidos.models.entity.Producto;

/**
 *
 * @author Cristian
 */
public class DetallePedidoDto {

    private DetallePedidosId id;
    private Producto producto;
    private Long cantidadEnviada;
    private Long cantidadPedida;

    public DetallePedidoDto() {
    }

    public DetallePedidoDto(DetallePedidosId id, Producto producto, Long cantidadEnviada, Long cantidadPedida) {
        this.id = id;
        this.producto = producto;
        this.cantidadEnviada = cantidadEnviada;
        this.cantidadPedida = cantidadPedida;
    }

    public DetallePedidoDto(DetallePedidoDto convertDetallePedidoDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DetallePedidosId getId() {
        return id;
    }

    public void setId(DetallePedidosId id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Long getCantidadEnviada() {
        return cantidadEnviada;
    }

    public void setCantidadEnviada(Long cantidadEnviada) {
        this.cantidadEnviada = cantidadEnviada;
    }

    public Long getCantidadPedida() {
        return cantidadPedida;
    }

    public void setCantidadPedida(Long cantidadPedida) {
        this.cantidadPedida = cantidadPedida;
    }
    
    
}
