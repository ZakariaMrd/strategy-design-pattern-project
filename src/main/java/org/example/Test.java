package org.example;

import business.EtudiantManager;
import business.EtudiantManagerFacade;
import dao.EtudiantDAO;
import dao.entities.Etudiant;
import dao.repositories.EtudiantDAOCollection;
import dao.repositories.EtudiantDAOMySQL;
import database.CollectionDatabase;
import database.MySQLDatabase;


public class Test {
    public static void main(String[] args) {

//        CollectionDatabase collectionDatabase = new CollectionDatabase();
//        EtudiantDAO etudiantDAO = new EtudiantDAOCollection(collectionDatabase);
//        EtudiantManagerFacade etudiantManager = new EtudiantManager(etudiantDAO);
        MySQLDatabase mySQLDatabase = new MySQLDatabase();
        EtudiantDAO etudiantDAO = new EtudiantDAOMySQL(mySQLDatabase);
        EtudiantManagerFacade etudiantManager = new EtudiantManager(etudiantDAO);

        testeServices(etudiantManager);

    }

    private static void testeServices(EtudiantManagerFacade etudiantManager) {
        Etudiant nouvelEtudiant = Etudiant.builder()
                .id(5L)
                .name("Nouvel Etudiant5")
                .email("nouveau@example.com")
                .password("12")
                .build();

        Etudiant nouvelEtudiant2 = Etudiant.builder()
                .id(9L)
                .name("Nouvel Etudiant9")
                .email("nouveau.etudiant9@example.com")
                .password("1239999")
                .build();

        etudiantManager.save(nouvelEtudiant);
        etudiantManager.save(nouvelEtudiant2);


        System.out.println("All students: " + etudiantManager.getAll());
    }
}