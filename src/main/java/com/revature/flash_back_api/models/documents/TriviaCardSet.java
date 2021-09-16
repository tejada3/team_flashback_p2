package com.revature.flash_back_api.models.documents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Scope("prototype")
@Component
@Document(collection = "triviaCardSets")
public class TriviaCardSet {

    private String id;
    private String topic;
    private int cardCount;

    public TriviaCardSet(){super();}

    public TriviaCardSet(String topic){

        this.topic = topic;
        cardCount++;
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

    public void addCardCountByOne(){
        setCardCount(getCardCount() + 1);
    }

    public void deleteCardCountByOne(){
        setCardCount(getCardCount()-1);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TriviaCardSet that = (TriviaCardSet) o;
        return cardCount == that.cardCount && Objects.equals(id, that.id) && Objects.equals(topic, that.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topic, cardCount);
    }

    @Override
    public String toString() {
        return "TriviaCardSet{" +
                "id='" + id + '\'' +
                ", topic='" + topic + '\'' +
                ", cardCount=" + cardCount +
                '}';
    }
}
