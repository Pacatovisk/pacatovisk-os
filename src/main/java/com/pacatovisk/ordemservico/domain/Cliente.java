package com.pacatovisk.ordemservico.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;

@Entity
public class Cliente extends Pessoa implements Serializable {

    @OneToMany(mappedBy = "cliente")
    private static final long serialVersionUID = 1L;

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String cpf, String telefone) {
        super(id, nome, cpf, telefone);
    }

}
