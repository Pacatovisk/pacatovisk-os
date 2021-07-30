package com.pacatovisk.ordemservico.domain.enums;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum Prioridade {

    BAIXA(0, "BAIXA"),
    MEDIA(1, "MEDIA"),
    ALTA(2, "ALTA");

    private Integer cod;
    private String descricao;

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Prioridade toEnum(Integer cod) throws IllegalAccessException {
        if(cod == null) {
            return null;
        }

        for(Prioridade x : Prioridade.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw  new IllegalAccessException("Prioridade inválida!" + cod);
    }
}
