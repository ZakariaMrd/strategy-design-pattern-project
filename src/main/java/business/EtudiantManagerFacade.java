package business;

import dao.entities.Etudiant;

import java.util.List;

public interface EtudiantManagerFacade {
    boolean checkEmail(String email);

    public void save(Etudiant etudiant);

    public void update(Etudiant etudiant);

    public void delete(Etudiant etudiant);

    public List<Etudiant> getAll();

    public Etudiant getById(Long id);

    public Etudiant getByEmail(String email);
}
