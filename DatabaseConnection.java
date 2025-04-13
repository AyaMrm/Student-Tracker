package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	// Informations de connexion
    private static final String URL = "jdbc:mysql://localhost:3306/POO"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "sarahougour2005"; // Laissez vide si vous n’avez pas défini de mot de passe

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Charger le driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir la connexion
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie !");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC non trouvé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erreur de connexion !");
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        // Test de connexion
        getConnection();
    }
}
