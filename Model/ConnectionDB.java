package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	 private static final String URL = "jdbc:mysql://localhost:3306/POO"; // Remplacez testdb par votre BD
	    private static final String USER = "root"; // Par défaut dans XAMPP
	    private static final String PASSWORD = "sql28112021"; // Laissez vide si vous n’avez pas défini de mot de passe

	    public static  Connection getConnection() {
	        Connection conn = null;
	        try {
	            // Charger le driver JDBC
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Établir la connexion
	            conn = DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (ClassNotFoundException e) {
	            System.out.println("Driver JDBC non trouvé !");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.out.println("Erreur de connexion !");
	            e.printStackTrace();
	        }
	        return conn;
	    }
	 
}
