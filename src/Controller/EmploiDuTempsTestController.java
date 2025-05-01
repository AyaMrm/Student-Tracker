package Controller;

import Service.EmploiDuTempsService;
import Model.EmploiDuTemps;
import Model.EmploiDuTempsDAO;
import Model.Specialite;
import Model.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmploiDuTempsTestController {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");

            EmploiDuTempsController emploiController = new EmploiDuTempsController(connection);

            // 1. Test Ajout emploi du temps
            System.out.println("\n--- Test Ajout EmploiDuTemps ---");
            Specialite sp = new Specialite(12, "Reseux");
            EmploiDuTemps emploi = new EmploiDuTemps(64, new ArrayList<>(), "A", "4", 7, sp);
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
