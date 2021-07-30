package com.pacatovisk.ordemservico.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
}
