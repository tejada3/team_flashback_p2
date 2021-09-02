package com.revature.flash_back_api.models.documents;

import java.util.List;
import java.util.Objects;

public class TriviaCard {
    private String cardId;
    private String triviaCardSetId;
    private String question;
    private String correctAnswer;
    private List<String> answers;
    private String points;

    public TriviaCard(){ super();};

    public TriviaCard(String triviaCardSetId, String question, String correctAnswer, String points, List<String> answers) {
        this.triviaCardSetId = triviaCardSetId;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.points = points;
        this.answers = answers;
    }

    // #TODO update getters/setters / equals, hashCode and toString

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
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
        return getCardId().equals(that.getCardId()) && triviaCardSetId.equals(that.triviaCardSetId) && Objects.equals(getQuestion(), that.getQuestion()) && Objects.equals(getCorrectAnswer(), that.getCorrectAnswer()) && Objects.equals(getAnswers(), that.getAnswers()) && Objects.equals(getPoints(), that.getPoints());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardId(), triviaCardSetId, getQuestion(), getCorrectAnswer(), getAnswers(), getPoints());
    }


    @Override
    public String toString() {
        return "TriviaCard{" +
                "cardId='" + cardId + '\'' +
                ", triviaCardSetId='" + triviaCardSetId + '\'' +
                ", question='" + question + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", answers=" + answers +
                ", points='" + points + '\'' +
                '}';
    }
}
