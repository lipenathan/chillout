package com.github.lipenathan.chillout.servicos.repositorio;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class FabricaEntityManager {
    private static final String PERSISTENCE_UNIT_NAME = "chillout_producao";

    public static EntityManager criarEntityManager() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    }
}