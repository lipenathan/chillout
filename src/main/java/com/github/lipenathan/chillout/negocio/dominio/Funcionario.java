package com.github.lipenathan.chillout.negocio.dominio;

import com.github.lipenathan.chillout.negocio.exception.NegocioException;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.CascadeType.PERSIST;

@Entity
@AttributeOverrides({
        @AttributeOverride(name="USUARIO_ID", column=@Column(name="FUNCIONARIO_ID"))
})
public class Funcionario extends Usuario {

    @Column(name = "DATA_CONTRATACAO")
    private Date dataContratacao;
    private String cargo;
    private String setor;
    @OneToOne(cascade = PERSIST)
    @JoinColumn(name = "HISTORICO_SAUDE_ID")
    private HistoricoSaude historicoSaude;

    public Funcionario(Usuario usuario) {
        nome = usuario.nome;
        sobrenome = usuario.sobrenome;
        dataNascimento = usuario.dataNascimento;
        cpf = usuario.cpf;
        email = usuario.email;
    }

    public Funcionario() {
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "dataContratacao=" + dataContratacao +
                ", cargo='" + cargo + '\'' +
                ", setor='" + setor + '\'' +
                ", historicoSaude=" + historicoSaude +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                ", senha='" + senha + '\'' +
                ", papel=" + papel +
                ", enderecoUsuario=" + enderecoUsuario +
                '}';
    }

    @Override
    public void validar() throws NegocioException {
        validarUsuario();
        if (dataContratacao == null) throw NegocioException.DATA_CONTRATACAO_INVALIDA;
        if (cargo == null || cargo.isEmpty()) throw NegocioException.CARGO_INVALIDO;
        if (setor == null || setor.isEmpty()) throw NegocioException.SETOR_INVALIDO;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public HistoricoSaude getHistoricoSaude() {
        return historicoSaude;
    }

    public void setHistoricoSaude(HistoricoSaude historicoSaude) {
        this.historicoSaude = historicoSaude;
    }
}
