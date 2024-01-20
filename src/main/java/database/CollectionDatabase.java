package database;

import dao.entities.Etudiant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionDatabase implements DatabaseFacade {

    private List< Etudiant> etudiants = new ArrayList<>();
    @Override
    public Object getDatabase() {
        return etudiants;
    }

}
