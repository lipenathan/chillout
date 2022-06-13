package com.github.lipenathan.chillout.negocio.dominio;

public enum Papel {
    FUNCIONARIO, PSICOLOGO, GESTOR;

    @Override
    public String toString() {
        switch (this) {
            case FUNCIONARIO:
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