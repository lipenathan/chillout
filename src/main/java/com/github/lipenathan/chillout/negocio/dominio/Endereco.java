package com.github.lipenathan.chillout.negocio.dominio;


import com.github.lipenathan.chillout.negocio.exception.NegocioException;
import javax.persistence.*;

import java.io.Serializable;

@Entity
public class Endereco implements Serializable {
    @Id
    @Column(name = "ENDERECO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String rua;
    private String bairro;
    @Column(name = "NUMERO")
    private long numeroEndereco;
    private String cidade;
    private String estado;
    private String pais;
    private String complemento;

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", numeroEndereco=" + numeroEndereco +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                ", complemento='" + complemento + '\'' +
                '}';
    }

    public void validar() throws NegocioException {
        if (rua == null || rua.isEmpty()) throw NegocioException.RUA_ENDERECO_INVALIDA;
        if (bairro == null || bairro.isEmpty()) throw NegocioException.BAIRRO_ENDERECO_INVALIDO;
        if (numeroEndereco <= 0) throw NegocioException.NUMERO_ENDERECO_INVALIDO;
        if (cidade == null || cidade.isEmpty()) throw NegocioException.CIDADE_ENDERECO_INVALIDA;
        if (estado == null || estado.isEmpty()) throw NegocioException.ESTADO_ENDERECO_INVALIDO;
        if (pais == null || pais.isEmpty()) throw NegocioException.PAIS_ENDERECO_INVALIDO;
    }

    public long getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public long getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(long numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
