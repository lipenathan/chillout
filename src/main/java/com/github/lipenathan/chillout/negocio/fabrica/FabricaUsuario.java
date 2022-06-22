package com.github.lipenathan.chillout.negocio.fabrica;

import com.github.lipenathan.chillout.negocio.dominio.Endereco;
import com.github.lipenathan.chillout.negocio.dominio.Funcionario;
import com.github.lipenathan.chillout.negocio.dominio.Usuario;

import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.github.lipenathan.chillout.negocio.dominio.Papel.FUNCIONARIO;

public class FabricaUsuario {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static List<Funcionario> fabricarFuncionarios(BufferedReader reader) throws Exception {
        List<Funcionario> lista = new ArrayList<>();
        while (reader.ready()) {
            lista.add(fabricarFuncionario(reader.readLine()));
        }
        return lista;
    }

    static private Funcionario fabricarFuncionario(String line) throws Exception {
        Usuario usuario = new Usuario();
        Funcionario funcionario = new Funcionario();
        Endereco endereco = new Endereco();
        String[] split = line.split(",");
        if (split.length < 15) throw new Exception("Arquivo com formato de linhas inválido");
        usuario.setNome(split[0]);
        usuario.setSobrenome(split[1]);
        usuario.setDataNascimento(sdf.parse(split[2]));
        usuario.setCpf(split[3]);
        usuario.setEmail(split[4]);
        usuario.setPapel(FUNCIONARIO);
        usuario.setSenha(usuario.getNome() + "123");
        funcionario.setDataContratacao(sdf.parse(split[5]));
        funcionario.setCargo(split[6]);
        funcionario.setSetor(split[7]);
        endereco.setPais(split[8]);
        endereco.setEstado(split[9]);
        endereco.setComplemento(split[10]);
        endereco.setCidade(split[11]);
        endereco.setBairro(split[12]);
        endereco.setNumeroEndereco(Long.parseLong(split[13]));
        endereco.setRua(split[14]);
        usuario.setEnderecoUsuario(endereco);
        funcionario.setUsuario(usuario);
        funcionario.criptografar();
        return funcionario;
    }
}
