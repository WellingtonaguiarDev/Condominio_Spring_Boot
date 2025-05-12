package com.condominio.sistemacondominio.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ReservaEspaco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoEspaco;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String status;
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "morador_id")
    private Morador morador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoEspaco() {
        return tipoEspaco;
    }

    public void setTipoEspaco(String tipoEspaco) {
        this.tipoEspaco = tipoEspaco;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }
}