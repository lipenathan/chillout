package com.github.lipenathan.chillout.negocio.dominio;

import com.github.lipenathan.chillout.negocio.exception.NegocioException;
import com.github.lipenathan.chillout.utils.Validacao;
import com.github.lipenathan.flynn.validador.Validador;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static com.github.lipenathan.chillout.utils.Validacao.validarCampoObrigatorio;
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
    @Column(name = "QTD_PERGUNTA")
    private int quantidadePerguntas;
    @OneToMany(cascade = PERSIST, mappedBy = "id")
    private List<Pergunta> perguntas;
    @Column(name = "DATA_CRIACAO")
    private Date dataCricao;
    @Column(name = "DATA_RESPOSTA")
    private Date dataResposta;
    @OneToOne
    @JoinColumn(name = "PSICOLOGO_ID")
    private Psicologo psicologo;
    @OneToOne
    @JoinColumn(name = "FEEDBACK_ID")
    private Feedback feedback;
    @ManyToOne
    @JoinColumn(name = "FUNCIONARIO_ID")
    private Funcionario funcionarioRespondente;

    public void validar() throws NegocioException {
        try {
            validarCampoObrigatorio("título formulário", tituloFormulario);
            validarCampoObrigatorio("descrição formulário", descricaoFormulario);
            validarCampoObrigatorio("lista de perguntas", perguntas);
            validarCampoObrigatorio("psicólogo", psicologo);
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Formulario{" +
                "id=" + id +
                ", tituloFormulario='" + tituloFormulario + '\'' +
                ", descricaoFormulario='" + descricaoFormulario + '\'' +
                ", quantidadePerguntas=" + quantidadePerguntas +
                ", perguntas=" + perguntas +
                ", dataCricao=" + dataCricao +
                ", dataResposta=" + dataResposta +
                ", psicologo=" + psicologo +
                ", feedback=" + feedback +
                ", funcionarioRespondente=" + funcionarioRespondente +
                '}';
    }

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
