package com.condominio.sistemacondominio.repository;

import com.condominio.sistemacondominio.model.ReservaEspaco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaEspacoRepository extends JpaRepository<ReservaEspaco, Long> {
    List<ReservaEspaco> findByTipoEspacoAndDataHoraInicioBetween(String tipoEspaco, LocalDateTime inicio, LocalDateTime fim);
}