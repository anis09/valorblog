package tn.valorant.valorblog.models;

import java.util.ArrayList;
import java.util.List;

public class Evenement {
    private int id;
    private String nom, description,place;

    private List<Billet> billets;

    private String date;

    public Evenement (int id, String nom, String description, String place , String date) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.place = place;
        this.date=date;
        this.billets = new ArrayList<>();
    }



    public Evenement(String nom, String description, String place , String date) {
        this.nom = nom;
        this.description = description;
        this.place = place;
        this.date=date;
        this.billets = new ArrayList<>();
    }

    public Evenement() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<Billet> getBillets() {
        return billets;
    }

    public void ajouterBillet(Billet billet) {
        billets.add(billet);
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "id=" + id +
                ", nom=" + nom +
                ", description='" + description + '\'' +
                ", place='" + place + '\'' +
                ",date='"+date+ '\''+
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}