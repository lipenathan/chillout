package com.github.lipenathan.chillout.negocio.processos;

import com.github.lipenathan.chillout.negocio.dominio.Usuario;
import com.github.lipenathan.chillout.servicos.repositorio.Repositorio;

import java.util.List;

public class ProcessoLogin {

    private Repositorio<Usuario> repositorioUsuario;

    public ProcessoLogin() {
        this.repositorioUsuario = new Repositorio<>(Usuario.class);
    }

    public Usuario buscarUsuario(String email) {
        List<Usuario> usuarios = repositorioUsuario.buscarTodos();
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }
}