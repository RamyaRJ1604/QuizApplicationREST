package com.mylearning.quizapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "answer_info")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    int answerId;

    @Column(name = "answer_data")
    String answerData;

    @OneToOne(mappedBy = "answer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Question question;

    public Answer() {}

    public Answer(String answerData) {
        this.answerData = answerData;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerData() {
        return answerData;
    }

    public void setAnswerData(String answerData) {
        this.answerData = answerData;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", answerData='" + answerData + '\'' +
                '}';
    }
}
