package Controller;

import Service.SeanceService;
import Model.Seance;
import Model.SeanceDAO;
import Model.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

public class SeanceTestController {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");

            SeanceController seanceController = new SeanceController(connection);
            
            // 1. Test Ajout séance
            System.out.println("\n--- Test Ajout Séance ---");
            Seance seance = new Seance(1, LocalTime.of(8, 00), LocalTime.of(9, 30), 3, 6, "315T",4);
            boolean ajoutReussi = seanceController.ajouterSeance(seance);
            System.out.println("Ajout réussi ? " + ajoutReussi);

            // 2. Test Récupération
            System.out.println("\n--- Test Récupération Séance ---");
            Seance seanceRecup = seanceController.getSeanceParId(1);
            System.out.println("Séance récupérée : " + seanceRecup);

            // 3. Test Liste
            System.out.println("\n--- Test Liste Séances ---");
            List<Seance> seances = seanceController.getToutesLesSeances();
            System.out.println("Toutes les séances : " + seances);

            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=1");

        } catch (SQLException e) {
            System.err.println("Erreur lors du test Séance : " + e.getMessage());
        }
    }
}

