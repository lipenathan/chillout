package com.github.lipenathan.chillout.servicos.repositorio;

import com.github.lipenathan.chillout.negocio.dominio.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.github.lipenathan.chillout.negocio.dominio.Papel.FUNCONARIO;

public class TesteRepositorioUsuario {

    private Repositorio<Usuario> repositorioUsuario = new Repositorio<>(Usuario.class);

    @Test
    public void testeInserirPsicologo() {
        Psicologo psicologo = new Psicologo();
        psicologo.setNome("Dra. Alice");
        psicologo.setCrm("123456");
        psicologo.setCpf("11122233344");
        psicologo.setDataNascimento(LocalDate.of(1996, 12, 28));
        Endereco endereco = new Endereco();
        endereco.setRua("Rua do psicologo");
        endereco.setNumeroEndereco(120);
        endereco.setBairro("Bairro exemplo");
        endereco.setComplemento("fundos");
        endereco.setEstado("PR");
        endereco.setPais("Brasil");
        psicologo.setEnderecoUsuario(endereco);
        repositorioUsuario.inserir(psicologo);
    }

    @Test
    public void testeInserirFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Usuario Joao");
        funcionario.setSobrenome("da Silva");
        funcionario.setCargo("Gerente");
        funcionario.setPapel(FUNCONARIO);
        funcionario.setCpf("00011122255");
        funcionario.setDataNascimento(LocalDate.of(1996, 12, 28));
        funcionario.setDataContratacao(LocalDate.of(2022, 01, 01));
        Endereco endereco = new Endereco();
        endereco.setRua("rua do funcionario teste");
        endereco.setBairro("bairro exemplo");
        endereco.setCidade("Londrina");
        endereco.setEstado("PR");
        endereco.setPais("Brasil");
        endereco.setComplemento("Prédio 3º andar");
        funcionario.setEnderecoUsuario(endereco);
        HistoricoSaude historicoSaude = new HistoricoSaude();
        historicoSaude.setDescricaoHistorico("Tive alguns problemas de saúde no último semestre");
        historicoSaude.setHistoricoAnsiedade(true);
        historicoSaude.setHistoricoDepressaoFamilia(false);
        historicoSaude.setSurtoUltimoAno(true);
        funcionario.setHistoricoSaude(historicoSaude);
        repositorioUsuario.inserir(funcionario);
    }

    @Test
    public void testeCalcularIdade() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Usuario Joao");
        funcionario.setSobrenome("da Silva");
        funcionario.setCargo("Gerente");
        funcionario.setPapel(FUNCONARIO);
        funcionario.setCpf("00011122255");
        funcionario.setDataNascimento(LocalDate.of(1996, 12, 28));
        funcionario.setDataContratacao(LocalDate.of(2022, 01, 01));
        funcionario.calcularIdade();
        System.out.println(funcionario.getIdade());
    }
}
