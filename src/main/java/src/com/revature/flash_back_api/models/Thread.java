package src.com.revature.flash_back_api.models;

import java.util.Objects;

public class Thread {
    private String threadId;
    private String userID;
    private String threadTitle;
    private String threadContent;

    public Thread(String threadId, String userID) {
        this.threadId = threadId;
        this.userID = userID;
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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
        if (!(o instanceof Thread)) return false;
        Thread thread = (Thread) o;
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
                ", userID='" + userID + '\'' +
                ", threadTitle='" + threadTitle + '\'' +
                ", threadContent='" + threadContent + '\'' +
                '}';
    }
}
