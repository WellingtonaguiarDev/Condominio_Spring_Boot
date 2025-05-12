package com.condominio.sistemacondominio.service;

import com.condominio.sistemacondominio.model.Apartamento;
import com.condominio.sistemacondominio.repository.ApartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ApartamentoService {

    @Autowired
    private ApartamentoRepository apartamentoRepository;

    @Transactional
    public Apartamento salvarApartamento(Apartamento apartamento) throws DataIntegrityViolationException {
        // Verifica se já existe um apartamento com o mesmo número e bloco
        if (apartamentoRepository.findByNumeroAndBloco(apartamento.getNumero(), apartamento.getBloco()).isPresent()) {
            throw new DataIntegrityViolationException("Já existe um apartamento com este número no bloco informado");
        }
        return apartamentoRepository.save(apartamento);
    }

    public List<Apartamento> listarTodos() {
        return apartamentoRepository.findAll();
    }

    public Optional<Apartamento> buscarPorId(Long id) {
        return apartamentoRepository.findById(id);
    }

    @Transactional
    public void deletarPorId(Long id) {
        apartamentoRepository.deleteById(id);
    }

    public List<Apartamento> buscarPorBloco(String bloco) {
        return apartamentoRepository.findByBloco(bloco);
    }

    public List<Apartamento> buscarPorAndar(int andar) {
        return apartamentoRepository.findByAndar(andar);
    }

    public List<Apartamento> buscarApartamentosOcupados() {
        return apartamentoRepository.findOcupados();
    }

    public List<Apartamento> buscarApartamentosVagos() {
        return apartamentoRepository.findVagos();
    }

    public List<String> listarBlocos() {
        return apartamentoRepository.findDistinctBlocos();
    }

    public Optional<Apartamento> buscarPorNumeroBloco(String numero, String bloco) {
        return apartamentoRepository.findByNumeroAndBloco(numero, bloco);
    }

    @Transactional
    public Apartamento atualizarApartamento(Long id, Apartamento apartamentoAtualizado) {
        return apartamentoRepository.findById(id)
                .map(apartamento -> {
                    apartamento.setNumero(apartamentoAtualizado.getNumero());
                    apartamento.setBloco(apartamentoAtualizado.getBloco());
                    apartamento.setAndar(apartamentoAtualizado.getAndar());
                    return apartamentoRepository.save(apartamento);
                })
                .orElseGet(() -> {
                    apartamentoAtualizado.setId(id);
                    return apartamentoRepository.save(apartamentoAtualizado);
                });
    }
}