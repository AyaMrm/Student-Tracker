package model;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
public class AnneeTest {

	    public static void main(String[] args) {
	    	try (Connection connection = DatabaseConnection.getConnection()) {
	            // Désactiver temporairement les contraintes de clé étrangère
	            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");
	            
	            AnneeDAO anneeDAO = new AnneeDAO(connection);
	            
	            // 1. Test d'ajout
	            System.out.println("\n--- Test Ajout ---");
	            Annee annee = new Annee(1, "2023/2024", 101, 5, new BigDecimal("12.5"), null, null);
	            boolean ajoutReussi = anneeDAO.addAnnee(annee);
	            System.out.println("Ajout réussi ? " + ajoutReussi);
	            
	            // 2. Test Récupération
	            System.out.println("\n--- Test Récupération ---");
	            Annee anneeRecup = anneeDAO.getAnneeById(1);
	            System.out.println("Année récupérée : " + anneeRecup);
	            
	            // 3. Test Liste
	            System.out.println("\n--- Test Liste ---");
	            System.out.println("Toutes les années : " + anneeDAO.getAllAnneesSorted());
	            
	            // Réactiver les contraintes
	            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=1");
	            
	        } catch (SQLException e) {
	            System.err.println("Erreur lors du test : " + e.getMessage());
	        }
}}
