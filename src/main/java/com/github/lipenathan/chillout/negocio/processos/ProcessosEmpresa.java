package com.github.lipenathan.chillout.negocio.processos;

import com.github.lipenathan.chillout.negocio.dominio.Usuario;
import com.github.lipenathan.chillout.servicos.repositorio.Repositorio;

public class ProcessosEmpresa {

    private Repositorio<Usuario> repositorio;

    public ProcessosEmpresa() {
        this.repositorio = new Repositorio<>(Usuario.class);
    }

    public void cadastrarUsuario(Usuario usuario) throws Exception {
        usuario.validar();
        repositorio.inserir(usuario);
    }
}
