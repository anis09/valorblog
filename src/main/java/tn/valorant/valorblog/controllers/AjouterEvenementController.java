package tn.valorant.valorblog.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import tn.valorant.valorblog.models.Evenement;
import tn.valorant.valorblog.services.EvenementService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class AjouterEvenementController {
    private final EvenementService ps = new EvenementService();
    @FXML
    private TextField descriptionTF;
    @FXML
    private TextField nomTF;
    @FXML
    private TextField placeTF;
    @FXML
    private TextField dateTF;

    @FXML
    void ajouterEvenement(ActionEvent event) {
        try {
            ps.ajouter(new Evenement(descriptionTF.getText(), nomTF.getText(), placeTF.getText(), dateTF.getText()));
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
            Parent root = FXMLLoader.load(getClass().getResource("/AfficherEvenements.fxml"));
            placeTF.getScene().setRoot(root);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}