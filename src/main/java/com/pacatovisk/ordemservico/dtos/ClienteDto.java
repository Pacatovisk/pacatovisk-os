package com.pacatovisk.ordemservico.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pacatovisk.ordemservico.domain.OrdemServico;
import com.pacatovisk.ordemservico.domain.Pessoa;

import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClienteDto extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<OrdemServico> list = new ArrayList<>();

    public List<OrdemServico> getList() {
        return list;
    }

    public void setList(List<OrdemServico> list) {
        this.list = list;
    }
}
