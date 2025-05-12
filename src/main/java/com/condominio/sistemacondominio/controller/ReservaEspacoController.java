package com.condominio.sistemacondominio.controller;

import com.condominio.sistemacondominio.model.ReservaEspaco;
import com.condominio.sistemacondominio.service.ReservaEspacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas")
public class ReservaEspacoController {

    @Autowired
    private ReservaEspacoService service;

    @PostMapping
    public ReservaEspaco criarReserva(@RequestBody ReservaEspaco reserva) {
        return service.salvarReserva(reserva);
    }

    @GetMapping
    public List<ReservaEspaco> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<ReservaEspaco> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void cancelarReserva(@PathVariable Long id) {
        service.cancelarReserva(id);
    }
}