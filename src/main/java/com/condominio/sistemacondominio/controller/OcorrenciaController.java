package com.condominio.sistemacondominio.controller;


import com.condominio.sistemacondominio.model.Ocorrencia;
import com.condominio.sistemacondominio.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    @PostMapping
    public ResponseEntity<Ocorrencia> registrarOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        return new ResponseEntity<>(ocorrenciaService.registrarOcorrencia(ocorrencia), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Ocorrencia> listarTodas() {
        return ocorrenciaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia> buscarPorId(@PathVariable Long id) {
        Optional<Ocorrencia> ocorrencia = ocorrenciaService.buscarPorId(id);
        return ocorrencia.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ocorrencia> atualizarOcorrencia(@PathVariable Long id, @RequestBody Ocorrencia ocorrencia) {
        Ocorrencia ocorrenciaAtualizada = ocorrenciaService.atualizarOcorrencia(id, ocorrencia);
        if (ocorrenciaAtualizada != null) {
            return ResponseEntity.ok(ocorrenciaAtualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirOcorrencia(@PathVariable Long id) {
        ocorrenciaService.excluirOcorrencia(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{status}")
    public List<Ocorrencia> buscarPorStatus(@PathVariable String status) {
        return ocorrenciaService.buscarPorStatus(status);
    }

    @GetMapping("/prioridade/{prioridade}")
    public List<Ocorrencia> buscarPorPrioridade(@PathVariable String prioridade) {
        return ocorrenciaService.buscarPorPrioridade(prioridade);
    }

    @GetMapping("/morador/{moradorId}")
    public List<Ocorrencia> buscarPorMorador(@PathVariable Long moradorId) {
        return ocorrenciaService.buscarPorMorador(moradorId);
    }
}