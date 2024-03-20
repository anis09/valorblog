package tn.valorant.valorblog.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.valorant.valorblog.models.Billet;
import tn.valorant.valorblog.services.BilletService;

import java.sql.SQLException;
import java.util.List;

public class AfficherBilletController {
    private final BilletService ps = new BilletService();
    @FXML
    private TableColumn<Billet, Integer> idCol;
    @FXML
    private TableColumn<Billet, Integer> prixCol;
    @FXML
    private TableColumn<Billet, String> nomCol;
    @FXML
    private TableView<Billet> tableView;


    @FXML
    void initialize() {
        try {
            List<Billet> Billets = ps.recuperer();
            ObservableList<Billet> observableList = FXCollections.observableList(Billets);
            tableView.setItems(observableList);

            idCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prixCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            nomCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}
