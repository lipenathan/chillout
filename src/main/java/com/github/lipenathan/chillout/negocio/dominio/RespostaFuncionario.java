package com.github.lipenathan.chillout.negocio.dominio;

import javax.persistence.*;

import java.io.Serializable;

@Entity(name = "RESPOSTA_FUNCIONARIO")
public class RespostaFuncionario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESPOSTA_FUNCIONARIO_ID")
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESPOSTA_ID")
    private Resposta resposta;
    @Column(name = "TEXTO_RESPOSTA_SUBJETIVA")
    private String textoResposta;
    @ManyToOne
    @JoinColumn(name = "FORMULARIO_RESPONDIDO_ID")
    private FormularioRespondido formularioRespondido;

    public RespostaFuncionario() {
    }

    public RespostaFuncionario(Resposta resposta, FormularioRespondido formularioRespondido) {
        this.resposta = resposta;
        this.formularioRespondido = formularioRespondido;
        this.textoResposta = resposta.getTextoResposta();
    }

    public long getId() {
        return id;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    public String getTextoResposta() {
        return textoResposta;
    }

    public void setTextoResposta(String textoResposta) {
        this.textoResposta = textoResposta;
    }

    public FormularioRespondido getFormularioRespondido() {
        return formularioRespondido;
    }

    public void setFormularioRespondido(FormularioRespondido formularioRespondido) {
        this.formularioRespondido = formularioRespondido;
    }
}
