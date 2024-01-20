package business;

import dao.EtudiantDAO;
import dao.entities.Etudiant;

import java.util.List;

public class EtudiantManager implements EtudiantManagerFacade{

    private final EtudiantDAO etudiantDAO;

    public EtudiantManager(EtudiantDAO etudiantDAO){
        this.etudiantDAO = etudiantDAO;
    }
    @Override
    public boolean checkEmail(String email) {
        return false;
    }

    @Override
    public void save(Etudiant etudiant) {
            etudiantDAO.save(etudiant);
    }

    @Override
    public void update(Etudiant etudiant) {
            etudiantDAO.update(etudiant);
    }

    @Override
    public void delete(Etudiant etudiant) {
        etudiantDAO.delete(etudiant);
    }

    @Override
    public List<Etudiant> getAll() {
        return etudiantDAO.findAll();
    }

    @Override
    public Etudiant getById(Long id) {
        return etudiantDAO.findById(id);
    }

    @Override
    public Etudiant getByEmail(String email) {
        return etudiantDAO.findByEmail(email);
    }
}
