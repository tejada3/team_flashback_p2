package com.revature.flash_back_api.models.documents;

import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Scope("prototype")
@Component
@Document(collection = "threads")
public class Threads {
    private String threadId;
    private String userId;
    private String subforumId;
    private String threadTitle;
    private String threadContent;

    public Threads(String userId, String subforumId, String threadTitle, String threadContent) {
        this.userId = userId;
        this.subforumId = subforumId;
        this.threadTitle = threadTitle;
        this.threadContent = threadContent;
    }

    //#TODO update getters and setters

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public String getUserID() {
        return userId;
    }

    public void setUserID(String userID) {
        this.userId = userID;
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
        if (!(o instanceof Threads)) return false;
        Threads thread = (Threads) o;
        return getThreadId().equals(thread.getThreadId()) && getUserID().equals(thread.getUserID()) && getThreadTitle().equals(thread.getThreadTitle()) && getThreadContent().equals(thread.getThreadContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getThreadId(), getUserID(), getThreadTitle(), getThreadContent());
    }


    @Override
    public String toString() {
        return "Thread{" +
                "threadId='" + threadId + '\'' +
                ", userID='" + userId + '\'' +
                ", threadTitle='" + threadTitle + '\'' +
                ", threadContent='" + threadContent + '\'' +
                '}';
    }
}
