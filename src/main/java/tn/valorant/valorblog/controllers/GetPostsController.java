package tn.valorant.valorblog.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.valorant.valorblog.models.Post;
import tn.valorant.valorblog.services.PostService;

import java.sql.SQLException;
import java.util.List;

public class GetPostsController {
    private final PostService postService = new PostService();

    @FXML
    private TableColumn<Post, Integer> likesCol;
    @FXML
    private TableColumn<Post, String> titleCol;
    @FXML
    private TableColumn<Post, String> contentCol;
    @FXML
    private TableView<Post> tableView;

    @FXML
    void initialize() {
        try {
            List<Post> posts = postService.getAll();
            ObservableList<Post> observableList = FXCollections.observableList(posts);
            tableView.setItems(observableList);

            titleCol.setCellValueFactory(new PropertyValueFactory<>("postTitle"));
            contentCol.setCellValueFactory(new PropertyValueFactory<>("postContent"));
            likesCol.setCellValueFactory(new PropertyValueFactory<>("postLikes"));
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}