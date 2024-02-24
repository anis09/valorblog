package tn.valorant.valorblog.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tn.valorant.valorblog.models.Post;
import tn.valorant.valorblog.services.PostService;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class AddPostController {
    private final PostService postService = new PostService();
    public javafx.scene.image.ImageView postImageField;

    @FXML
    private TextField postContentField;

    @FXML
    private TextField postTitleField;





    @FXML
    void addPost() {
        String postContent = postContentField.getText();
        String postTitle = postTitleField.getText();
        Image postImage = postImageField.getImage();


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
    @FXML
    void getAllPosts(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/valorant/valorblog/getPosts.fxml"));
        try {

            Parent root = loader.load();

            GetPostsController controller = loader.getController();

            postContentField.getScene().setRoot(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void attachImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            postImageField.setImage(image);
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
