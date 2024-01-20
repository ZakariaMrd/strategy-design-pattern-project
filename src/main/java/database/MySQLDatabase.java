package database;

import dao.entities.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLDatabase implements DatabaseFacade {

    private Connection connection;
    private String driver = "com.mysql.cj.jdbc.Driver"; // Utilisation du pilote MySQL actuel
    private String bridge = "jdbc:mysql:";
    private String host = "localhost:3333";
    private String source = "studentmanager";
    private String username = "root";
    private String password = "";
    private String url;

    @Override
    public Object getDatabase() {
        url = bridge + "//" + host + "/" + source + "?useSSL=false&serverTimezone=UTC";

        try {
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Connected");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la connexion à la base de données", e);
        }

        return connection;
    }
}
