package com.github.lipenathan.chillout.servicos.repositorio;

import com.github.lipenathan.chillout.negocio.dominio.*;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

import static com.github.lipenathan.chillout.negocio.dominio.Papel.FUNCONARIO;

public class TesteRepositorioUsuario {

    private Repositorio<Psicologo> repositorioPsicologo = new Repositorio<>(Psicologo.class);
    private Repositorio<Funcionario> repositorioUsuario = new Repositorio<>(Funcionario.class);

    @Test
    public void testeInserirPsicologo() {
        Psicologo psicologo = new Psicologo();
        psicologo.setNome("Dra. Alice");
        psicologo.setCrm("123456");
        psicologo.setCpf("11122233344");
        psicologo.setDataNascimento(Date.valueOf(LocalDate.of(1996, 12, 28)));
        Endereco endereco = new Endereco();
        endereco.setRua("Rua do psicologo");
        endereco.setNumeroEndereco(120);
        endereco.setBairro("Bairro exemplo");
        endereco.setComplemento("fundos");
        endereco.setEstado("PR");
        endereco.setPais("Brasil");
        psicologo.setEnderecoUsuario(endereco);
        repositorioPsicologo.inserir(psicologo);
    }

    @Test
    public void testeInserirFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Usuario Joao");
        funcionario.setSobrenome("da Silva");
        funcionario.setCargo("Gerente");
        funcionario.setPapel(FUNCONARIO);
        funcionario.setCpf("00011122255");
        funcionario.setDataNascimento(Date.valueOf(LocalDate.of(1996, 12, 28)));
        funcionario.setDataContratacao(Date.valueOf(LocalDate.of(2022, 01, 02)));
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
        funcionario.setDataNascimento(Date.valueOf(LocalDate.of(1996, 12, 28)));
        funcionario.setDataContratacao(Date.valueOf(LocalDate.of(2022, 01, 02)));
        funcionario.getUsuario().calcularIdade();
        System.out.println(funcionario.getIdade());
    }
}
