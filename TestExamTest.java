package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

public class TestExamTest {

    public static void main(String[] args) throws SQLException {
       try {
      	// Connexion à la base
      	Connection connection = DatabaseConnection.getConnection();

	        if (connection == null) {
	            System.err.println(" Connexion à la base de données échouée.");
	            return;
	        }
        
	        connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");
	        
   TestExamDAO testExamDAO = new TestExamDAO(connection);
            
            // Création d'un objet TestExam pour ajouter un test
            TestExam testExam = new TestExam(
                    1, // idTestExam
                    TypeTestExam.TEST, // type
                    Date.valueOf("2025-05-01"), // date
                    Time.valueOf("10:00:00"), // heure
                    101, // idModule
                    1001, // idProf
                    " A", // section
                    "1", // groupe
                    "Test de fin d'année" // description
            );
            
            // Ajouter un test ou un examen
            if (testExamDAO.ajouterTestExam(testExam)) {
                System.out.println("Test/Examen ajouté avec succès !");
            } else {
                System.out.println("Impossible d'ajouter le Test/Examen (peut-être déjà existant à cette date et heure).");
            }
            
            // Récupérer le TestExam ajouté
            TestExam retrievedTestExam = testExamDAO.getTestExamParId(1);
            if (retrievedTestExam != null) {
                System.out.println("Test/Examen récupéré : " + retrievedTestExam);
            } else {
                System.out.println("Test/Examen non trouvé.");
            }
            
            // Modifier la date et l'heure du Test/Examen
            boolean updated = testExamDAO.modifierTestExamDateHeure(1, Date.valueOf("2025-05-02"), Time.valueOf("14:00:00"));
            if (updated) {
                System.out.println("Test/Examen modifié avec succès !");
            } else {
                System.out.println("Impossible de modifier le Test/Examen (date et heure déjà prises).");
            }
            
            // Récupérer tous les TestExams pour une date spécifique
            List<TestExam> examsOnDate = testExamDAO.getAllTestExamsParDate(Date.valueOf("2025-05-01"));
            System.out.println("Tests/Exams le 01/05/2025 :");
            for (TestExam exam : examsOnDate) {
                System.out.println(exam);
            }
            
            // Supprimer un Test/Examen
            if (testExamDAO.supprimerTestExam(1)) {
                System.out.println("Test/Examen supprimé avec succès.");
            } else {
                System.out.println("Test/Examen non trouvé pour suppression.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       }
}
