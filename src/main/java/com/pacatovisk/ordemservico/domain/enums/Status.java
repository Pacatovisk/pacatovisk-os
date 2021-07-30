package com.pacatovisk.ordemservico.domain.enums;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {

    ABERTO(0, "ABERTO"),
    ANDAMENTO(1, "ANDAMENTO"),
    ENCERRADO(2, "ENCERRADO");

    private Integer cod;
    private String descricao;

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Status toEnum(Integer cod) throws IllegalAccessException {
        if(cod == null) {
            return null;
        }

        for(Status x : Status.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw  new IllegalAccessException("Status inválido!" + cod);
    }
}
