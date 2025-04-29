package Controller;

import Service.SpecialiteService;
import Model.Specialite;
import Model.SpecialiteDAO;
import Model.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SpecialiteTestController {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");

            SpecialiteDAO specialiteDAO = new SpecialiteDAO(connection);
            SpecialiteService specialiteService = new SpecialiteService(specialiteDAO);
            SpecialiteController specialiteController = new SpecialiteController(specialiteService);

            // 1. Test Ajout spécialité
            System.out.println("\n--- Test Ajout Spécialité ---");
            Specialite specialite = new Specialite(1, "Informatique");
            boolean ajoutReussi = specialiteController.ajouterSpecialite(specialite);
            System.out.println("Ajout réussi ? " + ajoutReussi);

            // 2. Test Récupération
            System.out.println("\n--- Test Récupération Spécialité ---");
            Specialite specialiteRecup = specialiteController.getSpecialiteParId(1);
            System.out.println("Spécialité récupérée : " + specialiteRecup);

            // 3. Test Liste
            System.out.println("\n--- Test Liste Spécialités ---");
            List<Specialite> specialites = specialiteController.getToutesLesSpecialites();
            System.out.println("Toutes les spécialités : " + specialites);

            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=1");

        } catch (SQLException e) {
            System.err.println("Erreur lors du test Spécialité : " + e.getMessage());
        }
    }
}
