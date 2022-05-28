package com.github.lipenathan.chillout.negocio.dominio;

import javax.persistence.*;

@Entity
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERGUNTA_ID")
    private long id;
    private String textoPergunta;
    private boolean subjetiva;
    @OneToOne
    private RespostaFuncionario respostaFuncionario;
    @ManyToOne
    @JoinColumn(name = "FORMULARIO_ID")
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