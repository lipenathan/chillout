package com.github.lipenathan.chillout.mock;

import com.github.lipenathan.chillout.negocio.dominio.Endereco;
import com.github.lipenathan.chillout.negocio.dominio.Funcionario;
import com.github.lipenathan.chillout.negocio.dominio.Usuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

import static com.github.lipenathan.chillout.negocio.dominio.Papel.FUNCIONARIO;

public class MockFuncionarios {

    public static void main(String[] args) {
        FileReader f = null;
        try {
            f = new FileReader("D:/worspace-facul/funcionarios.txt");
            BufferedReader bufReader = new BufferedReader(f);
//            String s = bufReader.readLine();
            try {
                while (bufReader.readLine() != null) {
                    Funcionario funcionario = fabricarFuncionario(bufReader.readLine());
                    System.out.println(funcionario);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(f);
    }

    static Funcionario fabricarFuncionario(String line) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
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
        endereco.setNumeroEndereco(Long.valueOf(split[13]));
        endereco.setRua(split[14]);
        usuario.setEnderecoUsuario(endereco);
        funcionario.setUsuario(usuario);
        funcionario.criptografar();
        return funcionario;
    }
}
