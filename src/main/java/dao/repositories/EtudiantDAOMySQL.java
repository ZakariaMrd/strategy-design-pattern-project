package dao.repositories;

import dao.EtudiantDAO;
import dao.entities.Etudiant;
import database.DatabaseFacade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAOMySQL implements EtudiantDAO {
    private DatabaseFacade databaseFacade;
    private Connection connection;

    public EtudiantDAOMySQL(DatabaseFacade databaseFacade) {
        this.databaseFacade = databaseFacade;
        this.connection = (Connection) databaseFacade.getDatabase();
    }

    @Override
    public void save(Etudiant etudiant) {
        String query = "INSERT INTO student (idStudent, name, email, password) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, etudiant.getId());
            statement.setString(2, etudiant.getName());
            statement.setString(3, etudiant.getEmail());
            statement.setString(4, etudiant.getPassword());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Étudiant inséré avec succès !");
            }
        } catch (SQLException e) {
            System.out.println("Erreur d'inscription: " + e.getMessage());
        }
    }

    @Override
    public void update(Etudiant etudiant) {
        // Implémentez la logique de mise à jour
    }

    @Override
    public void delete(Etudiant etudiant) {
        // Implémentez la logique de suppression
    }

    @Override
    public List<Etudiant> findAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        String query = "SELECT * FROM student";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                long id = resultSet.getLong("idStudent");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                Etudiant etudiant = Etudiant.builder()
                        .id(id)
                        .name(name)
                        .email(email)
                        .password(password)
                        .build();

                etudiants.add(etudiant);
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération de tous les étudiants : " + e.getMessage());
        }

        return etudiants;
    }

    @Override
    public Etudiant findById(Long id) {
        // Implémentez la logique de recherche par ID
        return null;
    }

    @Override
    public Etudiant findByEmail(String email) {
        // Implémentez la logique de recherche par email
        return null;
    }
}
