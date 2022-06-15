package com.github.lipenathan.chillout.controlador;

import com.github.lipenathan.chillout.negocio.dominio.*;
import com.github.lipenathan.chillout.negocio.processos.ProcessoFormulario;
import com.github.lipenathan.chillout.negocio.processos.ProcessoFuncionario;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;

@ViewScoped
@Named
public class FormularioController implements Serializable {

    private LoginController login;

    private ProcessoFormulario processoFormulario;

    private ProcessoFuncionario processoFuncionario;

    private Formulario formulario;

    private Funcionario funcionario;

    private FormularioRespondido formularioRespondido = new FormularioRespondido();

    private RespostaFuncionario respostaSubjetiva = new RespostaFuncionario();

    private FacesContext facesContext;

    @Inject
    public FormularioController(LoginController login) {
        facesContext = FacesContext.getCurrentInstance();
        this.login = login;
        processoFormulario = new ProcessoFormulario();
        processoFuncionario = new ProcessoFuncionario();
        buscarFuncionario();
        buscarFormulario();
    }

    public String responderFormulario() {
        try {
            validarRespostas();
            setarRespostas();
            formularioRespondido.setFormulario(formulario);
            formularioRespondido.setFuncionario(funcionario);
            formularioRespondido.setDataResposta(LocalDate.now());
            processoFormulario.responderFormulario(formularioRespondido);
            return "/publico/home.xhtml?faces-redirect=true";
        } catch (Exception e) {
            facesContext.addMessage(null, new FacesMessage(e.getMessage()));
        }
        return null;
    }

    private void validarRespostas() throws Exception {
        for (Pergunta p : formulario.getPerguntas()) {
            if ((!p.isSubjetiva() && p.getIdRespostaSelecionada() <= 0)
                    || (respostaSubjetiva.getTextoResposta() == null || respostaSubjetiva.getTextoResposta().isEmpty())) {
                throw new Exception("Todas as perguntas precisam ser preenchidas");
            }
        }
    }

    private void setarRespostas() {
        formulario.getPerguntas().forEach(pergunta -> {
            if (pergunta.isSubjetiva()) {
                respostaSubjetiva.setResposta(pergunta.getRespostas().get(0));
                respostaSubjetiva.setFormularioRespondido(formularioRespondido);
                formularioRespondido.getRespostasFuncionario().add(respostaSubjetiva);
            } else {
                pergunta.getRespostas().forEach(resposta -> {
                    if (resposta.getId() == pergunta.getIdRespostaSelecionada()) {
                        formularioRespondido.getRespostasFuncionario().add(new RespostaFuncionario(resposta, formularioRespondido));
                    }
                });
            }
        });
    }

    private void buscarFormulario() {
        formulario = processoFormulario.buscarFormulario(funcionario.getIdEmpresaFuncionario());
    }

    private void buscarFuncionario() {
        funcionario = processoFuncionario.buscarFuncionario(login.getUsuario().getId());
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public FormularioRespondido getFormularioRespondido() {
        return formularioRespondido;
    }

    public void setFormularioRespondido(FormularioRespondido formularioRespondido) {
        this.formularioRespondido = formularioRespondido;
    }

    public RespostaFuncionario getRespostaSubjetiva() {
        return respostaSubjetiva;
    }

    public void setRespostaSubjetiva(RespostaFuncionario respostaSubjetiva) {
        this.respostaSubjetiva = respostaSubjetiva;
    }
}
