package com.condominio.sistemacondominio.repository;

import com.condominio.sistemacondominio.model.Morador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradorRepository extends JpaRepository<Morador, Long> {

}