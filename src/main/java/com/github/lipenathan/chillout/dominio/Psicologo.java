package com.github.lipenathan.chillout.dominio;

import jakarta.persistence.Entity;

import static com.github.lipenathan.chillout.dominio.Papel.PSICOLOGO;

@Entity
public class Psicologo extends Usuario {
    private String crm;

    public Psicologo() {
        this.papel = PSICOLOGO;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}