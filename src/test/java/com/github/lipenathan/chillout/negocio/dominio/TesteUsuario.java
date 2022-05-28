package com.github.lipenathan.chillout.negocio.dominio;

import com.github.lipenathan.chillout.negocio.exception.NegocioException;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class TesteUsuario {

    @Test
    public void testeValidarNome() {
        Psicologo p = new Psicologo();
        p.setNome("Dra. Alice");
        p.setCrm("CRM12345/PR");
        p.setCpf("09692767965");
        p.setDataNascimento(new Date(1996, 12, 28));
        p.setSenha("123abc");
        Endereco endereco = new Endereco();
        endereco.setRua("Rua do psicologo");
        endereco.setNumeroEndereco(120);
        endereco.setBairro("Bairro exemplo");
        endereco.setComplemento("fundos");
        endereco.setEstado("PR");
        endereco.setPais("Brasil");
        p.setEnderecoUsuario(endereco);
        try {
            p.validar();
        } catch (NegocioException e) {
            System.out.printf(e.getMessage());
        }
    }
}