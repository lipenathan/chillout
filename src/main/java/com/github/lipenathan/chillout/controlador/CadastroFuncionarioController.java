package com.github.lipenathan.chillout.controlador;

import com.github.lipenathan.chillout.negocio.dominio.*;
import com.github.lipenathan.chillout.negocio.processos.ProcessosCadastroFuncionario;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@ViewScoped
@ManagedBean
public class CadastroFuncionarioController implements Serializable {

    private Funcionario funcionario = new Funcionario();

    private Endereco endereco = new Endereco();

    private String senha1;

    private String senha2;

    private final ProcessosCadastroFuncionario processosCadastroFuncionario = new ProcessosCadastroFuncionario();

    private FacesContext context;

    public void cadastrar() {
        context = FacesContext.getCurrentInstance();
        try {
            validarSenhas();
            funcionario.setEnderecoUsuario(endereco);
            funcionario.setPapel(Papel.GESTOR);
            processosCadastroFuncionario.cadastrar(funcionario);
            limparCampos();
            context.addMessage(null, new FacesMessage("Usuário cadastrado com sucesso"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(e.getMessage()));
        }
    }

    // métodos de apoio privados
    private void validarSenhas() throws Exception {
        if (!senha1.equals(senha2)) {
            throw new Exception("As senhas precisam ser a mesma");
        } else {
            funcionario.setSenha(senha1);
        }
    }

    private void limparCampos() {
        this.funcionario = new Funcionario();
        this.endereco = new Endereco();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getSenha1() {
        return senha1;
    }

    public void setSenha1(String senha1) {
        this.senha1 = senha1;
    }

    public String getSenha2() {
        return senha2;
    }

    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
