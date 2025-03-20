package org.example;

import org.example.ConnessioneDB.ConnessioneDB;
import org.example.Crud.AttoreCrud;
import org.example.Records.Attore;

import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Attore a = AttoreCrud.getActorById(1);
            System.out.println(a);

            Attore a2 = AttoreCrud.getActorByIdPreparedStatement(34);
            System.out.println(a2);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}