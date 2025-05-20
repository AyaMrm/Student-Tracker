
package Controller;

import Controller.TestExamService;
import Model.TestExam;
import Model.TestExamDAO;
import Model.TypeTestExam;
import Model.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.util.List;

public class TestExamTestController {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");

            TestExamController testExamController = new TestExamController(connection);

            // 1. Test Ajout TestExam
            System.out.println("\n--- Test Ajout TestExam ---");
            TestExam testExam = new TestExam(25, TypeTestExam.EXAM, Date.valueOf("2025-05-23"), Time.valueOf("08:30:00"), 1, 3, "A", "1", "Description");
            boolean ajoutReussi = testExamController.ajouterTestExam(testExam);
            System.out.println("Ajout réussi ? " + ajoutReussi);

            // 2. Test Récupération
            System.out.println("\n--- Test Récupération TestExam ---");
            TestExam testExamRecup = testExamController.getTestExamParId(1);
            System.out.println("TestExam récupéré : " + testExamRecup);

            // 3. Test Liste
            System.out.println("\n--- Test Liste TestExams ---");
            List<TestExam> testExams = testExamController.getAllTestExams();
            System.out.println("Tous les tests : " + testExams);

            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=1");

        } catch (SQLException e) {
            System.err.println("Erreur lors du test TestExam : " + e.getMessage());
        }
    }
}

