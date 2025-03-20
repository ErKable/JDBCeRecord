package org.example;

import org.example.ConnessioneDB.ConnessioneDB;
import org.example.Crud.AttoreCrud;
import org.example.Records.Attore;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Attore a = AttoreCrud.getActorById(1);
            System.out.println(a);

            Attore a2 = AttoreCrud.getActorByIdPreparedStatement(34);
            System.out.println(a2);

            List<Attore> la = AttoreCrud.getActorsByNamePS("AUDREY");
            la.forEach(System.out::println);

            la = AttoreCrud.getActorsByNameS("ALBERT");
            la.forEach(System.out::println);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}