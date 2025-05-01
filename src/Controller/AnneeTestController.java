//ErreurController.AnneeTestController not found
package Controller;

import Service.AnneeService;
import Model.Annee;
import Model.AnneeDAO;
import Model.DatabaseConnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class AnneeTestController {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Désactiver temporairement les contraintes de clé étrangère
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");

            AnneeController anneeController = new AnneeController(connection);

            // 1. Test Ajout via Controller 
            System.out.println("\n--- Test Ajout Controller ---");
            Annee annee = new Annee(88, "2023/2024", 5, new BigDecimal("12.5"), null, null);
            boolean ajoutReussi = anneeController.ajouterAnnee(annee);
            System.out.println("Ajout réussi ? " + ajoutReussi);

            // 2. Test Récupération via Controller
            System.out.println("\n--- Test Récupération Controller ---");
            Annee anneeRecup = anneeController.getAnneeById(88);
            System.out.println("Année récupérée : " + anneeRecup);

            // 3. Test Liste via Controller
            System.out.println("\n--- Test Liste Controller ---");
            System.out.println("Toutes les années : " + anneeController.getAllAnneesTriees());

            // Réactiver les contraintes
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=1");

        } catch (SQLException e) {
            System.err.println("Erreur lors du test Controller : " + e.getMessage());
        }
    }
}