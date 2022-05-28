package com.github.lipenathan.chillout.negocio.dominio;


import com.github.lipenathan.chillout.negocio.exception.NegocioException;
import javax.persistence.*;

@Entity
public class Empresa {
    @Id
    @Column(name = "empresa_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cnpj;
    @Column(name = "qtd_funcionarios")
    private long numeroFuncionarios;
    private String ramo;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ENDERECO_EMPRESA_ID", referencedColumnName = "ENDERECO_ID")
    private Endereco enderecoEmpresa;

    public void validar() throws NegocioException {
        if (enderecoEmpresa == null) throw NegocioException.ENDERECO_INVALIDO;
        enderecoEmpresa.validar();
        if (nome == null || nome.isEmpty()) throw NegocioException.NOME_EMPRESA_INVALIDO;
        if (cnpj == null || cnpj.isEmpty()) throw NegocioException.CNPJ_INVALIDO;
        if (numeroFuncionarios <= 0) throw NegocioException.NMR_FUNCIONARIOS_EMPRESA_INVALIDO;
        if (ramo == null || ramo.isEmpty()) throw NegocioException.RAMO_EMPRESA_INVALIDO;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public long getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(long numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public Endereco getEnderecoEmpresa() {
        return enderecoEmpresa;
    }

    public void setEnderecoEmpresa(Endereco enderecoEmpresa) {
        this.enderecoEmpresa = enderecoEmpresa;
    }
}
