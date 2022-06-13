package com.github.lipenathan.chillout.controlador;

import com.github.lipenathan.chillout.negocio.dominio.Formulario;
import com.github.lipenathan.chillout.negocio.dominio.Funcionario;
import com.github.lipenathan.chillout.negocio.processos.ProcessoFormulario;
import com.github.lipenathan.chillout.negocio.processos.ProcessoFuncionario;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class FormularioController implements Serializable {

    private LoginController login;

    private ProcessoFormulario processoFormulario;

    private ProcessoFuncionario processoFuncionario;

    private Formulario formulario;

    private Funcionario funcionario;

    @Inject
    public FormularioController(LoginController login) {
        this.login = login;
        processoFormulario = new ProcessoFormulario();
        processoFuncionario = new ProcessoFuncionario();
        buscarFuncionario();
        buscarFormulario();
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
}
