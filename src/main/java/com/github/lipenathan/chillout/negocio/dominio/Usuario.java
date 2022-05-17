package com.github.lipenathan.chillout.negocio.dominio;

import com.github.lipenathan.chillout.negocio.exception.NegocioException;
import jakarta.persistence.*;

import java.time.LocalDate;

import static com.github.lipenathan.flynn.validador.Validador.apenasAlfabetico;
import static com.github.lipenathan.flynn.validador.Validador.validarCpf;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    protected String nome;
    protected String sobrenome;
    protected LocalDate dataNascimento;
    protected String cpf;
    @Transient
    protected int idade = 0;
    protected String senha;
    @Enumerated(EnumType.STRING)
    protected Papel papel;
    @OneToOne(cascade = PERSIST)
    @JoinColumn(name = "id_endereco")
    protected Endereco enderecoUsuario;

    public void calcularIdade() {
        int nascimento = dataNascimento.getYear();
        int hoje = LocalDate.now().getYear();
        this.idade = hoje - nascimento;
    }

    public abstract void validar() throws NegocioException;

    protected void validarUsuario() throws NegocioException {
        if (nome == null || nome.isEmpty()) throw NegocioException.NOME_INVALIDO;
        if (dataNascimento == null) throw NegocioException.DATA_NASCIMENTO_INVALIDA;
        if (enderecoUsuario == null) throw NegocioException.ENDERECO_INVALIDO;
        validarcpf();
        validarSenha();
    }

    /** Verifica se o CPF é válido **/
    private void validarcpf() throws NegocioException {
        if (cpf == null || cpf.isEmpty()) throw NegocioException.DOCUMENTO_INVALIDO;
        if (!validarCpf(cpf)) throw NegocioException.DOCUMENTO_INVALIDO;
    }

    /** Valida a regra de senha proposta pela aplicação **/
    private void validarSenha() throws NegocioException {
        if (senha == null || senha.isEmpty() || senha.length() < 6) throw NegocioException.SENHA_INVALIDA;
        if (apenasAlfabetico(senha)) throw NegocioException.SENHA_INVALIDA_CARACTERES;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    public Endereco getEnderecoUsuario() {
        return enderecoUsuario;
    }

    public void setEnderecoUsuario(Endereco enderecoUsuario) {
        this.enderecoUsuario = enderecoUsuario;
    }
}