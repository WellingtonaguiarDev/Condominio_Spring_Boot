package com.condominio.sistemacondominio.service;

import com.condominio.sistemacondominio.model.Ocorrencia;
import com.condominio.sistemacondominio.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    public Ocorrencia registrarOcorrencia(Ocorrencia ocorrencia) {
        if (ocorrencia.getDataRegistro() == null) {
            ocorrencia.setDataRegistro(LocalDateTime.now());
        }
        return ocorrenciaRepository.save(ocorrencia);
    }

    public List<Ocorrencia> listarTodas() {
        return ocorrenciaRepository.findAll();
    }

    public Optional<Ocorrencia> buscarPorId(Long id) {
        return ocorrenciaRepository.findById(id);
    }

    public Ocorrencia atualizarOcorrencia(Long id, Ocorrencia ocorrencia) {
        Optional<Ocorrencia> ocorrenciaExistente = ocorrenciaRepository.findById(id);
        if (ocorrenciaExistente.isPresent()) {
            ocorrencia.setId(id);
            return ocorrenciaRepository.save(ocorrencia);
        }
        return null;
    }

    public void excluirOcorrencia(Long id) {
        ocorrenciaRepository.deleteById(id);
    }

    public List<Ocorrencia> buscarPorStatus(String status) {
        return ocorrenciaRepository.findByStatus(status);
    }

    public List<Ocorrencia> buscarPorPrioridade(String prioridade) {
        return ocorrenciaRepository.findByPrioridade(prioridade);
    }

    public List<Ocorrencia> buscarPorMorador(Long moradorId) {
        return ocorrenciaRepository.findByMoradorId(moradorId);
    }
}
