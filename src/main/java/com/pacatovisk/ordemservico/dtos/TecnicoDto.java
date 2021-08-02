package com.pacatovisk.ordemservico.dtos;

import com.pacatovisk.ordemservico.domain.Tecnico;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

public class TecnicoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;

    @CPF
    private String cpf;
    private String telefone;

    public TecnicoDto() {
    }

    public TecnicoDto(Tecnico obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.telefone = obj.getTelefone();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
