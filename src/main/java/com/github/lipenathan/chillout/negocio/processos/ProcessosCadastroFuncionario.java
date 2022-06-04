package com.github.lipenathan.chillout.negocio.processos;

import com.github.lipenathan.chillout.negocio.dominio.Funcionario;
import com.github.lipenathan.chillout.servicos.repositorio.Repositorio;

public class ProcessosCadastroFuncionario {

    private final Repositorio<Funcionario> repositorio;

    public ProcessosCadastroFuncionario() {
        this.repositorio = new Repositorio<>(Funcionario.class);
    }

    public void cadastrar(Funcionario funcionario) throws Exception {
        funcionario.validar();
        repositorio.inserir(funcionario);
    }
}