package org.example.Crud;

import org.example.ConnessioneDB.ConnessioneDB;
import org.example.Records.Attore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
