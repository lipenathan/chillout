package com.github.lipenathan.chillout.utils;

public class Validacao {
    public static void validarCampoObrigatorio(String campo, Object o) throws Exception {
        if (o == null) throw new Exception(campo + " está nulo");
        if (o instanceof String) {
            if (((String) o).isEmpty() ) throw new Exception(campo + " está vazio");
        }
        if (o instanceof Integer) {
            if (((Integer)o) <= 0) throw new Exception(campo + "precisa ser maior que 0");
        }
        if (o instanceof Double) {
            if (((Double)o) <= 0) throw new Exception(campo + "precisa ser maior que 0");
        }
        if (o instanceof Float) {
            if (((Float)o) <= 0) throw new Exception(campo + "precisa ser maior que 0");
        }
    }
}
