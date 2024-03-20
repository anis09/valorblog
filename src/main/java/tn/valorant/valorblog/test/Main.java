package tn.valorant.valorblog.test;


import tn.valorant.valorblog.models.Evenement;
import tn.valorant.valorblog.services.EvenementService;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {
        EvenementService ps = new EvenementService();

        try {
            ps.ajouter(new Evenement( "WeStart", "Fonjdhjdh", "dans mon coeur ","27/10/2000"));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        try {
            ps.modifier(new Evenement());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            System.out.println(ps.recuperer());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
