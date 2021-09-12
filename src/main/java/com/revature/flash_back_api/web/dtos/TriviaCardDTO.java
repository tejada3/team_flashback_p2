package com.revature.flash_back_api.web.dtos;

import com.revature.flash_back_api.models.documents.TriviaCard;
import java.util.Objects;

public class TriviaCardDTO {


    private String id;
    private String triviaCardSetId;
    private String question;
    private String correctAnswer;
    private String[] answers;
    private String points;


    public TriviaCardDTO(TriviaCard card){
        this.id = card.getId();
        this.triviaCardSetId = card.getTriviaCardSetId();
        this.question = card.getQuestion();
        this.correctAnswer = card.getCorrectAnswer();
        this.answers = card.getAnswers().toArray(new String[0]);
        this.points = card.getPoints();
    }

    public TriviaCardDTO() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTriviaCardSetId() {
        return triviaCardSetId;
    }

    public void setTriviaCardSetId(String triviaCardSetId) {
        this.triviaCardSetId = triviaCardSetId;
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

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TriviaCard that = (TriviaCard) o;
        return Objects.equals(id, that.getId()) && Objects.equals(triviaCardSetId, that.getTriviaCardSetId()) && Objects.equals(question, that.getQuestion()) && Objects.equals(correctAnswer, that.getCorrectAnswer()) && Objects.equals(answers, that.getAnswers()) && Objects.equals(points, that.getPoints());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, triviaCardSetId, question, correctAnswer, answers, points);
    }

    @Override
    public String toString() {
        return "TriviaCard{" +
                "id='" + id + '\'' +
                ", triviaCardSetId='" + triviaCardSetId + '\'' +
                ", question='" + question + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", answers=" + answers +
                ", points='" + points + '\'' +
                '}';
    }
}

