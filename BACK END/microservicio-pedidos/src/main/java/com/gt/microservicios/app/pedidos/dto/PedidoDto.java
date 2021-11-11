package com.gt.microservicios.app.pedidos.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Cristian
 */
public class PedidoDto {

    private Long idpedido;
    private String nombreCliente;
    private Date fechaPedido;
    private String statusPedido;
    private List<DetallePedidoDto> detallePedidos;
    private Double montoTotal;

    public PedidoDto(Long idpedido, String nombreCliente, Date fechaPedido, String statusPedido, List<DetallePedidoDto> detallePedidos, Double montoTotal) {
        this.idpedido = idpedido;
        this.nombreCliente = nombreCliente;
        this.fechaPedido = fechaPedido;
        this.statusPedido = statusPedido;
        this.detallePedidos = detallePedidos;
        this.montoTotal = montoTotal;
    }

    public PedidoDto() {
    }

    public Long getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Long idpedido) {
        this.idpedido = idpedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public List<DetallePedidoDto> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedidoDto> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

}
