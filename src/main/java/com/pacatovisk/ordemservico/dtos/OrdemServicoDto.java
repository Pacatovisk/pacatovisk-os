package com.pacatovisk.ordemservico.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pacatovisk.ordemservico.domain.OrdemServico;
import com.pacatovisk.ordemservico.domain.enums.Prioridade;
import com.pacatovisk.ordemservico.domain.enums.Status;

import java.io.Serializable;
import java.time.LocalDateTime;

public class OrdemServicoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataAbertura;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataFechamento;
    private Prioridade prioridade;
    private String observacoes;
    private Status status;

    public OrdemServicoDto(OrdemServico obj) throws IllegalAccessException {
        this.id = obj.getId();
        this.dataAbertura = obj.getDataAbertura();
        this.dataFechamento = obj.getDataFechamento();
        this.prioridade = obj.getPrioridade();
        this.observacoes = obj.getObservacoes();
        this.status = obj.getStatus();
    }

    public OrdemServicoDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
