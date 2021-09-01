package src.com.revature.flash_back_api.models;

public class ThreadComment {

    private String threadCommentId;
    private String threadId;
    private String userId;
    private String timestamp;
    private String content;

    public ThreadComment(){super();};

    public ThreadComment(String threadCommentId) {
        this.threadCommentId = threadCommentId;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
