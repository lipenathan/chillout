package com.github.lipenathan.chillout.negocio.processos;

import com.github.lipenathan.chillout.negocio.dominio.Formulario;
import com.github.lipenathan.chillout.negocio.dominio.FormularioRespondido;
import com.github.lipenathan.chillout.servicos.repositorio.Repositorio;

import java.util.List;

public class ProcessoFormulario {

    private Repositorio<Formulario> repositorioFormulario;
    private Repositorio<FormularioRespondido> repositorioFormularioRespondido;

    public ProcessoFormulario() {
        this.repositorioFormulario = new Repositorio<>(Formulario.class);
        this.repositorioFormularioRespondido = new Repositorio<>(FormularioRespondido.class);
    }

    public Formulario buscarFormulario(long idEpresa) {
        List<Formulario> formularios = repositorioFormulario.buscarTodos();
        for (Formulario f: formularios) {
            if (f.getIdEmpresaFormulario() == idEpresa) {
                return f;
            }
        }
        return null;
    }

    public void responderFormulario(FormularioRespondido formularioRespondido) {
        repositorioFormularioRespondido.inserir(formularioRespondido);
    }
}
