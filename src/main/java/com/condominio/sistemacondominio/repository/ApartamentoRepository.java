package com.condominio.sistemacondominio.repository;

import com.condominio.sistemacondominio.model.Apartamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {

    List<Apartamento> findByBloco(String bloco);

    List<Apartamento> findByAndar(int andar);
}
