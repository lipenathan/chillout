package com.github.lipenathan.chillout.negocio.dominio;

public enum Papel {
    FUNCONARIO, PSICOLOGO, GESTOR;

    @Override
    public String toString() {
        switch (this) {
            case FUNCONARIO:
                return "Funcionário";
            case PSICOLOGO:
                return "Psicólogo";
            case GESTOR:
                return "Gestor";
            default:
                return null;
        }
    }
}