package com.github.lipenathan.chillout.negocio.dominio;

import com.github.lipenathan.chillout.negocio.exception.NegocioException;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

import static com.github.lipenathan.flynn.validador.Validador.validarCrm;

@Entity
@AttributeOverride(name = "USUARIO_ID", column = @Column(name = "psicologo_id"))
public class Psicologo extends Usuario {

    private String crm;

    @Override
    public String toString() {
        return "Psicologo{" +
                "crm='" + crm + '\'' +
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

    public Psicologo() {
        this.papel = Papel.PSICOLOGO;
    }

    public Psicologo(Usuario usuario) {
        nome = usuario.nome;
        sobrenome = usuario.sobrenome;
        dataNascimento = usuario.dataNascimento;
        cpf = usuario.cpf;
        email = usuario.email;
    }

    @Override
    public void validar() throws NegocioException {
        validarUsuario();
        if (!validarCrm(crm)) throw NegocioException.DOCUMENTO_INVALIDO;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}