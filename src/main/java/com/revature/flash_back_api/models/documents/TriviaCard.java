package com.revature.flash_back_api.models.documents;

import java.util.List;
import java.util.Objects;

public class TriviaCard {
    private String cardId;
    private String userid;
    private String question;
    private String correctAnswer;
    private String points;
    private List<String> answers;

    public TriviaCard(){ super();};

    public TriviaCard(String cardId, String userid, String question, String correctAnswer, String points, List<String> answers) {
        this.cardId = cardId;
        this.userid = userid;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.points = points;
        this.answers = answers;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TriviaCard)) return false;
        TriviaCard that = (TriviaCard) o;
        return getCardId().equals(that.getCardId()) && getUserid().equals(that.getUserid()) && getQuestion().equals(that.getQuestion()) && getCorrectAnswer().equals(that.getCorrectAnswer()) && Objects.equals(getPoints(), that.getPoints()) && getAnswers().equals(that.getAnswers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardId(), getUserid(), getQuestion(), getCorrectAnswer(), getPoints(), getAnswers());
    }

    @Override
    public String toString() {
        return "TriviaCard{" +
                "cardId='" + cardId + '\'' +
                ", userid='" + userid + '\'' +
                ", question='" + question + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", points='" + points + '\'' +
                ", answers=" + answers +
                '}';
    }
}
