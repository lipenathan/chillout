package com.github.lipenathan.chillout.negocio.exception;

public class NegocioException extends Exception {

    //Mensagens padrões para exceptions de negócio
    public static final String NOME_INVALIDO_MSG = "Nome e Sobrenome precisam ser preenchido corretamente";
    private static final String DATA_NASCIMENTO_INVALIDA_MSG = "Data de nascimento precisa ser preenchida";
    private static final String DATA_CONTRATACAO_INVALIDA_MSG = "Data da contratação precisa ser preenchida";
    private static final String DOCUMENTO_INVALIDO_MSG = "Documento preenchido inválido";
    private static final String SENHA_INVALIDA_MSG = "Senha precisa ter no mínimo 6 caracteres";
    private static final String SENHA_INVALIDA_CARACTERES_MSG = "Senha precisa ter letras e números";
    private static final String CARGO_INVALIDO_MSG = "Cargo precisa ser preenchido";
    private static final String SETOR_INVALIDO_MSG = "Setor precisa ser preenchido";
    private static final String ENDERECO_INVALIDO_MSG = "Endereço precisa ser preenchido";

    //Exeptions Estáticas
    public static NegocioException NOME_INVALIDO = new NegocioException(NOME_INVALIDO_MSG);
    public static NegocioException DATA_NASCIMENTO_INVALIDA = new NegocioException(DATA_NASCIMENTO_INVALIDA_MSG);
    public static NegocioException DOCUMENTO_INVALIDO = new NegocioException(DOCUMENTO_INVALIDO_MSG);
    public static NegocioException SENHA_INVALIDA = new NegocioException(SENHA_INVALIDA_MSG);
    public static NegocioException SENHA_INVALIDA_CARACTERES = new NegocioException(SENHA_INVALIDA_CARACTERES_MSG);
    public static NegocioException DATA_CONTRATACAO_INVALIDA = new NegocioException(DATA_CONTRATACAO_INVALIDA_MSG);
    public static NegocioException CARGO_INVALIDO = new NegocioException(CARGO_INVALIDO_MSG);
    public static NegocioException SETOR_INVALIDO = new NegocioException(SETOR_INVALIDO_MSG);
    public static NegocioException ENDERECO_INVALIDO = new NegocioException(ENDERECO_INVALIDO_MSG);

    private NegocioException(String msg) {
        super(msg);
    }
}
