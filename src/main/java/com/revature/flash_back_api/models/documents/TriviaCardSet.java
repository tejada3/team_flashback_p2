package com.revature.flash_back_api.models.documents;

import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

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

    // #TODO generate getters+setters, etc.

}
