package com.condominio.sistemacondominio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.List;

@Entity
@Table(name = "apartamentos", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"numero", "bloco"})
})
public class Apartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Número do apartamento é obrigatório")
    @Column(nullable = false)
    private String numero;

    @NotBlank(message = "Bloco é obrigatório")
    @Column(nullable = false)
    private String bloco;

    @NotNull(message = "Andar é obrigatório")
    @PositiveOrZero(message = "Andar deve ser um número positivo ou zero")
    @Column(nullable = false)
    private Integer andar;

    @OneToMany(mappedBy = "apartamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Morador> moradores;

    @OneToMany(mappedBy = "apartamento", cascade = CascadeType.ALL)
    private List<Ocorrencia> ocorrencias;

    @OneToMany(mappedBy = "apartamento", cascade = CascadeType.ALL)
    private List<ReservaEspaco> reservas;

    // Construtores
    public Apartamento() {
    }

    public Apartamento(String numero, String bloco, int andar) {
        this.numero = numero;
        this.bloco = bloco;
        this.andar = andar;
    }

    // Getters e Setters (manter os que você já tinha e adicionar os novos)
    public List<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(List<Ocorrencia> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    public List<ReservaEspaco> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaEspaco> reservas) {
        this.reservas = reservas;
    }

    // Método toString para facilitar a visualização
    @Override
    public String toString() {
        return "Apartamento " + numero + ", Bloco " + bloco + ", Andar " + andar;
    }
}