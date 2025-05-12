package com.condominio.sistemacondominio.controller;

import com.condominio.sistemacondominio.model.Visitante;
import com.condominio.sistemacondominio.service.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/visitantes")
public class VisitanteController {

    @Autowired
    private VisitanteService service;

    @PostMapping
    public Visitante criarVisitante(@RequestBody Visitante visitante) {
        return service.salvarVisitante(visitante);
    }

    @GetMapping
    public List<Visitante> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Visitante> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarVisitante(@PathVariable Long id) {
        service.deletarVisitante(id);
    }
}
