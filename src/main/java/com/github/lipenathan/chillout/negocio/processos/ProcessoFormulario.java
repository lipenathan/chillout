package com.github.lipenathan.chillout.negocio.processos;

import com.github.lipenathan.chillout.negocio.dominio.Formulario;
import com.github.lipenathan.chillout.servicos.repositorio.Repositorio;

import java.util.List;

public class ProcessoFormulario {

    private Repositorio<Formulario> repositorioFormulario;

    public ProcessoFormulario() {
        this.repositorioFormulario = new Repositorio<>(Formulario.class);
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
}
