package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/studentracker";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";
    private static Connection connection = null;


    public static Connection getConnection() {
        if (connection == null) {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");

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

    // terminer notre connexion a la DB
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

    // TESTE TESTE TESTE !!!

    public static void main(String[] args) {
        Connection conn = ConnectionDB.getConnection();
        ConnectionDB.closeConnection();
    }
}
