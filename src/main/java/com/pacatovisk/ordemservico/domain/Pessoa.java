package com.pacatovisk.ordemservico.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Pessoa {
    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
}
