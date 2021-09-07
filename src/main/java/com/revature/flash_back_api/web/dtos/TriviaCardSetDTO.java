package com.revature.flash_back_api.web.dtos;

import com.revature.flash_back_api.models.documents.TriviaCardSet;

import java.util.Objects;

public class TriviaCardSetDTO {

    private String id;
    private String topic;
    private int cardCount;

    public TriviaCardSetDTO(TriviaCardSet triviaCardSet){
        this.id = triviaCardSet.getId();
        this.topic = triviaCardSet.getTopic();
        this.cardCount = triviaCardSet.getCardCount();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getCardCount() {
        return cardCount;
    }

    public void setCardCount(int cardCount) {
        this.cardCount = cardCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TriviaCardSetDTO that = (TriviaCardSetDTO) o;
        return cardCount == that.cardCount && Objects.equals(id, that.id) && Objects.equals(topic, that.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topic, cardCount);
    }

    @Override
    public String toString() {
        return "TriviaCardSetDTO{" +
                "id='" + id + '\'' +
                ", topic='" + topic + '\'' +
                ", cardCount=" + cardCount +
                '}';
    }
}
