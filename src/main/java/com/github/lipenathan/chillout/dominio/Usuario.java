package com.github.lipenathan.chillout.dominio;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.*;
import java.time.temporal.Temporal;

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