package tn.valorant.valorblog.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import tn.valorant.valorblog.models.Post;
import tn.valorant.valorblog.services.PostService;


import java.sql.SQLException;

public class UpdatePostController {
    private final PostService postService = new PostService();

    private Post selectedPost;

    @FXML
    private TextField postContentField;

    @FXML
    private TextField postTitleField;

    @FXML
    private TextField postLikesField;

    @FXML
    private TextField postImageField;

    @FXML
    private TextField postCreatedByField;

    public void setSelectedPost(Post selectedPost) {
        this.selectedPost = selectedPost;
        populateFields();
    }

    private void populateFields() {
        postContentField.setText(selectedPost.getPostContent());
        postTitleField.setText(selectedPost.getPostTitle());
        postLikesField.setText(String.valueOf(selectedPost.getPostLikes()));
        postImageField.setText(selectedPost.getPostImage());
    }

    @FXML
    void updatePost() {
        if (selectedPost != null) {
            String postContent = postContentField.getText();
            String postTitle = postTitleField.getText();
            int postLikes = Integer.parseInt(postLikesField.getText());
            String postImage = postImageField.getText();
            String postCreatedBy = postCreatedByField.getText();

            selectedPost.setPostContent(postContent);
            selectedPost.setPostTitle(postTitle);
            selectedPost.setPostLikes(postLikes);
            selectedPost.setPostImage(postImage);

            try {
                postService.updatePost(selectedPost);
                afficherInfo("Post mis à jour avec succès", "Le post a été mis à jour avec succès.");
            } catch (SQLException e) {
                afficherErreur("Erreur lors de la mise à jour du post", e.getMessage());
            }
        }
    }

    private void afficherErreur(String titre, String contenu) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titre);
        alert.setContentText(contenu);
        alert.showAndWait();
    }

    private void afficherInfo(String titre, String contenu) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titre);
        alert.setContentText(contenu);
        alert.showAndWait();
    }
}

