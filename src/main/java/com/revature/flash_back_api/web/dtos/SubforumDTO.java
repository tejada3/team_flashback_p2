package com.revature.flash_back_api.web.dtos;

import com.revature.flash_back_api.models.documents.Subforum;

import java.util.Objects;

public class SubforumDTO {

    private String id;
    private String subforumTitle;
    private int threadCount = 0;

    public SubforumDTO(Subforum subforum) {
        this.id = subforum.getId();
        this.subforumTitle = subforum.getSubforumTitle();
        this.threadCount = subforum.getThreadCount();
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
        SubforumDTO that = (SubforumDTO) o;
        return threadCount == that.threadCount && Objects.equals(id, that.id) && Objects.equals(subforumTitle, that.subforumTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subforumTitle, threadCount);
    }

    @Override
    public String toString() {
        return "SubforumDTO{" +
                "id='" + id + '\'' +
                ", subforumTitle='" + subforumTitle + '\'' +
                ", threadCount=" + threadCount +
                '}';
    }
}
