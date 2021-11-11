package com.gt.microservicios.app.envios.controllers;

import com.gt.microservicios.app.envios.models.entity.Envio;
import com.gt.microservicios.app.envios.dto.EnvioDto;
import com.gt.microservicios.app.envios.services.EnvioService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Cristian
 */
@Controller
public class EnviosController {

    @Autowired
    private EnvioService service;

    @GetMapping
    public ResponseEntity<?> obtenerEnvios() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<?> obtenerEnvioByEstado(@PathVariable String estado) {
        return ResponseEntity.ok(service.findProductosByEstado(estado));
    }

    @GetMapping("/envios/estado/{estado}")
    public ResponseEntity<?> obtenerEnviosByEstado(@PathVariable String estado) {
        List<Envio> e = service.findProductosByEstado(estado);
        List<EnvioDto> enviosDto = new ArrayList<>();
        for (Envio envio : e) {

            EnvioDto envioDto = new EnvioDto(envio.getIdenvio(), estado, envio.getFechaEntrega(), envio.getEstado());
            
            enviosDto.add(envioDto);
        }
        return ResponseEntity.ok(enviosDto);
    }

    @GetMapping("/{idEnvio}")
    public ResponseEntity<?> obtenerEnvioById(@PathVariable Long idEnvio) {
        return ResponseEntity.ok(service.findById(idEnvio));
    }

    @PostMapping
    public ResponseEntity<?> crearEnvio(@RequestBody Envio envio) {
        Envio envioDb = service.save(envio);

        return ResponseEntity.status(HttpStatus.CREATED).body(envioDb);
    }

    @PutMapping("/{idEnvio}")
    public ResponseEntity<?> modificarEnvio(@RequestBody Envio envio, @PathVariable Long idEnvio) {
        Optional<Envio> e = service.findById(idEnvio);

        if (e.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Envio envioDb = e.get();

            envioDb.setEstado(envio.getEstado());
            envioDb.setFechaEntrega(envio.getFechaEntrega());
            envioDb.setMetodoEnvio(envio.getMetodoEnvio());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(envioDb));
        }
    }

    @PutMapping("/cancelar/{idEnvio}")
    public ResponseEntity<?> cancelarEnvio(@PathVariable Long idEnvio) {
        Optional<Envio> e = service.findById(idEnvio);
        if (e.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Envio envio = e.get();
            envio.setEstado("Cancelado");
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(envio));
        }
    }
}
