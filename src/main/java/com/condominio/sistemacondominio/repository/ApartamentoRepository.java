package com.condominio.sistemacondominio.repository;

import com.condominio.sistemacondominio.model.Apartamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {

    List<Apartamento> findByBloco(String bloco);

    List<Apartamento> findByAndar(int andar);

    Optional<Apartamento> findByNumeroAndBloco(String numero, String bloco);

    @Query("SELECT a FROM Apartamento a WHERE SIZE(a.moradores) > 0")
    List<Apartamento> findOcupados();

    @Query("SELECT a FROM Apartamento a WHERE SIZE(a.moradores) = 0")
    List<Apartamento> findVagos();

    @Query("SELECT DISTINCT a.bloco FROM Apartamento a ORDER BY a.bloco")
    List<String> findDistinctBlocos();
}