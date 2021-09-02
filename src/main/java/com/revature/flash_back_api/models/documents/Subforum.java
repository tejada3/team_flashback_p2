package com.revature.flash_back_api.models.documents;


import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
@Document(collection = "subforums")
public class Subforum {

    private String subforumId;
    private String subforumTitle;
    private int threadCount = 0;

    Subforum(String subforumTitle){
        this.subforumTitle = subforumTitle;
    }

    public String getSubforumId(){
        return subforumId;
    }

    public void setSubforumId(String subforumId){
        this.subforumId = subforumId;
    }

    //#TODO generate getters/setters equals/hashcode/toString


}
