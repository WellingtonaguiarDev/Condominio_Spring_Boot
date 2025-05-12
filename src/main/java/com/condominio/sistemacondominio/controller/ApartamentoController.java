package com.condominio.sistemacondominio.controller;

import com.condominio.sistemacondominio.model.Apartamento;
import com.condominio.sistemacondominio.service.ApartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/apartamentos")
public class ApartamentoController {

    @Autowired
    private ApartamentoService apartamentoService;

    // Endpoint para salvar um apartamento
    @PostMapping
    public Apartamento salvarApartamento(@RequestBody Apartamento apartamento) {
        return apartamentoService.salvarApartamento(apartamento);
    }

    // Endpoint para listar todos os apartamentos
    @GetMapping
    public List<Apartamento> listarTodos() {
        return apartamentoService.listarTodos();
    }

    // Endpoint para buscar apartamento por ID
    @GetMapping("/{id}")
    public Optional<Apartamento> buscarPorId(@PathVariable Long id) {
        return apartamentoService.buscarPorId(id);
    }

    // Endpoint para buscar apartamentos por bloco
    @GetMapping("/bloco/{bloco}")
    public List<Apartamento> buscarPorBloco(@PathVariable String bloco) {
        return apartamentoService.buscarPorBloco(bloco);
    }

    // Endpoint para buscar apartamentos por andar
    @GetMapping("/andar/{andar}")
    public List<Apartamento> buscarPorAndar(@PathVariable int andar) {
        return apartamentoService.buscarPorAndar(andar);
    }

    // Endpoint para deletar apartamento por ID
    @DeleteMapping("/{id}")
    public void deletarApartamento(@PathVariable Long id) {
        apartamentoService.deletarPorId(id);
    }
}
