package com.github.lipenathan.chillout.negocio.dominio;

import javax.persistence.*;

import java.io.Serializable;

@Entity
public class RespostaFuncionario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_resposta_pronta")
    private RespostaPronta resposta;
    private String respostaSubjetiva;

    public long getId() {
        return id;
    }

    public RespostaPronta getResposta() {
        return resposta;
    }

    public void setResposta(RespostaPronta resposta) {
        this.resposta = resposta;
    }

    public String getRespostaSubjetiva() {
        return respostaSubjetiva;
    }

    public void setRespostaSubjetiva(String respostaSubjetiva) {
        this.respostaSubjetiva = respostaSubjetiva;
    }
}
