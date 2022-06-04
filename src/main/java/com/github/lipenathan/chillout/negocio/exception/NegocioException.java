package com.github.lipenathan.chillout.negocio.exception;

public class NegocioException extends Exception {

    //Mensagens padrões para exceptions de negócio
    public static final String NOME_INVALIDO_MSG = "Nome e Sobrenome precisam ser preenchido corretamente";
    private static final String PAPEL_INVALIDO_MSG = "O papel do usuário precisa ser preenchido";
    private static final String DATA_NASCIMENTO_INVALIDA_MSG = "Data de nascimento precisa ser preenchida";
    private static final String DATA_CONTRATACAO_INVALIDA_MSG = "Data da contratação precisa ser preenchida";
    private static final String DOCUMENTO_INVALIDO_MSG = "Documento preenchido inválido";
    private static final String SENHA_INVALIDA_MSG = "Senha precisa ter no mínimo 6 caracteres";
    private static final String SENHA_INVALIDA_CARACTERES_MSG = "Senha precisa ter letras e números";
    private static final String CARGO_INVALIDO_MSG = "Cargo precisa ser preenchido";
    private static final String SETOR_INVALIDO_MSG = "Setor precisa ser preenchido";
    private static final String ENDERECO_INVALIDO_MSG = "Endereço precisa ser preenchido";
    private static final String RUA_ENDERECO_INVALIDA_MSG = "Rua inválida";
    private static final String BAIRRO_ENDERECO_INVALIDO_MSG = "Bairro inválido";
    private static final String NUMERO_ENDERECO_INVALIDO_MSG = "Número de Endereço inválido";
    private static final String CIDADE_ENDERECO_INVALIDA_MSG = "Cidade do endereço inválida";
    private static final String ESTADO_ENDERECO_INVALIDO_MSG = "Estado do Endereço inválido";
    private static final String PAIS_ENDERECO_INVALIDO_MSG = "País do Endereço inválido";
    private static final String NOME_EMPRESA_INVALIDO_MSG = "Nome da Empresa inválido";
    private static final String CNPJ_INVALIDO_MSG = "CNPJ inválido";
    private static final String NMR_FUNCIONARIOS_EMPRESA_INVALIDO_MSG = "Número de Colaboradores inválido";
    private static final String RAMO_EMPRESA_INVALIDO_MSG = "País do Endereço inválidoo";

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
    public static NegocioException RUA_ENDERECO_INVALIDA = new NegocioException(RUA_ENDERECO_INVALIDA_MSG);
    public static NegocioException BAIRRO_ENDERECO_INVALIDO = new NegocioException(BAIRRO_ENDERECO_INVALIDO_MSG);
    public static NegocioException NUMERO_ENDERECO_INVALIDO = new NegocioException(NUMERO_ENDERECO_INVALIDO_MSG);
    public static NegocioException CIDADE_ENDERECO_INVALIDA = new NegocioException(CIDADE_ENDERECO_INVALIDA_MSG);
    public static NegocioException ESTADO_ENDERECO_INVALIDO = new NegocioException(ESTADO_ENDERECO_INVALIDO_MSG);
    public static NegocioException PAIS_ENDERECO_INVALIDO = new NegocioException(PAIS_ENDERECO_INVALIDO_MSG);
    public static NegocioException NOME_EMPRESA_INVALIDO = new NegocioException(NOME_EMPRESA_INVALIDO_MSG);
    public static NegocioException CNPJ_INVALIDO = new NegocioException(CNPJ_INVALIDO_MSG);
    public static NegocioException NMR_FUNCIONARIOS_EMPRESA_INVALIDO = new NegocioException(NMR_FUNCIONARIOS_EMPRESA_INVALIDO_MSG);
    public static NegocioException RAMO_EMPRESA_INVALIDO = new NegocioException(RAMO_EMPRESA_INVALIDO_MSG);
    public static final NegocioException PAPEL_INVALIDO = new NegocioException(PAPEL_INVALIDO_MSG);

    public NegocioException(String msg) {
        super(msg);
    }
}
