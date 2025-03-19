package org.example.Records;

public record Attore(
        long actorId,
        String firstName,
        String lastName,
        int age
) {
    public void nomeComple(){
        System.out.println(firstName() + " " + lastName());
    }
}