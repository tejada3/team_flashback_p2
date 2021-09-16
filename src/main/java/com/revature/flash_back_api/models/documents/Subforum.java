package com.revature.flash_back_api.models.documents;


import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Scope("prototype")
@Component
@Document(collection = "subforums")
public class Subforum {

    private String id;
    private String subforumTitle;
    private int threadCount = 0;

    public Subforum(){super();}

    public Subforum(String subforumTitle){
        this.subforumTitle = subforumTitle;
    }

    public Subforum(String subforumTitle, int threadCount) {
        this.subforumTitle = subforumTitle;
        this.threadCount = threadCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubforumTitle() {
        return subforumTitle;
    }

    public void setSubforumTitle(String subforumTitle) {
        this.subforumTitle = subforumTitle;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subforum subforum = (Subforum) o;
        return threadCount == subforum.threadCount && Objects.equals(id, subforum.id) && Objects.equals(subforumTitle, subforum.subforumTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subforumTitle, threadCount);
    }

    @Override
    public String toString() {
        return "Subforum{" +
                "id='" + id + '\'' +
                ", subforumTitle='" + subforumTitle + '\'' +
                ", threadCount=" + threadCount +
                '}';
    }
}
