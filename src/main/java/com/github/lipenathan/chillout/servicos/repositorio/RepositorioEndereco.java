package com.github.lipenathan.chillout.servicos.repositorio;

import com.github.lipenathan.chillout.dominio.Endereco;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class RepositorioEndereco {
    private final EntityManager entityManager;
    private final EntityTransaction transaction;

    public RepositorioEndereco() {
        entityManager = FabricaEntityManager.criarEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void inserir(Endereco...endereco) {
        transaction.begin();
        entityManager.persist(endereco);
        transaction.commit();
        entityManager.close();
    }

    public List<Endereco> buscarTodos() {
        Query query = entityManager.createQuery("select e from Endereco e");
        return query.getResultList();
    }
}
