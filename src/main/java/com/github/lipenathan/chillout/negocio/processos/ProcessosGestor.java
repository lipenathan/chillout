package com.github.lipenathan.chillout.negocio.processos;

import com.github.lipenathan.chillout.negocio.dominio.Funcionario;
import com.github.lipenathan.chillout.servicos.repositorio.Repositorio;

import java.util.List;

public class ProcessosGestor {

    private Repositorio<Funcionario> repositorioFuncionario;

    public ProcessosGestor() {
        this.repositorioFuncionario = new Repositorio<>(Funcionario.class);
    }

    public Funcionario buscarGestorPeloId(long id) {
        Funcionario funcionario = null;
        List<Funcionario> funcionarios = repositorioFuncionario.buscarTodos();
        for (Funcionario f : funcionarios) {
            if (f.getIdUsuario() == id) {
                funcionario = f;
            }
        }
        return funcionario;
    }

    public void cadastrarFuncionarios(List<Funcionario> funcionarios) {
        funcionarios.forEach(f -> {
            repositorioFuncionario.inserir(f);
        });
    }
}