package tn.valorant.valorblog.services;

import tn.valorant.valorblog.models.Evenement;
import tn.valorant.valorblog.utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EvenementService implements IService<Evenement> {

    private Connection connection;

    public EvenementService() {
        connection = MyDatabase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Evenement evenement) throws SQLException {
        String sql = "insert into evenement (nom, description,place,date) " +
                "values('" + evenement.getNom() + "','" + evenement.getDescription() + "'" +
                ",'" + evenement.getPlace() +"','"+ evenement.getDate()+ "')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    @Override
    public void modifier(Evenement evenement) throws SQLException {
        String sql = "update evenement set nom = ?, description = ?, place = ? , date = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, evenement.getNom());
        preparedStatement.setString(2, evenement.getDescription());
        preparedStatement.setString(3, evenement.getPlace());
        preparedStatement.setString(4, evenement.getDate());
        preparedStatement.setInt(5, evenement.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String sql = "delete from evenement where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Evenement> recuperer() throws SQLException {
        String sql = "select * from evenement";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Evenement> evenements = new ArrayList<>();
        while (rs.next()) {
            Evenement e = new Evenement();
            e.setId(rs.getInt("id"));
            e.setNom(rs.getString("nom"));
            e.setDescription(rs.getString("description"));
            e.setPlace(rs.getString("place"));
            e.setDate(rs.getString("date"));


            evenements.add(e);
        }
        return evenements;
    }
}