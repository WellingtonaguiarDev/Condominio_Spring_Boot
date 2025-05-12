package com.condominio.sistemacondominio.controller;

import com.condominio.sistemacondominio.model.Morador;
import com.condominio.sistemacondominio.service.MoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/moradores")
public class MoradorController {

    @Autowired
    private MoradorService moradorService;

    // Endpoint para salvar um morador
    @PostMapping
    public Morador salvarMorador(@RequestBody Morador morador) {
        return moradorService.salvarMorador(morador);
    }

    // Endpoint para buscar todos os moradores
    @GetMapping
    public List<Morador> buscarTodos() {
        return moradorService.buscarTodos();
    }

    // Endpoint para buscar morador por ID
    @GetMapping("/{id}")
    public Optional<Morador> buscarPorId(@PathVariable Long id) {
        return moradorService.buscarPorId(id);
    }

    // Endpoint para deletar um morador
    @DeleteMapping("/{id}")
    public void deletarMorador(@PathVariable Long id) {
        moradorService.deletarMorador(id);
    }
}