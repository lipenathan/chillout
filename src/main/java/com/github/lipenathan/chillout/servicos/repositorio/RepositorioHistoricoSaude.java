package com.github.lipenathan.chillout.servicos.repositorio;

import com.github.lipenathan.chillout.dominio.HistoricoSaude;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RepositorioHistoricoSaude {

    private final EntityManager entityManager;
    private final EntityTransaction transaction;

    public RepositorioHistoricoSaude() {
        this.entityManager = FabricaEntityManager.criarEntityManager();
        this.transaction = entityManager.getTransaction();
    }

    public void inserir(HistoricoSaude historicoSaude) {
        transaction.begin();
        entityManager.persist(historicoSaude);
        transaction.commit();
        entityManager.close();
    }
}
