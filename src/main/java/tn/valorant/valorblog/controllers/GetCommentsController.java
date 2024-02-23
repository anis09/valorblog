package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.valorant.valorblog.models.Comment;
import tn.valorant.valorblog.services.CommentService;


import java.sql.SQLException;
import java.util.List;

public class GetCommentsController {
    private final CommentService commentService = new CommentService();

    @FXML
    private TableColumn<Comment, Integer> commentIdCol;
    @FXML
    private TableColumn<Comment, String> commentContentCol;
    @FXML
    private TableColumn<Comment, Integer> postIdCol;
    @FXML
    private TableColumn<Comment, String> createdByCol;
    @FXML
    private TableView<Comment> commentTableView;

    @FXML
    void initialize() {
        commentIdCol.setCellValueFactory(new PropertyValueFactory<>("commentId"));
        commentContentCol.setCellValueFactory(new PropertyValueFactory<>("commentContent"));
        postIdCol.setCellValueFactory(new PropertyValueFactory<>("postId"));
        createdByCol.setCellValueFactory(new PropertyValueFactory<>("commentCreatedBy"));

        getComments();
    }

    private void getComments() {
        try {
            List<Comment> comments = commentService.getAllComments();
            ObservableList<Comment> observableList = FXCollections.observableList(comments);
            commentTableView.setItems(observableList);
        } catch (SQLException e) {
            afficherAlerteErreur("Erreur lors de la récupération des commentaires", e.getMessage());
        }
    }

    private void afficherAlerteErreur(String titre, String contenu) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titre);
        alert.setContentText(contenu);
        alert.showAndWait();
    }


}
