package com.github.lipenathan.chillout.dominio;

import jakarta.persistence.*;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.PERSIST;

@Entity
public class Funcionario extends Usuario {

    private LocalDate dataContratacao;
    private String cargo;
    private String setor;
    @OneToOne(cascade = PERSIST)
    @JoinColumn(name = "id_historico_saude")
    private HistoricoSaude historicoSaude;

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public HistoricoSaude getHistoricoSaude() {
        return historicoSaude;
    }

    public void setHistoricoSaude(HistoricoSaude historicoSaude) {
        this.historicoSaude = historicoSaude;
    }
}