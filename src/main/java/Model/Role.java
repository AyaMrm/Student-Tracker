package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum Role {
    ADMIN,
    PROF,
    ETUDIANT;

    public static class ConnectionDB {
        private static final String URL = "jdbc:mysql://localhost:3306/student";
        private static final String USER = "aya";
        private static final String PASSWORD = "password";
        private static Connection connection = null;

        // Méthode pour obtenir la connexion
        public static Connection getConnection() {
            if (connection == null) {
                try {
                    // Charger le driver JDBC
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // Établir la connexion
                    connection = DriverManager.getConnection(URL, USER, PASSWORD);
                    System.out.println("Connexion réussie à la base de données !");
                } catch (ClassNotFoundException e) {
                    System.err.println("Driver JDBC introuvable : " + e.getMessage());
                } catch (SQLException e) {
                    System.err.println("Erreur de connexion à la base de données : " + e.getMessage());
                }
            }
            return connection;
        }

        // Méthode pour fermer la connexion proprement
        public static void closeConnection() {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connexion fermée avec succès !");
                } catch (SQLException e) {
                    System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
                }
            }
        }

        public static void main(String[] args) {
            Connection conn = ConnectionDB.getConnection();
            ConnectionDB.closeConnection();
        }


    }
}
