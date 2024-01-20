package dao.repositories;

import dao.EtudiantDAO;
import dao.entities.Etudiant;
import database.DatabaseFacade;

import java.util.ArrayList;
import java.util.List;

public class EtudiantDAOCollection implements EtudiantDAO {

    private DatabaseFacade databaseFacade;
    private List<Etudiant> etudiants;

    public EtudiantDAOCollection(DatabaseFacade databaseFacade) {
        this.databaseFacade = databaseFacade;
        etudiants = (List<Etudiant>) databaseFacade.getDatabase();
    }

    @Override
    public void save(Etudiant etudiant) {
        etudiants.add(etudiant);
    }

    @Override
    public void update(Etudiant etudiant) {

    }

    @Override
    public void delete(Etudiant etudiant) {

    }

    @Override
    public List<Etudiant> findAll() {

        return null ;
    }

    @Override
    public Etudiant findById(Long id) {
        return null;
    }

    @Override
    public Etudiant findByEmail(String email) {
        return null;
    }
}
