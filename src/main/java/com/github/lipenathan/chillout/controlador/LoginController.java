package com.github.lipenathan.chillout.controlador;

import com.github.lipenathan.chillout.negocio.dominio.Papel;
import com.github.lipenathan.chillout.negocio.dominio.Usuario;
import com.github.lipenathan.chillout.negocio.processos.ProcessoLogin;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.github.lipenathan.chillout.negocio.dominio.Papel.*;

@SessionScoped
@Named
public class LoginController implements Serializable {
    /**
     * Armazena o usuário logado.
     */
    private Usuario usuario = new Usuario();
    private boolean usuarioLogado = false;

    public String logar() {
        ProcessoLogin processoLogin = new ProcessoLogin();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String pagina = "";
        try {
            if (usuario.getEmail().isEmpty()) {
                facesContext.addMessage(null, new FacesMessage("Insira o e-mail"));
            } else if (usuario.getSenha().isEmpty()) {
                facesContext.addMessage(null, new FacesMessage("Insira a senha"));
            } else {
                Usuario u = processoLogin.buscarUsuario(usuario.getEmail());
                if (u == null) {
                    facesContext.addMessage(null, new FacesMessage("E-mail não encontrado"));
                } else if (!senhaValida(u.getSenha())) {
                    facesContext.addMessage(null, new FacesMessage("Senha incorreta"));
                } else {
                    usuario = u;
                    usuarioLogado = true;
                    pagina = seguirFluxo();
                }
            }
        } catch (Exception e) {
            facesContext.addMessage(null, new FacesMessage(e.getMessage()));
        }
        return pagina;
    }

    public String deslogar() {
        this.usuario = new Usuario();
        usuarioLogado = false;
        return "/publico/login.xhtml?faces-redirect=true";
    }

    private boolean senhaValida(String senha) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] stream = messageDigest.digest(usuario.getSenha().getBytes(StandardCharsets.UTF_8));
        String senhaCript = new String(stream, StandardCharsets.UTF_8);
        return senha.equals(senhaCript);
    }

    private String seguirFluxo() {
        if (usuario.getPapel() == GESTOR) {
            return "/privado/gestor.xhtml?faces-redirect=true";
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

    public boolean isUsuarioLogado() {
        return usuarioLogado;
    }

    public boolean isColaborador() {
        return usuario.getPapel() == FUNCIONARIO;
    }

    public boolean isPsicologo() {
        return usuario.getPapel() == PSICOLOGO;
    }

    public boolean isGestor() {
        return usuario.getPapel() == GESTOR;
    }
}
