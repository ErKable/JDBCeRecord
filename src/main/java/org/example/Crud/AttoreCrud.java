package org.example.Crud;

import org.example.ConnessioneDB.ConnessioneDB;
import org.example.Records.Attore;

import java.sql.*;

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

}
