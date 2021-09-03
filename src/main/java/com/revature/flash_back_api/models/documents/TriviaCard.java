package com.revature.flash_back_api.models.documents;

import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;


@Scope("prototype")
@Component
@Document(collection = "triviaCards")
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

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
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

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
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
        return Objects.equals(cardId, that.cardId) && Objects.equals(triviaCardSetId, that.triviaCardSetId) && Objects.equals(question, that.question) && Objects.equals(correctAnswer, that.correctAnswer) && Objects.equals(answers, that.answers) && Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, triviaCardSetId, question, correctAnswer, answers, points);
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
