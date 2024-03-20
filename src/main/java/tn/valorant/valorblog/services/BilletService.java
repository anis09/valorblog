package tn.valorant.valorblog.services;

import tn.valorant.valorblog.models.Billet;
import tn.valorant.valorblog.utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BilletService implements IService<Billet> {

    private Connection connection;

    public BilletService() {
        connection = MyDatabase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Billet Billet) throws SQLException {
        String sql = "insert into Billet (prix, nom,place,date) " +
                "values('" + Billet.getprix() + "','" + Billet.getnom() + "'"  + ")";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    @Override
    public void modifier(Billet Billet) throws SQLException {
        String sql = "update Billet set prix = ?, nom = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, Billet.getprix());
        preparedStatement.setString(2, Billet.getnom());
        preparedStatement.setInt(3, Billet.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String sql = "delete from Billet where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Billet> recuperer() throws SQLException {
        String sql = "select * from Billet";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Billet> Billets = new ArrayList<>();
        while (rs.next()) {
            Billet e = new Billet();
            e.setId(rs.getInt("id"));
            e.setprix(rs.getInt("prix"));
            e.setnom(rs.getString("nom"));


            Billets.add(e);
        }
        return Billets;
    }
}
