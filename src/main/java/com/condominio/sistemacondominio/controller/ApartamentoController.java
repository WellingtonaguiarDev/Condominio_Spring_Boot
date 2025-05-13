package com.condominio.sistemacondominio.controller;

import com.condominio.sistemacondominio.model.Apartamento;
import com.condominio.sistemacondominio.service.ApartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/apartamentos")
public class ApartamentoController {

    @Autowired
    private ApartamentoService apartamentoService;

    // Cadastra novo apartamento
    @PostMapping
    public ResponseEntity<?> salvarApartamento(@RequestBody Apartamento apartamento) {
        try {
            Apartamento novoApartamento = apartamentoService.salvarApartamento(apartamento);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoApartamento);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("Erro: Já existe um apartamento com este número/bloco");
        }
    }

    // Lista todos os apartamentos
    @GetMapping
    public ResponseEntity<List<Apartamento>> listarTodos() {
        List<Apartamento> apartamentos = apartamentoService.listarTodos();
        return apartamentos.isEmpty() ? 
               ResponseEntity.noContent().build() : 
               ResponseEntity.ok(apartamentos);
    }

    // Busca por ID
    @GetMapping("/{id}")
    public ResponseEntity<Apartamento> buscarPorId(@PathVariable Long id) {
        Optional<Apartamento> apartamento = apartamentoService.buscarPorId(id);
        return apartamento.map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
    }

    // Busca por bloco
    @GetMapping("/bloco/{bloco}")
    public ResponseEntity<List<Apartamento>> buscarPorBloco(@PathVariable String bloco) {
        List<Apartamento> apartamentos = apartamentoService.buscarPorBloco(bloco);
        return apartamentos.isEmpty() ? 
               ResponseEntity.noContent().build() : 
               ResponseEntity.ok(apartamentos);
    }

    // Busca por andar
    @GetMapping("/andar/{andar}")
    public ResponseEntity<List<Apartamento>> buscarPorAndar(@PathVariable Integer andar) {
        List<Apartamento> apartamentos = apartamentoService.buscarPorAndar(andar);
        return apartamentos.isEmpty() ? 
               ResponseEntity.noContent().build() : 
               ResponseEntity.ok(apartamentos);
    }

    // Atualiza apartamento
    @PutMapping("/{id}")
    public ResponseEntity<Apartamento> atualizarApartamento(
            @PathVariable Long id,
            @RequestBody Apartamento apartamento) {
        Apartamento atualizado = apartamentoService.atualizarApartamento(id, apartamento);
        return ResponseEntity.ok(atualizado);
    }

    // Deleta apartamento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarApartamento(@PathVariable Long id) {
        apartamentoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints adicionais (opcionais)
    @GetMapping("/vagos")
    public ResponseEntity<List<Apartamento>> buscarVagos() {
        List<Apartamento> apartamentos = apartamentoService.buscarApartamentosVagos();
        return ResponseEntity.ok(apartamentos);
    }

    @GetMapping("/blocos")
    public ResponseEntity<List<String>> listarBlocos() {
        List<String> blocos = apartamentoService.listarBlocos();
        return ResponseEntity.ok(blocos);
    }
}