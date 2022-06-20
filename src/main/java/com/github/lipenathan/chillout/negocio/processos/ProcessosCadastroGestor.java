package com.github.lipenathan.chillout.negocio.processos;

import com.github.lipenathan.chillout.negocio.dominio.Empresa;
import com.github.lipenathan.chillout.negocio.dominio.Funcionario;
import com.github.lipenathan.chillout.servicos.repositorio.Repositorio;

import java.util.List;

public class ProcessosCadastroGestor {

    private final Repositorio<Funcionario> repositorioFuncionario;
    private final Repositorio<Empresa> repositorioEmpresa;

    public ProcessosCadastroGestor() {
        this.repositorioFuncionario = new Repositorio<>(Funcionario.class);
        this.repositorioEmpresa = new Repositorio<>(Empresa.class);
    }

    public void cadastrar(Funcionario funcionario) throws Exception {
        funcionario.validar();
        funcionario.criptografar();
        repositorioFuncionario.inserir(funcionario);
    }

    public Empresa buscarEmpresaPeloCnpj(String cnpj) {
        List<Empresa> empresas = repositorioEmpresa.buscarTodos();
        for (Empresa e:empresas) {
            if (cnpj.equals(e.getCnpj())) {
                return e;
            }
        }
        return null;
    }
}