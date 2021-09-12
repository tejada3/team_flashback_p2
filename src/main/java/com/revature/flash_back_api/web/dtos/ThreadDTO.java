package com.revature.flash_back_api.web.dtos;

import com.revature.flash_back_api.models.documents.Threads;

import java.util.Objects;

public class ThreadDTO {

    private String id;
    private String userId;
    private String subforumId;
    private String threadTitle;
    private String threadContent;

    public ThreadDTO(Threads thread) {
        this.userId = thread.getUserId();
        this.subforumId = thread.getSubforumId();
        this.threadTitle = thread.getThreadTitle();
        this.threadContent = thread.getThreadContent();
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
        ThreadDTO threadDTO = (ThreadDTO) o;
        return Objects.equals(id, threadDTO.id) && Objects.equals(userId, threadDTO.userId) && Objects.equals(subforumId, threadDTO.subforumId) && Objects.equals(threadTitle, threadDTO.threadTitle) && Objects.equals(threadContent, threadDTO.threadContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, subforumId, threadTitle, threadContent);
    }

    @Override
    public String toString() {
        return "ThreadDTO{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", subforumId='" + subforumId + '\'' +
                ", threadTitle='" + threadTitle + '\'' +
                ", threadContent='" + threadContent + '\'' +
                '}';
    }
}
