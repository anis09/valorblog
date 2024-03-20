package tn.valorant.valorblog.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.valorant.valorblog.models.Evenement;
import tn.valorant.valorblog.services.EvenementService;

import java.sql.SQLException;
import java.util.List;

public class AfficherEvenementController {
    private final EvenementService ps = new EvenementService();
    @FXML
    private TableColumn<Evenement, Integer> idCol;
    @FXML
    private TableColumn<Evenement, String> nomCol;
    @FXML
    private TableColumn<Evenement, String> descriptionCol;
    @FXML
    private TableColumn<Evenement, String> placeCol;
    @FXML
    private TableColumn<Evenement, String> dateCol;

    @FXML
    private TableView<Evenement> tableView;

    @FXML
    void initialize() {
        try {
            List<Evenement> evenements = ps.recuperer();
            ObservableList<Evenement> observableList = FXCollections.observableList(evenements);
            tableView.setItems(observableList);

            idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
            descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
            placeCol.setCellValueFactory(new PropertyValueFactory<>("place"));
            dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}
