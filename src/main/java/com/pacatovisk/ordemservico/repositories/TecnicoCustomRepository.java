package com.pacatovisk.ordemservico.repositories;

import com.pacatovisk.ordemservico.domain.Tecnico;
import lombok.var;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class TecnicoCustomRepository {

    private final EntityManager em;

    public TecnicoCustomRepository(EntityManager em) {
        this.em = em;
    }

    public Optional<Tecnico> find(Integer id, String nome, String cpf) {

        String query = "select T from Tecnico as T ";
        String condicao = "where";

        if (id != null) {
            query += condicao + " T.id = :id";
            condicao = " and ";
        }

        if (nome != null) {
            query += condicao + " lower(T.nome) =:nome";
            condicao = " and ";
        }

        if (cpf != null) {
            query += condicao + " T.cpf = :cpf";
        }

        var q = em.createQuery(query, Tecnico.class);

        if (id != null) {
            q.setParameter("id", id);
        }

        if (nome != null) {
            q.setParameter("nome", nome);
        }

        if (cpf != null) {
            q.setParameter("cpf", cpf);
        }

        return Optional.ofNullable(q.getSingleResult());
    }
}