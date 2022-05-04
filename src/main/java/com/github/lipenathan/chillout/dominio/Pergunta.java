package com.github.lipenathan.chillout.dominio;

import jakarta.persistence.*;

@Entity
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String textoPergunta;
    private boolean subjetiva;
    private RespostaFuncionario respostaFuncionario;
    @ManyToOne
    private Formulario formulario;

    public long getId() {
        return id;
    }

    public String getTextoPergunta() {
        return textoPergunta;
    }

    public void setTextoPergunta(String textoPergunta) {
        this.textoPergunta = textoPergunta;
    }

    public boolean isSubjetiva() {
        return subjetiva;
    }

    public void setSubjetiva(boolean subjetiva) {
        this.subjetiva = subjetiva;
    }

    public RespostaFuncionario getRespostaFuncionario() {
        return respostaFuncionario;
    }

    public void setRespostaFuncionario(RespostaFuncionario respostaFuncionario) {
        this.respostaFuncionario = respostaFuncionario;
    }
}