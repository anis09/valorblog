package tn.valorant.valorblog.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import tn.valorant.valorblog.models.Post;
import tn.valorant.valorblog.services.PostService;

import java.sql.SQLException;

public class AddPostController {
    private final PostService postService = new PostService();

    @FXML
    private TextField postContentField;

    @FXML
    private TextField postTitleField;


    @FXML
    private TextField postImageField;



    @FXML
    void addPost() {
        String postContent = postContentField.getText();
        String postTitle = postTitleField.getText();
        String postImage = postImageField.getText();


        Post newPost = new Post();
        newPost.setPostContent(postContent);
        newPost.setPostTitle(postTitle);
        newPost.setPostImage(postImage);


        try {
            postService.addPost(newPost);
            afficherInfo("Post ajouté avec succès", "Le post a été ajouté avec succès.");
        } catch (SQLException e) {
            afficherErreur("Erreur lors de l'ajout du post", e.getMessage());
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
