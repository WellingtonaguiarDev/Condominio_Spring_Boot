package com.condominio.sistemacondominio.repository;

import com.condominio.sistemacondominio.model.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MoradorRepository extends JpaRepository<Morador, Long> {

    List<Morador> findByNome(String nome);

    Morador findByEmail(String email);

    List<Morador> findByApartamentoId(Long apartamentoId);
}
