package com.github.lipenathan.chillout.negocio.dominio;

import com.github.lipenathan.chillout.negocio.exception.NegocioException;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Test
    public void testeData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date data = sdf.parse("20-12-1985");
            System.out.println(data);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testeStrigBuilder() {
        StringBuilder s = new StringBuilder();
        s.append("olá").append(" Fulano").append(", tudo bem?");
        System.out.println(s);
    }
}