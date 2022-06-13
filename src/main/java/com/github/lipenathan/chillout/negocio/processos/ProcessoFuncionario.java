package com.github.lipenathan.chillout.negocio.processos;

import com.github.lipenathan.chillout.negocio.dominio.Funcionario;
import com.github.lipenathan.chillout.servicos.repositorio.Repositorio;

import java.util.List;

public class ProcessoFuncionario {

    private Repositorio<Funcionario> repositorioFuncionario;

    public ProcessoFuncionario() {
        this.repositorioFuncionario = new Repositorio<>(Funcionario.class);
    }

    public Funcionario buscarFuncionario(long idUsuario) {
        List<Funcionario> funcionarios = repositorioFuncionario.buscarTodos();
        for (Funcionario f: funcionarios) {
            if (f.getIdUsuario() == idUsuario) {
                return f;
            }
        }
        return null;
    }
}
