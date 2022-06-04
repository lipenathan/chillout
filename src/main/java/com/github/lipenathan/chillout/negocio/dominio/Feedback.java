package com.github.lipenathan.chillout.negocio.dominio;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FEEDBACK_ID")
    private long id;
    @Column(name = "TEXTO_FEEDBACK")
    private String feedback;
    @Column(name = "DATA_FEEDBACK")
    private Date dataFeedback;

    public long getId() {
        return id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getDataFeedback() {
        return dataFeedback;
    }

    public void setDataFeedback(Date dataFeedback) {
        this.dataFeedback = dataFeedback;
    }
}
