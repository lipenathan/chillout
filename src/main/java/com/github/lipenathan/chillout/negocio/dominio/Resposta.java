package com.github.lipenathan.chillout.negocio.dominio;

import javax.persistence.*;

@Entity
public class Resposta {
    @Id
    @Column(name = "RESPOSTA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "TEXTO_RESPOSTA")
    private String textoResposta;
    @Column(name = "NUMERO_RESPOSTA")
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
