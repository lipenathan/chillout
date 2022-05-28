package com.github.lipenathan.chillout.negocio.processos;

import com.github.lipenathan.chillout.negocio.dominio.Usuario;
import com.github.lipenathan.chillout.servicos.repositorio.Repositorio;

public class ProcessosCadastroUsuario {

    private final Repositorio<Usuario> repositorio;

    public ProcessosCadastroUsuario() {
        this.repositorio = new Repositorio<>(Usuario.class);
    }

    public void cadastrar(Usuario usuario) throws Exception {
        usuario.validar();
        repositorio.inserir(usuario);
    }
}