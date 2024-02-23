package tn.valorant.valorblog.models;

public class Comment {
    private int commentId;
    private String commentContent;
    private int postId; // Reference to the post this comment belongs to
    private String commentCreatedBy;

    // Constructors
    public Comment() {
    }

    public Comment(int commentId, String commentContent, int postId, String commentCreatedBy) {
        this.commentId = commentId;
        this.commentContent = commentContent;
        this.postId = postId;
        this.commentCreatedBy = commentCreatedBy;
    }

    // Getters and setters
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getCommentCreatedBy() {
        return commentCreatedBy;
    }

    public void setCommentCreatedBy(String commentCreatedBy) {
        this.commentCreatedBy = commentCreatedBy;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentContent='" + commentContent + '\'' +
                ", postId=" + postId +
                ", commentCreatedBy='" + commentCreatedBy + '\'' +
                '}';
    }
}

