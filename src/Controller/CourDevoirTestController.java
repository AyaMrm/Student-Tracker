package Controller;

import Service.CourDevoirService;
import Model.CourDevoir;
import Model.CourDevoirDAO;
import Model.DatabaseConnection;
import Model.TypeCourDevoir;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CourDevoirTestController {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");

            CourDevoirController courDevoirController = new CourDevoirController(connection);

            // 1. Test Ajout
            System.out.println("\n--- Test Ajout CourDevoir ---");
            CourDevoir courDevoir = new CourDevoir(79, "message", "Les Automates.pdf", TypeCourDevoir.DEVOIR, 2, 3, true, 4);
            boolean ajoutReussi = courDevoirController.ajouterCourDevoir(courDevoir);
            System.out.println("Ajout réussi ? " + ajoutReussi);

            // 2. Test Récupération
            System.out.println("\n--- Test Récupération CourDevoir ---");
            CourDevoir recup = courDevoirController.getCourPdfParId(1);
            System.out.println("CourDevoir récupéré : " + recup);

            // 3. Test Liste
            System.out.println("\n--- Test Liste CourDevoir Done par etudiant ---");
            List<CourDevoir> devoirs = courDevoirController.getCourDevoirDoneParEtudiant(4);
            System.out.println("Tous les devoirs : " + devoirs);

            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=1");

        } catch (SQLException e) {
            System.err.println("Erreur lors du test CourDevoir : " + e.getMessage());
        }
    }
}
