package com.github.lipenathan.chillout.negocio.processos;

import com.github.lipenathan.chillout.negocio.dominio.Empresa;
import com.github.lipenathan.chillout.servicos.repositorio.Repositorio;

public class ProcessosCadastroEmpresa {

    private Repositorio<Empresa> repositorio;

    public ProcessosCadastroEmpresa() {
        this.repositorio = new Repositorio<>(Empresa.class);
    }

    public void cadastrar(Empresa empresa) throws Exception {
        empresa.validar();
        repositorio.inserir(empresa);
    }
}