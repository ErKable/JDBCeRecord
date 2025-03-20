package org.example.Crud;

import org.example.ConnessioneDB.ConnessioneDB;
import org.example.Records.Attore;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttoreCrud {
    //con statement
    public static Attore getActorById(int actorId) throws SQLException {
        Connection c = ConnessioneDB.getConnection();
        Statement stm = c.createStatement();
        String query = "SELECT * FROM actor WHERE actor_id = " +actorId;
        ResultSet response = stm.executeQuery(query);
        String firstName = "";
        String lastName = "";
        while(response.next()){
            firstName = response.getString("first_name");
            lastName = response.getString("last_name");
        }
        return new Attore(actorId, firstName, lastName);
    }
    //con preparedstatemtn
    public static Attore getActorByIdPreparedStatement(int actorId) throws SQLException{
        Connection c = ConnessioneDB.getConnection();
        String query = "SELECT * FROM actor WHERE actor_id = ?";
        PreparedStatement pstm = c.prepareStatement(query);
        pstm.setInt(1, actorId);
        ResultSet response = pstm.executeQuery();
        String firstName = "";
        String lastName = "";
        while(response.next()){
            firstName = response.getString("first_name");
            lastName = response.getString("last_name");
        }
        return new Attore(actorId, firstName, lastName);
    }

    public static List<Attore> getActorsByNameS(String firstName) throws SQLException{
        List<Attore> la = new ArrayList<>();
        Connection c = ConnessioneDB.getConnection();
        Statement s = c.createStatement();
        String query = "SELECT * FROM actor WHERE first_name = \""+firstName+"\";";
        ResultSet response = s.executeQuery(query);
        while(response.next()){
            la.add(new Attore(response.getInt("actor_id"),
                            response.getString("first_name"),
                            response.getString("last_name")
                    )
            );
        }
        return la;
    }

    public static List<Attore> getActorsByNamePS(String firstName) throws SQLException{
        List<Attore> la = new ArrayList<>();
        Connection c = ConnessioneDB.getConnection();
        String query = "SELECT * FROM actor WHERE first_name = ?";
        PreparedStatement pst  = c.prepareStatement(query);
        pst.setString(1, firstName);
        ResultSet response = pst.executeQuery(query);
        while(response.next()){
            la.add(new Attore(response.getInt("actor_id"),
                    response.getString("first_name"),
                    response.getString("last_name")
                    )
            );
        }
        return la;
    }

}
