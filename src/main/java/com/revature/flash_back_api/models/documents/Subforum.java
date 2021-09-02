package com.revature.flash_back_api.models.documents;

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
