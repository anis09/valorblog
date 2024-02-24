package tn.valorant.valorblog.models;

import javafx.scene.image.Image;

public class Post {
    private int postId;
    private String postContent;
    private String postTitle;
    private int postLikes;
    private boolean isArchived;
    private String imagePath; // Assuming image path is stored in the database
    private Image postImage; // For displaying in JavaFX UI

    // Constructors, getters, and setters
    public Post() {
    }

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

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Image getPostImage() {
        return postImage;
    }

    public void setPostImage(Image postImage) {
        this.postImage = postImage;
    }
}