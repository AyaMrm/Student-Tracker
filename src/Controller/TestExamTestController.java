
package Controller;

import Service.TestExamService;
import Model.TestExam;
import Model.TestExamDAO;
import Model.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestExamTestController {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");

            TestExamDAO testExamDAO = new TestExamDAO(connection);
            TestExamService testExamService = new TestExamService(testExamDAO);
            TestExamController testExamController = new TestExamController(testExamService);

            // 1. Test Ajout TestExam
            System.out.println("\n--- Test Ajout TestExam ---");
            TestExam testExam = new TestExam(1, null, null, null, 0, 0, "Final Exam", "2025-06-15", null);
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

