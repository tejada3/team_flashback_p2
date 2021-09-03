package com.revature.flash_back_api.models.documents;

import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Scope("prototype")
@Component
@Document(collection = "threadComments")
public class ThreadComment {

    private String threadCommentId;
    private String threadId;
    private String userId;
    private String content;
    private LocalDateTime timestamp;

    // #TODO generate constructor

    public ThreadComment(String threadId, String userId, String content, LocalDateTime timestamp) {
        this.threadId = threadId;
        this.userId = userId;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getThreadCommentId() {
        return threadCommentId;
    }

    public void setThreadCommentId(String threadCommentId) {
        this.threadCommentId = threadCommentId;
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThreadComment that = (ThreadComment) o;
        return Objects.equals(threadCommentId, that.threadCommentId) && Objects.equals(threadId, that.threadId) && Objects.equals(userId, that.userId) && Objects.equals(content, that.content) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(threadCommentId, threadId, userId, content, timestamp);
    }

    @Override
    public String toString() {
        return "ThreadComment{" +
                "threadCommentId='" + threadCommentId + '\'' +
                ", threadId='" + threadId + '\'' +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
