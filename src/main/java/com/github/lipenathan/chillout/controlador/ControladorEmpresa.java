package com.github.lipenathan.chillout.controlador;



import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class ControladorEmpresa implements Serializable {

    private String cpf;
    private String senha;

    public void cadastrar() {
        System.out.println(cpf + " - " + senha);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
