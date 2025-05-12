package com.condominio.sistemacondominio.service;

import com.condominio.sistemacondominio.model.ReservaEspaco;
import com.condominio.sistemacondominio.repository.ReservaEspacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaEspacoService {

    @Autowired
    private ReservaEspacoRepository repository;

    public ReservaEspaco salvarReserva(ReservaEspaco reserva) {
        return repository.save(reserva);
    }

    public List<ReservaEspaco> listarTodas() {
        return repository.findAll();
    }

    public Optional<ReservaEspaco> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void cancelarReserva(Long id) {
        repository.deleteById(id);
    }
}