package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/POO";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        try {
            // Vérifier si la connexion est null ou fermée
            if (connection == null || connection.isClosed()) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    System.err.println("Driver JDBC introuvable : " + e.getMessage());
                    throw new SQLException("Driver JDBC introuvable", e);
                }
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connexion réussie à la base de données !");
            }
            return connection;
        } catch (SQLException e) {
            System.err.println("Erreur de connexion à la base de données : " + e.getMessage());
            e.printStackTrace(); // Ajouter la trace pour le débogage
            throw e; // Relancer l'exception au lieu de retourner null
        }
    }

    // Fermer la connexion
    public static void closeConnection() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                    System.out.println("Connexion fermée avec succès !");
                }
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            } finally {
                connection = null; // Toujours réinitialiser pour forcer une nouvelle connexion
            }
        }
    }

    // Méthode de test
    public static void main(String[] args) {
        try {
            Connection conn = ConnectionDB.getConnection();
            System.out.println("Connexion obtenue : " + conn + ", fermée ? " + conn.isClosed());
            ConnectionDB.closeConnection();
            // Tester une deuxième connexion
            conn = ConnectionDB.getConnection();
            System.out.println("Deuxième connexion obtenue : " + conn + ", fermée ? " + conn.isClosed());
            ConnectionDB.closeConnection();
        } catch (SQLException e) {
            System.err.println("Échec de la connexion : " + e.getMessage());
            e.printStackTrace();
        }
    }
}