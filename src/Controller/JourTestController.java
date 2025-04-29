package Controller;

import Service.JourService;
import Model.Jour;
import Model.JourDAO;
import Model.JourSemaine;
import Model.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JourTestController {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");

            JourDAO jourDAO = new JourDAO(connection);
            JourService jourService = new JourService(jourDAO);
            JourController jourController = new JourController(jourService);

            // 1. Test Ajout
            System.out.println("\n--- Test Ajout Jour ---");
            Jour jour = new Jour(3, JourSemaine.Dimanche, null);
            boolean ajoutReussi = jourController.ajouterJour(jour);
            System.out.println("Ajout réussi ? " + ajoutReussi);

            // 2. Test Récupération
            System.out.println("\n--- Test Récupération Jour ---");
            Jour jourRecup = jourController.getJourParId(3);
            System.out.println("Jour récupéré : " + jourRecup);

            // 3. Test Liste
            System.out.println("\n--- Test Liste Jours ---");
            List<Jour> jours = jourController.getTousLesJours();
            System.out.println("Tous les jours : " + jours);

            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=1");

        } catch (SQLException e) {
            System.err.println("Erreur lors du test Jour : " + e.getMessage());
        }
    }
}
