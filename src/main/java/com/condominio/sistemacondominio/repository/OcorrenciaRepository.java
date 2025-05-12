package com.condominio.sistemacondominio.repository;

import com.condominio.sistemacondominio.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
    List<Ocorrencia> findByStatus(String status);
    List<Ocorrencia> findByPrioridade(String prioridade);
    List<Ocorrencia> findByMoradorId(Long moradorId);
    List<Ocorrencia> findByDataRegistroBetween(LocalDateTime inicio, LocalDateTime fim);
}
