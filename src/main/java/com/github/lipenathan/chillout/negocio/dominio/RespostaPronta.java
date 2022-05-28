package com.github.lipenathan.chillout.negocio.dominio;

import javax.persistence.*;

@Entity
public class RespostaPronta {
    @Id
    @Column(name = "resposta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "texto_resposta")
    private String textoResposta;
    @Column(name = "numero_resposta")
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
