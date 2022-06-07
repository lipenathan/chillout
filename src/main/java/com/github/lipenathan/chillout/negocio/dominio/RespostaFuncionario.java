package com.github.lipenathan.chillout.negocio.dominio;

import javax.persistence.*;

import java.io.Serializable;

@Entity
public class RespostaFuncionario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESPOSTA_FUNCIONARIO_ID")
    private long id;
    @ManyToOne
    @JoinColumn(name = "RESPOSTA_ID")
    private Resposta resposta;
    @Column(name = "TEXTO_RESPOSTA_SUBJETIVA")
    private String respostaSubjetiva;

    public long getId() {
        return id;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    public String getRespostaSubjetiva() {
        return respostaSubjetiva;
    }

    public void setRespostaSubjetiva(String respostaSubjetiva) {
        this.respostaSubjetiva = respostaSubjetiva;
    }
}
