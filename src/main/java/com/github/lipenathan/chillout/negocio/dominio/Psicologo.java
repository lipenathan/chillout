package com.github.lipenathan.chillout.negocio.dominio;

import com.github.lipenathan.chillout.negocio.exception.NegocioException;
import jakarta.persistence.Entity;

import static com.github.lipenathan.flynn.validador.Validador.validarCrm;

@Entity
public class Psicologo extends Usuario {
    private String crm;

    public Psicologo() {
        this.papel = Papel.PSICOLOGO;
    }

    @Override
    public void validar() throws NegocioException {
        validarUsuario();
        if (!validarCrm(crm)) throw NegocioException.DOCUMENTO_INVALIDO;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}