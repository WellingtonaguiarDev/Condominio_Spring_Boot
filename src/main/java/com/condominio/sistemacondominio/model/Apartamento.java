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

    // Getters e Setters COMPLETOS e CORRETOS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public List<Morador> getMoradores() {
        return moradores;
    }

    public void setMoradores(List<Morador> moradores) {
        this.moradores = moradores;
    }

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

    // Métodos úteis
    @Override
    public String toString() {
        return "Apartamento " + numero + ", Bloco " + bloco + ", Andar " + andar;
    }

    // Método para adicionar morador mantendo a consistência bidirecional
    public void adicionarMorador(Morador morador) {
        moradores.add(morador);
        morador.setApartamento(this);
    }
}