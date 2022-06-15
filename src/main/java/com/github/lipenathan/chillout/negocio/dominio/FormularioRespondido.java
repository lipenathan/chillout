package com.github.lipenathan.chillout.negocio.dominio;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "FORMULARIO_RESPONDIDO")
public class FormularioRespondido {

    @Id
    @Column(name = "FORMULARIO_RESPONDIDO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DATA_RESPOSTA")
    private LocalDate dataResposta;

    @ManyToOne
    @JoinColumn(name = "FORMULARIO_ID")
    private Formulario formulario;

    @ManyToOne
    @JoinColumn(name = "FUNCIONARIO_ID")
    private Funcionario funcionario;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "formularioRespondido")
    private List<RespostaFuncionario> respostasFuncionario = new ArrayList<>();

    public void vincularRespostas() {
        respostasFuncionario.forEach( r -> r.setFormularioRespondido(this));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataResposta() {
        return dataResposta;
    }

    public void setDataResposta(LocalDate dataResposta) {
        this.dataResposta = dataResposta;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<RespostaFuncionario> getRespostasFuncionario() {
        return respostasFuncionario;
    }

    public void setRespostasFuncionario(List<RespostaFuncionario> respostasFuncionario) {
        this.respostasFuncionario = respostasFuncionario;
    }
}
