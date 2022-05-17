package com.github.lipenathan.chillout.servicos.repositorio;

import com.github.lipenathan.chillout.negocio.dominio.Endereco;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TesteRepositorioEndereco {

    Repositorio<Endereco> repositorioEndereco = new Repositorio<>(Endereco.class);

    @Test
    public void testeInserirEndereco() {
        Endereco endereco = new Endereco();
        endereco.setRua("rua teste");
        endereco.setBairro("bairro teste");
        endereco.setNumeroEndereco(88);
        endereco.setCidade("Londrina");
        endereco.setEstado("Paraná");
        endereco.setPais("Brasil");
        endereco.setComplemento("prédio");
        repositorioEndereco.inserir(endereco);
    }

    @Test
    public void testeListarEndereco() {
        Endereco endereco1 = new Endereco();
        endereco1.setRua("rua teste");
        endereco1.setBairro("bairro teste");
        endereco1.setNumeroEndereco(88);
        endereco1.setCidade("Londrina");
        endereco1.setEstado("Paraná");
        endereco1.setPais("Brasil");
        endereco1.setComplemento("prédio");

        Endereco endereco2 = new Endereco();
        endereco2.setRua("rua teste2");
        endereco2.setBairro("bairro teste2");
        endereco2.setNumeroEndereco(89);
        endereco2.setCidade("Londrina");
        endereco2.setEstado("Paraná");
        endereco2.setPais("Brasil");
        endereco2.setComplemento("casa");
        repositorioEndereco.inserir(endereco1);
        repositorioEndereco.inserir(endereco2);
        List<Endereco> enderecos = repositorioEndereco.buscarTodos();
        enderecos.forEach(System.out::println);
    }

    @Test
    public void testeBusscarPorId() {
        Endereco endereco1 = new Endereco();
        endereco1.setRua("rua teste");
        endereco1.setBairro("bairro teste");
        endereco1.setNumeroEndereco(88);
        endereco1.setCidade("Londrina");
        endereco1.setEstado("Paraná");
        endereco1.setPais("Brasil");
        endereco1.setComplemento("prédio");
        repositorioEndereco.inserir(endereco1);
        Endereco enderecoEncontrado = repositorioEndereco.buscarPorId(1l);
        System.out.println(enderecoEncontrado);
    }

    @Test
    public void testeDeletarEndereco() {
        Endereco endereco1 = new Endereco();
        endereco1.setRua("rua teste deletar");
        endereco1.setBairro("bairro teste");
        endereco1.setNumeroEndereco(88);
        endereco1.setCidade("Londrina");
        endereco1.setEstado("Paraná");
        endereco1.setPais("Brasil");
        endereco1.setComplemento("prédio");
        repositorioEndereco.inserir(endereco1);
        Endereco enderecoEncontrado = repositorioEndereco.buscarPorId(1l);
        System.out.println(enderecoEncontrado);
        repositorioEndereco.deletar(endereco1);
    }
}