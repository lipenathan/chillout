package com.github.lipenathan.chillout.negocio.dominio;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Formulario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String tituloFormulario;
    private String descricaoFormulario;
    private int quantidadePerguntas;
    @OneToMany(mappedBy = "id", cascade = CascadeType.PERSIST)
    private List<Pergunta> perguntas;
    private LocalDateTime dataCricao;
    private LocalDateTime dataResposta;
    @OneToOne(mappedBy = "id")
    private Psicologo psicologo;
    @OneToOne(mappedBy = "id")
    private Feedback feedback;
    @ManyToOne
    private Funcionario funcionarioRespondente;

    public String getTituloFormulario() {
        return tituloFormulario;
    }

    public void setTituloFormulario(String tituloFormulario) {
        this.tituloFormulario = tituloFormulario;
    }

    public String getDescricaoFormulario() {
        return descricaoFormulario;
    }

    public void setDescricaoFormulario(String descricaoFormulario) {
        this.descricaoFormulario = descricaoFormulario;
    }

    public int getQuantidadePerguntas() {
        return quantidadePerguntas;
    }

    public void setQuantidadePerguntas(int quantidadePerguntas) {
        this.quantidadePerguntas = quantidadePerguntas;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    public LocalDateTime getDataCricao() {
        return dataCricao;
    }

    public void setDataCricao(LocalDateTime dataCricao) {
        this.dataCricao = dataCricao;
    }

    public LocalDateTime getDataResposta() {
        return dataResposta;
    }

    public void setDataResposta(LocalDateTime dataResposta) {
        this.dataResposta = dataResposta;
    }

    public Psicologo getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(Psicologo psicologo) {
        this.psicologo = psicologo;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public Funcionario getFuncionarioRespondente() {
        return funcionarioRespondente;
    }

    public void setFuncionarioRespondente(Funcionario funcionarioRespondente) {
        this.funcionarioRespondente = funcionarioRespondente;
    }
}
