package Controller;

import Service.EmploiDuTempsService;
import Model.EmploiDuTemps;
import Model.EmploiDuTempsDAO;
import Model.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmploiDuTempsTestController {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");

            EmploiDuTempsDAO emploiDAO = new EmploiDuTempsDAO(connection);
            EmploiDuTempsService emploiService = new EmploiDuTempsService(emploiDAO);
            EmploiDuTempsController emploiController = new EmploiDuTempsController(emploiService);

            // 1. Test Ajout emploi du temps
            System.out.println("\n--- Test Ajout EmploiDuTemps ---");
            EmploiDuTemps emploi = new EmploiDuTemps(1, null, "A", "4", 7, null);
            boolean ajoutReussi = emploiController.ajouterEmploiDuTemps(emploi);
            System.out.println("Ajout réussi ? " + ajoutReussi);

            // 2. Test Récupération
            System.out.println("\n--- Test Récupération EmploiDuTemps ---");
            EmploiDuTemps emploiRecup = emploiController.getEmploiParId(1);
            System.out.println("Emploi récupéré : " + emploiRecup);

            // 3. Test Liste
            System.out.println("\n--- Test Liste EmploiDuTemps ---");
            List<EmploiDuTemps> emplois = emploiController.getTousLesEmploisDuTemps();
            System.out.println("Tous les emplois du temps : " + emplois);

            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=1");

        } catch (SQLException e) {
            System.err.println("Erreur lors du test EmploiDuTemps : " + e.getMessage());
        }
    }
}
