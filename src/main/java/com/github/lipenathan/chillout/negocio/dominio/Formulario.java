package com.github.lipenathan.chillout.negocio.dominio;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;

@Entity
public class Formulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FORMULARIO_ID")
    private long id;
    @Column(name = "TITULO_FORMULARIO")
    private String tituloFormulario;
    @Column(name = "DESCRICAO_FORMULARIO")
    private String descricaoFormulario;
    @Column(name = "QTD_PERGUNTAS")
    private int quantidadePerguntas;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Pergunta> perguntas;
    @Column(name = "DATA_CRIACAO")
    private Date dataCricao;
    @Column(name = "DATA_RESPOSTA")
    private Date dataResposta;
    @OneToOne
    @JoinColumn(name = "psicologo_id")
    private Psicologo psicologo;
    @OneToOne(cascade = PERSIST)
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
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

    public Date getDataCricao() {
        return dataCricao;
    }

    public void setDataCricao(Date dataCricao) {
        this.dataCricao = dataCricao;
    }

    public Date getDataResposta() {
        return dataResposta;
    }

    public void setDataResposta(Date dataResposta) {
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
