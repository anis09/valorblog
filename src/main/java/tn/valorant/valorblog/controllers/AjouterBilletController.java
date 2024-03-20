package tn.valorant.valorblog.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import tn.valorant.valorblog.models.Billet;
import tn.valorant.valorblog.services.BilletService;

import java.io.IOException;
import java.sql.SQLException;

public class AjouterBilletController {
    private final BilletService ps = new BilletService();
    @FXML
    private TextField idTF;
    @FXML
    private TextField prixTF;
    @FXML
    private TextField nomTF;

    @FXML
    void ajouterBillet(ActionEvent event) {
        try {
            ps.ajouter(new Billet(Integer.parseInt(idTF.getText()), Integer.parseInt(prixTF.getText()), nomTF.getText()));
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void naviguezVersAffichage(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/AfficherBillets.fxml"));
            idTF.getScene().setRoot(root);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
