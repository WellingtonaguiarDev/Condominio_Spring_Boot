package com.condominio.sistemacondominio.service;

import com.condominio.sistemacondominio.model.Morador;
import com.condominio.sistemacondominio.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoradorService {

    @Autowired
    private MoradorRepository moradorRepository;

    // Método para salvar um morador
    public Morador salvarMorador(Morador morador) {
        return moradorRepository.save(morador);
    }

    // Método para buscar todos os moradores
    public List<Morador> buscarTodos() {
        return moradorRepository.findAll();
    }

    // Método para buscar morador por ID
    public Optional<Morador> buscarPorId(Long id) {
        return moradorRepository.findById(id);
    }

    // Método para deletar morador
    public void deletarMorador(Long id) {
        moradorRepository.deleteById(id);
    }
}
