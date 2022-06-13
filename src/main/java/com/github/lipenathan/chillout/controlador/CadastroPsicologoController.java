package com.github.lipenathan.chillout.controlador;

import com.github.lipenathan.chillout.negocio.dominio.Endereco;
import com.github.lipenathan.chillout.negocio.dominio.Papel;
import com.github.lipenathan.chillout.negocio.dominio.Psicologo;
import com.github.lipenathan.chillout.negocio.processos.ProcessosCadastroPsicologo;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class CadastroPsicologoController implements Serializable {

    private Psicologo psicologo = new Psicologo();

    private Endereco endereco = new Endereco();

    private String senha1;

    private String senha2;

    private final ProcessosCadastroPsicologo processosCadastroPsicologo = new ProcessosCadastroPsicologo();

    private FacesContext context;

    public void cadastrar() {
        context = FacesContext.getCurrentInstance();
        try {
            validarSenhas();
            psicologo.setEnderecoUsuario(endereco);
            psicologo.setPapel(Papel.PSICOLOGO);
            processosCadastroPsicologo.cadastrar(psicologo);
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
            psicologo.setSenha(senha1);
        }
    }

    private void limparCampos() {
        this.psicologo = new Psicologo();
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

    public Psicologo getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(Psicologo psicologo) {
        this.psicologo = psicologo;
    }
}
