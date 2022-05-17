package com.github.lipenathan.chillout.negocio.dominio;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Endereco implements Serializable {
    @Id
    @Column(name = "id_endereco")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String rua;
    private String bairro;
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
