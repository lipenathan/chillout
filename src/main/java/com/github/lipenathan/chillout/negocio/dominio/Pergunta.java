package com.github.lipenathan.chillout.negocio.dominio;

import com.github.lipenathan.chillout.negocio.exception.NegocioException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.github.lipenathan.chillout.utils.Validacao.validarCampoObrigatorio;

@Entity
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERGUNTA_ID")
    private long id;
    @Column(name = "TEXTO_PERGUNTA")
    private String textoPergunta;
    @Column(name = "PERGUNTA_SUBJETIVA")
    private boolean subjetiva;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "pergunta", fetch = FetchType.EAGER)
    private List<Resposta> respostas = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "FORMULARIO_ID")
    private Formulario formulario;
    @Transient
    private long idRespostaSelecionada;

    public Pergunta(boolean subjetiva) {
        this.subjetiva = subjetiva;
        this.respostas.add(new Resposta(0, this, "SUBJETIVA"));
    }

    public Pergunta() {
        this.respostas = Arrays.asList(new Resposta(1, this), new Resposta(2, this),
                new Resposta(3, this), new Resposta(4, this), new Resposta(5, this));
    }

    public void validar() throws NegocioException {
        try {
            validarCampoObrigatorio("texto pergunta", textoPergunta);
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Pergunta{" +
                "id=" + id +
                ", textoPergunta='" + textoPergunta + '\'' +
                ", subjetiva=" + subjetiva +
                '}';
    }

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

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public long getIdRespostaSelecionada() {
        return idRespostaSelecionada;
    }

    public void setIdRespostaSelecionada(long idRespostaSelecionada) {
        this.idRespostaSelecionada = idRespostaSelecionada;
    }
}