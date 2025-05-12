package com.condominio.sistemacondominio.service;

import com.condominio.sistemacondominio.model.Visitante;
import com.condominio.sistemacondominio.repository.VisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitanteService {

    @Autowired
    private VisitanteRepository repository;

    public Visitante salvarVisitante(Visitante visitante) {
        return repository.save(visitante);
    }

    public List<Visitante> listarTodos() {
        return repository.findAll();
    }

    public Optional<Visitante> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletarVisitante(Long id) {
        repository.deleteById(id);
    }
}
