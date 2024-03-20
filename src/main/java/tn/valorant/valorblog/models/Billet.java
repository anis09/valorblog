package tn.valorant.valorblog.models;

public class Billet { 
    private int id,prix;
    private String nom;



    public Billet (int id, int prix, String nom) {
        this.id = id;
        this.prix = prix;
        this.nom = nom;

    }



    public Billet(int prix, String nom) {
        this.prix = prix;
        this.nom = nom;

    }

    public Billet() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getprix() {
        return prix;
    }

    public void setprix(int prix) {
        this.prix = prix;
    }

    public String getnom() {
        return nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }



    @Override
    public String toString() {
        return "Billet{" +
                "id=" + id +
                ", prix=" + prix +
                ", nom='" + nom  +
                '}';
    }


}
