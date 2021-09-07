package com.revature.flash_back_api.models.documents;

import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Scope("prototype")
@Component
@Document(collection = "threads")
public class Threads {

    private String id;
    private String userId;
    private String subforumId;
    private String threadTitle;
    private String threadContent;

    public Threads(){super();}

    public Threads(String userId, String subforumId, String threadTitle, String threadContent) {
        this.userId = userId;
        this.subforumId = subforumId;
        this.threadTitle = threadTitle;
        this.threadContent = threadContent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSubforumId() {
        return subforumId;
    }

    public void setSubforumId(String subforumId) {
        this.subforumId = subforumId;
    }

    public String getThreadTitle() {
        return threadTitle;
    }

    public void setThreadTitle(String threadTitle) {
        this.threadTitle = threadTitle;
    }

    public String getThreadContent() {
        return threadContent;
    }

    public void setThreadContent(String threadContent) {
        this.threadContent = threadContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Threads threads = (Threads) o;
        return Objects.equals(id, threads.id) && Objects.equals(userId, threads.userId) && Objects.equals(subforumId, threads.subforumId) && Objects.equals(threadTitle, threads.threadTitle) && Objects.equals(threadContent, threads.threadContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, subforumId, threadTitle, threadContent);
    }

    @Override
    public String toString() {
        return "Threads{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", subforumId='" + subforumId + '\'' +
                ", threadTitle='" + threadTitle + '\'' +
                ", threadContent='" + threadContent + '\'' +
                '}';
    }
}
