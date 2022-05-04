package com.github.lipenathan.chillout.servicos.repositorio;

import com.github.lipenathan.chillout.dominio.Psicologo;
import com.github.lipenathan.chillout.dominio.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RepositorioUsuario {

    private final EntityManager entityManager;
    private final EntityTransaction transaction;

    public RepositorioUsuario() {
        this.entityManager = FabricaEntityManager.criarEntityManager();
        this.transaction = entityManager.getTransaction();
    }

    public void inserir(Usuario usuario) {
        transaction.begin();
        entityManager.persist(usuario);
        transaction.commit();
        entityManager.close();
    }
}
