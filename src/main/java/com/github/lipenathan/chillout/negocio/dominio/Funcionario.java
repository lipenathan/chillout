package com.github.lipenathan.chillout.negocio.dominio;

import com.github.lipenathan.chillout.negocio.exception.NegocioException;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.CascadeType.PERSIST;

@Entity
@AttributeOverrides({
        @AttributeOverride(name="USUARIO_ID", column=@Column(name="FUNCIONARIO_ID"))
})
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "DATA_CONTRATACAO")
    private Date dataContratacao;
    private String cargo;
    private String setor;
    @OneToOne(cascade = PERSIST)
    @JoinColumn(name = "HISTORICO_SAUDE_ID")
    private HistoricoSaude historicoSaude;
    @OneToOne(cascade = PERSIST)
    @JoinColumn(name = "USUARIO_ID")
    private Usuario usuario = new Usuario();
    @ManyToOne
    @JoinColumn(name = "EMPRESA_ID")
    private Empresa empresa;

    public Funcionario() {
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "dataContratacao=" + dataContratacao +
                ", cargo='" + cargo + '\'' +
                ", setor='" + setor + '\'' +
                ", historicoSaude=" + historicoSaude +
                '}';
    }

    public void validar() throws NegocioException {
        usuario.validarUsuario();
        usuario.validarcpf();
        if (dataContratacao == null) throw NegocioException.DATA_CONTRATACAO_INVALIDA;
        if (cargo == null || cargo.isEmpty()) throw NegocioException.CARGO_INVALIDO;
        if (setor == null || setor.isEmpty()) throw NegocioException.SETOR_INVALIDO;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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

    public String getNome() {
        return usuario.nome;
    }

    public void setNome(String nome) {
        this.usuario.nome = nome;
    }

    public String getSobrenome() {
        return usuario.sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.usuario.sobrenome = sobrenome;
    }

    public String getEmail() {
        return usuario.email;
    }

    public void setEmail(String email) {
        this.usuario.email = email;
    }

    public void setIdade(int idade) {
        this.usuario.idade = idade;
    }

    public Date getDataNascimento() {
        return usuario.dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.usuario.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return usuario.cpf;
    }

    public void setCpf(String cpf) {
        this.usuario.cpf = cpf;
    }

    public int getIdade() {
        return usuario.idade;
    }

    public String getSenha() {
        return usuario.senha;
    }

    public void setSenha(String senha) {
        this.usuario.senha = senha;
    }

    public Papel getPapel() {
        return usuario.papel;
    }

    public void setPapel(Papel papel) {
        this.usuario.papel = papel;
    }

    public Endereco getEnderecoUsuario() {
        return usuario.enderecoUsuario;
    }

    public void setEnderecoUsuario(Endereco enderecoUsuario) {
        this.usuario.enderecoUsuario = enderecoUsuario;
    }
}
