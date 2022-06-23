package com.github.lipenathan.chillout.controlador;

import com.github.lipenathan.chillout.negocio.dominio.Empresa;
import com.github.lipenathan.chillout.negocio.dominio.Endereco;
import com.github.lipenathan.chillout.negocio.dominio.Funcionario;
import com.github.lipenathan.chillout.negocio.dominio.Papel;
import com.github.lipenathan.chillout.negocio.processos.ProcessosCadastroGestor;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class CadastroGestorController implements Serializable {

    private Funcionario funcionario = new Funcionario();

    private Endereco endereco = new Endereco();

    private String cnpj;

    private String senha1;

    private String senha2;

    private final ProcessosCadastroGestor processosCadastroGestor = new ProcessosCadastroGestor();

    public String cadastrar() {
        String navegacao = "";
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            funcionario.setEnderecoUsuario(endereco);
            funcionario.setPapel(Papel.GESTOR);
            validarEmpresa();
            validarSenhas();
            processosCadastroGestor.cadastrar(funcionario);
            limparCampos();
            context.addMessage(null, new FacesMessage("Usuário cadastrado com sucesso"));
            navegacao = "/privado/gestor.xhtml?faces-redirect=true";
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(e.getMessage()));
        }
        return navegacao;
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
        cnpj = "";
    }

    private void validarEmpresa() throws Exception {
        cnpj = cnpj.replace(".","").replace("/","").replace("-","");
        Empresa e = processosCadastroGestor.buscarEmpresaPeloCnpj(cnpj);
        if (e == null) {
            throw new Exception("Empresa não encontrada.\nFaça o cadastro empresarial primeiro");
        } else {
            funcionario.setEmpresa(e);
        }
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
