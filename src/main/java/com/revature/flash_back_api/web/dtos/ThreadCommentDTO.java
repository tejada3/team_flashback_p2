package com.revature.flash_back_api.web.dtos;

import com.revature.flash_back_api.models.documents.ThreadComment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class ThreadCommentDTO {


    private String id;
    private String threadId;
    private String userId;
    private String content;
    private LocalDate timestamp;


    public ThreadCommentDTO(ThreadComment comment){
        this.id = comment.getId();
        this.threadId = comment.getThreadId();
        this.userId = comment.getUserId();
        this.content = comment.getContent();
        this.timestamp = comment.getTimestamp();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThreadComment that = (ThreadComment) o;
        return Objects.equals(id, that.getId()) && Objects.equals(threadId, that.getThreadId()) && Objects.equals(userId, that.getUserId()) && Objects.equals(content, that.getContent()) && Objects.equals(timestamp, that.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, threadId, userId, content, timestamp);
    }

    @Override
    public String toString() {
        return "ThreadComment{" +
                "id='" + id + '\'' +
                ", threadId='" + threadId + '\'' +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

