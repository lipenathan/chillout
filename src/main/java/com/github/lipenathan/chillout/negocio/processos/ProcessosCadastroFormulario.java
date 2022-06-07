package com.github.lipenathan.chillout.negocio.processos;

import com.github.lipenathan.chillout.negocio.dominio.Formulario;
import com.github.lipenathan.chillout.negocio.dominio.Pergunta;
import com.github.lipenathan.chillout.servicos.repositorio.Repositorio;

import java.util.List;

public class ProcessosCadastroFormulario {

    private final Repositorio<Formulario> repositorioFormulario;

    public ProcessosCadastroFormulario() {
        this.repositorioFormulario = new Repositorio<>(Formulario.class);
    }

    public void cadastrarFormulario(Formulario formulario) throws Exception {
        formulario.validar();
        repositorioFormulario.inserir(formulario);
    }
}