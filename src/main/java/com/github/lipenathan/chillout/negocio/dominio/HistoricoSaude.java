package com.github.lipenathan.chillout.negocio.dominio;

import jakarta.persistence.*;

@Entity
public class HistoricoSaude {
    @Id
    @Column(name = "id_historico_saude")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean historicoDepressaoFamilia;
    private boolean surtoUltimoAno;
    private boolean historicoAnsiedade;
    private String descricaoHistorico;

    public long getId() {
        return id;
    }

    public boolean isHistoricoDepressaoFamilia() {
        return historicoDepressaoFamilia;
    }

    public void setHistoricoDepressaoFamilia(boolean historicoDepressaoFamilia) {
        this.historicoDepressaoFamilia = historicoDepressaoFamilia;
    }

    public boolean isSurtoUltimoAno() {
        return surtoUltimoAno;
    }

    public void setSurtoUltimoAno(boolean surtoUltimoAno) {
        this.surtoUltimoAno = surtoUltimoAno;
    }

    public boolean isHistoricoAnsiedade() {
        return historicoAnsiedade;
    }

    public void setHistoricoAnsiedade(boolean historicoAnsiedade) {
        this.historicoAnsiedade = historicoAnsiedade;
    }

    public String getDescricaoHistorico() {
        return descricaoHistorico;
    }

    public void setDescricaoHistorico(String descricaoHistorico) {
        this.descricaoHistorico = descricaoHistorico;
    }
}
