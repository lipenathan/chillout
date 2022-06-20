package com.github.lipenathan.chillout.negocio.dominio;

import com.github.lipenathan.chillout.negocio.exception.NegocioException;

import javax.persistence.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import static com.github.lipenathan.flynn.validador.Validador.validarCrm;

@Entity
public class Psicologo {

    @Id
    @Column(name = "PSICOLOGO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String crm;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USUARIO_ID")
    private Usuario usuario = new Usuario();

    @Override
    public String toString() {
        return "Psicologo{" +
                "crm='" + crm + '\'' +
                ", id=" + id +
                ", usuario='" + usuario + '\'';
    }

    public Psicologo() {
        this.usuario.setPapel(Papel.PSICOLOGO);
    }

    public Psicologo(long id, String crm) {
        this.id = id;
        this.crm = crm;
    }

    public void validar() throws NegocioException {
        usuario.validarUsuario();
        if (!validarCrm(crm)) throw NegocioException.DOCUMENTO_INVALIDO;
    }

    public void criptografar() throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte stream[] = messageDigest.digest(getSenha().getBytes(StandardCharsets.UTF_8));
        String senha = new String(stream, StandardCharsets.UTF_8);
        this.setSenha(senha);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
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