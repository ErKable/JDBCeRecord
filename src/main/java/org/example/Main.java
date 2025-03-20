package org.example;

import org.example.ConnessioneDB.ConnessioneDB;
import org.example.Crud.AttoreCrud;
import org.example.Records.Attore;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Benvenuto, che operazione vuoi eseguire?\n" +
                "[1] - Cerca attore tramite id \n" +
                "[2] - Cerca attori tramite nome");
        Scanner s = new Scanner(System.in);
        int scelta = s.nextInt();
        //serve il nextLine perche nextInt legge solo il numero, ma poi rimane il \n da leggere e quando vado
        //nel case 2 lo scanner lo legge automaticamente non facendomi inserire il nome
        s.nextLine();
        try {
            switch(scelta){
                case 1 -> {
                    System.out.println("Inserisci l'id dell'attore da ricercare");
                    int actorId = s.nextInt();
                    Attore a = AttoreCrud.getActorById(actorId);
                    System.out.println(a);
                }
                case 2 -> {
                    System.out.println("Inserisci il nome degli attori da ricercare");
                    String actorsName = s.nextLine();
                    List<Attore> la = AttoreCrud.getActorsByNamePS(actorsName.toUpperCase());
                    la.forEach(System.out::println);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}