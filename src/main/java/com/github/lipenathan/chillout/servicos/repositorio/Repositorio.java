package com.github.lipenathan.chillout.servicos.repositorio;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.List;

public class Repositorio <T>{

    private final Class<T> entidade;

    private final EntityManager entityManager;
    private final EntityTransaction transaction;

    public Repositorio(Class<T> entidade) {
        this.entidade = entidade;
        this.entityManager = FabricaEntityManager.criarEntityManager();
        this.transaction = entityManager.getTransaction();
    }

    @Transactional
    public void inserir(T o) {
        transaction.begin();
        entityManager.persist(o);
        transaction.commit();
    }

    public void atualizar(T o) {
        transaction.begin();
        entityManager.merge(o);
        transaction.commit();
    }

    public List<T> buscarTodos() {
        return entityManager.createQuery("select t from " + entidade.getSimpleName() + " t").getResultList();
    }

    public T buscarPorId(Long id) {
        return (T) entityManager.createQuery("select t from " + entidade.getSimpleName() + " t where t.id = :id")
                .setParameter("id", id).getSingleResult();
    }

    public void deletar(T o) {
        transaction.begin();
        entityManager.remove(o);
        transaction.commit();
    }
}