package tn.valorant.valorblog.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import tn.valorant.valorblog.models.Post;
import tn.valorant.valorblog.services.PostService;


import java.sql.SQLException;

public class DeletePostController {
    private final PostService postService = new PostService();

    private Post selectedPost;

    public void setSelectedPost(Post selectedPost) {
        this.selectedPost = selectedPost;
    }

    @FXML
    void deletePost() {
        if (selectedPost != null) {
            try {
                postService.deletePost(selectedPost.getPostId());
                afficherInfo("Post supprimé avec succès", "Le post a été supprimé avec succès.");
            } catch (SQLException e) {
                afficherErreur("Erreur lors de la suppression du post", e.getMessage());
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
