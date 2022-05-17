package com.github.lipenathan.chillout.negocio.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RespostaPronta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String textoResposta;
    private int notaResposta;

    public long getId() {
        return id;
    }

    public String getTextoResposta() {
        return textoResposta;
    }

    public void setTextoResposta(String textoResposta) {
        this.textoResposta = textoResposta;
    }

    public int getNotaResposta() {
        return notaResposta;
    }

    public void setNotaResposta(int notaResposta) {
        this.notaResposta = notaResposta;
    }
}
