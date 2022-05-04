package com.github.lipenathan.chillout.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RespostaFuncionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
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
