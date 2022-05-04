package com.github.lipenathan.chillout.servicos.repositorio;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class FabricaEntityManager {
    private static final String PERSISTENCE_UNIT_NAME = "chillout_teste";

    public static EntityManager criarEntityManager() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    }
}