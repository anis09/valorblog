package tn.valorant.valorblog.models;


public class Post {
    private int postId;
    private String postContent;
    private String postTitle;
    private int postLikes;
    private String postImage;
    private boolean isArchived;

    // Constructor
    public Post(int postId, String postContent, String postTitle, int postLikes, String postComments,
                String postImage, boolean isArchived) {
        this.postId = postId;
        this.postContent = postContent;
        this.postTitle = postTitle;
        this.postLikes = postLikes;
        this.postImage = postImage;

        this.isArchived = isArchived;
    }

    public Post() {

    }

    // Getters and setters
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public int getPostLikes() {
        return postLikes;
    }

    public void setPostLikes(int postLikes) {
        this.postLikes = postLikes;
    }


    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }



    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", postContent='" + postContent + '\'' +
                ", postTitle='" + postTitle + '\'' +
                ", postLikes='" + postLikes + '\'' +
                ", postImage='" + postImage + '\'' +
                ", isArchived=" + isArchived +
                '}';
    }

}
