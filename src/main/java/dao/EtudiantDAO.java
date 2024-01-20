package dao;

import dao.entities.Etudiant;

import java.util.List;

public interface EtudiantDAO {
    public void save(Etudiant etudiant);

    public void update(Etudiant etudiant);

    public void delete(Etudiant etudiant);

    public List<Etudiant> findAll();

    public Etudiant findById(Long id);

    public Etudiant findByEmail(String email);
}
