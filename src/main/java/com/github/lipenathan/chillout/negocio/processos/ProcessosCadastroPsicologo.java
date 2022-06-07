package com.github.lipenathan.chillout.negocio.processos;

import com.github.lipenathan.chillout.negocio.dominio.Psicologo;
import com.github.lipenathan.chillout.servicos.repositorio.Repositorio;

public class ProcessosCadastroPsicologo {

    private final Repositorio<Psicologo> repositorio;

    public ProcessosCadastroPsicologo() {
        this.repositorio = new Repositorio<>(Psicologo.class);
    }

    public void cadastrar(Psicologo psicologo) throws Exception {
        psicologo.validar();
        repositorio.inserir(psicologo);
    }
}