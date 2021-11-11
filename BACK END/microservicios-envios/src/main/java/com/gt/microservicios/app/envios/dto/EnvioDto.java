package com.gt.microservicios.app.envios.dto;

import java.util.Date;

/**
 *
 * @author Cristian
 */
public class EnvioDto {
    private Long idEnvio;
    private String nombreCliente;
    private Date fechaEnvio;
    private String statusEnvio;

    public EnvioDto() {
    }

    public EnvioDto(Long idEnvio, String nombreCliente, Date fechaEnvio, String statusEnvio) {
        this.idEnvio = idEnvio;
        this.nombreCliente = nombreCliente;
        this.fechaEnvio = fechaEnvio;
        this.statusEnvio = statusEnvio;
    }

    public Long getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Long idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getStatusEnvio() {
        return statusEnvio;
    }

    public void setStatusEnvio(String statusEnvio) {
        this.statusEnvio = statusEnvio;
    }
    
    
}
