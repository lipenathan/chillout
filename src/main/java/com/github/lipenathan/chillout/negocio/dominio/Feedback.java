package com.github.lipenathan.chillout.negocio.dominio;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String feedback;
    private LocalDateTime dataFeedback;

    public long getId() {
        return id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public LocalDateTime getDataFeedback() {
        return dataFeedback;
    }

    public void setDataFeedback(LocalDateTime dataFeedback) {
        this.dataFeedback = dataFeedback;
    }
}
