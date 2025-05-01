package Controller;

import Service.PresenceService;
import Model.Presence;
import Model.PresenceDAO;
import Model.StatutPresence;
import Model.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

public class PresenceTestController {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");

            PresenceController presenceController = new PresenceController(connection);

            // 1. Test Ajout d'une présence
            System.out.println("\n--- Test Ajout Presence ---");
            Presence presence = new Presence(1, StatutPresence.Absent, Time.valueOf("08:30:00"), Date.valueOf("2025-01-06"), 1, 1, 3);
            boolean ajoutReussi = presenceController.ajouterPresence(presence);
            System.out.println("Ajout réussi ? " + ajoutReussi);

            // 2. Test Récupération par ID
            System.out.println("\n--- Test Récupération Presence ---");
            Presence presenceRecup = presenceController.getPresenceParId(1);
            System.out.println("Présence récupérée : " + presenceRecup);

            // 3. Test Liste de toutes les présences
            System.out.println("\n--- Test Liste Presence ---");
            List<Presence> presences = presenceController.getPresencesParEtudiant(1);
            System.out.println("Toutes les présences : " + presences);

            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=1");

        } catch (SQLException e) {
            System.err.println("Erreur lors du test Presence : " + e.getMessage());
        }
    }
}
