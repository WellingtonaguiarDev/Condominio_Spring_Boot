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

    @PostMapping
    public ResponseEntity<?> salvarApartamento(@RequestBody Apartamento apartamento) {
        try {
            Apartamento novoApartamento = apartamentoService.salvarApartamento(apartamento);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoApartamento);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erro ao salvar apartamento");
        }
    }

    @GetMapping
    public ResponseEntity<List<Apartamento>> listarTodos() {
        List<Apartamento> apartamentos = apartamentoService.listarTodos();
        return ResponseEntity.ok(apartamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apartamento> buscarPorId(@PathVariable Long id) {
        return apartamentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/bloco/{bloco}")
    public ResponseEntity<List<Apartamento>> buscarPorBloco(@PathVariable String bloco) {
        List<Apartamento> apartamentos = apartamentoService.buscarPorBloco(bloco);
        return apartamentos.isEmpty() ? 
               ResponseEntity.noContent().build() : 
               ResponseEntity.ok(apartamentos);
    }

    @GetMapping("/andar/{andar}")
    public ResponseEntity<List<Apartamento>> buscarPorAndar(@PathVariable int andar) {
        List<Apartamento> apartamentos = apartamentoService.buscarPorAndar(andar);
        return apartamentos.isEmpty() ? 
               ResponseEntity.noContent().build() : 
               ResponseEntity.ok(apartamentos);
    }

    @GetMapping("/ocupados")
    public ResponseEntity<List<Apartamento>> buscarApartamentosOcupados() {
        List<Apartamento> apartamentos = apartamentoService.buscarApartamentosOcupados();
        return apartamentos.isEmpty() ? 
               ResponseEntity.noContent().build() : 
               ResponseEntity.ok(apartamentos);
    }

    @GetMapping("/vagos")
    public ResponseEntity<List<Apartamento>> buscarApartamentosVagos() {
        List<Apartamento> apartamentos = apartamentoService.buscarApartamentosVagos();
        return apartamentos.isEmpty() ? 
               ResponseEntity.noContent().build() : 
               ResponseEntity.ok(apartamentos);
    }

    @GetMapping("/blocos")
    public ResponseEntity<List<String>> listarBlocos() {
        List<String> blocos = apartamentoService.listarBlocos();
        return blocos.isEmpty() ? 
               ResponseEntity.noContent().build() : 
               ResponseEntity.ok(blocos);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Apartamento> buscarPorNumeroBloco(
            @RequestParam String numero, 
            @RequestParam String bloco) {
        return apartamentoService.buscarPorNumeroBloco(numero, bloco)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Apartamento> atualizarApartamento(
            @PathVariable Long id, 
            @RequestBody Apartamento apartamento) {
        Apartamento atualizado = apartamentoService.atualizarApartamento(id, apartamento);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarApartamento(@PathVariable Long id) {
        apartamentoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}