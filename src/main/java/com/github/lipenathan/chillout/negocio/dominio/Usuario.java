package com.github.lipenathan.chillout.negocio.dominio;

import com.github.lipenathan.chillout.negocio.exception.NegocioException;
import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;

import static com.github.lipenathan.flynn.validador.Validador.apenasAlfabetico;
import static com.github.lipenathan.flynn.validador.Validador.validarCpf;
import static javax.persistence.CascadeType.PERSIST;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
    @Id
    @Column(name = "USUARIO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected String nome;
    protected String sobrenome;
    @Column(name = "DATA_NASCIMENTO")
    protected Date dataNascimento;
    protected String cpf;
    protected String email;
    @Transient
    protected int idade = 0;
    protected String senha;
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_USUARIO")
    protected Papel papel;
    @OneToOne(cascade = PERSIST)
    @JoinColumn(name = "ENDERECO_ID")
    protected Endereco enderecoUsuario;

    public void calcularIdade() {
        int nascimento = dataNascimento.getYear();
        int hoje = LocalDate.now().getYear();
        this.idade = hoje - nascimento;
    }

    public void validar() throws NegocioException {
        validarUsuario();
    }

    protected void validarUsuario() throws NegocioException {
        if (nome == null || nome.isEmpty()) throw NegocioException.NOME_INVALIDO;
        if (dataNascimento == null) throw NegocioException.DATA_NASCIMENTO_INVALIDA;
        if (papel == null) throw NegocioException.PAPEL_INVALIDO;
        enderecoUsuario.validar();
        validarSenha();
    }

    /** Verifica se o CPF é válido **/
    protected void validarcpf() throws NegocioException {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
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