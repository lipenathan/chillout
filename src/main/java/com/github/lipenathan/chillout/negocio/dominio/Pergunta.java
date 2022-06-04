package com.github.lipenathan.chillout.negocio.dominio;

import com.github.lipenathan.chillout.negocio.exception.NegocioException;

import javax.persistence.*;
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
    @OneToOne
    @JoinColumn(name = "RESPOSTA_FUNCIONARIO_ID")
    private RespostaFuncionario respostaFuncionario;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "id")
    private List<Resposta> respostas = Arrays.asList(new Resposta(), new Resposta(), new Resposta(),
            new Resposta(), new Resposta());

    public Pergunta(boolean subjetiva) {
        this.subjetiva = subjetiva;
    }

    public Pergunta() {
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
                ", respostaFuncionario=" + respostaFuncionario +
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

    public RespostaFuncionario getRespostaFuncionario() {
        return respostaFuncionario;
    }

    public void setRespostaFuncionario(RespostaFuncionario respostaFuncionario) {
        this.respostaFuncionario = respostaFuncionario;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }
}