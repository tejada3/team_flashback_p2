package com.revature.flash_back_api.models.documents;

import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Scope("prototype")
@Component
@Document(collection = "triviaCardSets")
public class TriviaCardSet {

    private String triviaCardSetId;
    private String topic;
    private int cardCount = 0;

    public TriviaCardSet(String topic){
        this.topic = topic;
    }

    public String getTriviaCardSetId() {
        return triviaCardSetId;
    }

    public void setTriviaCardSetId(String triviaCardSetId) {
        this.triviaCardSetId = triviaCardSetId;
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
        TriviaCardSet that = (TriviaCardSet) o;
        return cardCount == that.cardCount && Objects.equals(triviaCardSetId, that.triviaCardSetId) && Objects.equals(topic, that.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(triviaCardSetId, topic, cardCount);
    }

    @Override
    public String toString() {
        return "TriviaCardSet{" +
                "triviaCardSetId='" + triviaCardSetId + '\'' +
                ", topic='" + topic + '\'' +
                ", cardCount=" + cardCount +
                '}';
    }
}
