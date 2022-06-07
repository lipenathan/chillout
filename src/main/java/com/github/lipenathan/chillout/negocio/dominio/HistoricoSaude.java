package com.github.lipenathan.chillout.negocio.dominio;

import javax.persistence.*;

@Entity(name = "HISTORICO_SAUDE")
public class HistoricoSaude {
    @Id
    @Column(name = "HISTORICO_SAUDE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "HISTORICO_DEPRESSAO_FAMILIAR")
    private boolean historicoDepressaoFamilia;
    @Column(name = "SURTO_ULTIMO_ANO")
    private boolean surtoUltimoAno;
    @Column(name = "HISTORICO_ANSIEDADE")
    private boolean historicoAnsiedade;
    @Column(name = "DESCRICAO_HISTORICO_SAUDE")
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
