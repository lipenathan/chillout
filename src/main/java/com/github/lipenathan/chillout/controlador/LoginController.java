package com.github.lipenathan.chillout.controlador;

import com.github.lipenathan.chillout.negocio.dominio.Papel;
import com.github.lipenathan.chillout.negocio.dominio.Usuario;
import com.github.lipenathan.chillout.negocio.processos.ProcessoLogin;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class LoginController implements Serializable {
    private Usuario usuario = new Usuario();
    private ProcessoLogin processoLogin;
    private FacesContext facesContext;

    public LoginController() {
        processoLogin = new ProcessoLogin();
        facesContext = FacesContext.getCurrentInstance();
    }

    public String logar() {
        String pagina = "";
        if (usuario.getEmail().isEmpty()) {
            facesContext.addMessage(null, new FacesMessage("Insira o e-mail"));
        } else if (usuario.getSenha().isEmpty()) {
            facesContext.addMessage(null, new FacesMessage("Insira a senha"));
        } else {
            Usuario u = processoLogin.buscarUsuario(usuario.getEmail());
            if (u == null) {
                facesContext.addMessage(null, new FacesMessage("E-mail não encontrado"));
            }
            if (!u.getSenha().equals(usuario.getSenha())) {
                facesContext.addMessage(null, new FacesMessage("Senha incorreta"));
            } else {
                usuario = u;
                pagina = seguirFluxo();
            }
        }
        return pagina;
    }

    private String seguirFluxo() {
        if (usuario.getPapel() == Papel.GESTOR) {
            return "/publico/temp.xhtml?faces-redirect=true";
        } else if (usuario.getPapel() == Papel.PSICOLOGO) {
            return "/privado/cadastro_formulario.xhtml?faces-redirect=true";
        } else {
            return "/privado/formulario.xhtml?faces-redirect=true";
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
