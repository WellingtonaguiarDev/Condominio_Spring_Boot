package com.condominio.sistemacondominio.service;

import com.condominio.sistemacondominio.model.Apartamento;
import com.condominio.sistemacondominio.repository.ApartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApartamentoService {

    @Autowired
    private ApartamentoRepository apartamentoRepository;

    public Apartamento salvarApartamento(Apartamento apartamento) {
        return apartamentoRepository.save(apartamento);
    }

    public List<Apartamento> listarTodos() {
        return apartamentoRepository.findAll();
    }

    public Optional<Apartamento> buscarPorId(Long id) {
        return apartamentoRepository.findById(id);
    }

    public void deletarPorId(Long id) {
        apartamentoRepository.deleteById(id);
    }

    public List<Apartamento> buscarPorBloco(String bloco) {
        return apartamentoRepository.findByBloco(bloco);
    }

    public List<Apartamento> buscarPorAndar(int andar) {
        return apartamentoRepository.findByAndar(andar);
    }
}
