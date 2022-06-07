package com.github.lipenathan.chillout.servicos.repositorio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class TesteValidacao {

    public void validar(Object o) throws Exception {
        if (o == null) throw new Exception("Objeto nulo");
        if (o instanceof String) {
            System.out.println("##### " + o);
            if (((String) o).isEmpty() ) throw new Exception("texto vazio");
        }
        if (o instanceof Integer) {
            if (((Integer)o) <= 0) throw new Exception("Numero precisa ser maior que 0");
        }
        if (o instanceof Double) {
            if (((Double)o) <= 0) throw new Exception("Numero precisa ser maior que 0");
        }
        if (o instanceof Float) {
            if (((Float)o) <= 0) throw new Exception("Numero precisa ser maior que 0");
        }
    }

    @Test
    public void testeValidacao() {
        String a = "";
        try {
            validar(a);
            fail("Não pode validar numero nulo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
