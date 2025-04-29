package Controller;

import Service.ProfModuleService;
import Model.DatabaseConnection;
import Model.ProfModuleDAO;
import java.sql.Connection;
import java.sql.SQLException;

public class ProfModuleTest {
    public static void main(String[] args) {
        try {
            // Connexion à la base
            Connection connection = DatabaseConnection.getConnection();
            if (connection == null) {
                System.err.println("Connexion échouée.");
                return;
            }

            ProfModuleDAO dao = new ProfModuleDAO(connection);
            ProfModuleService service = new ProfModuleService(dao);
            ProfModuleController controller = new ProfModuleController(service);

            // Test ajout d'une relation valide
            boolean ajout = controller.ajouterRelation(1, 101); // Prof 1, Module 101
            System.out.println("Ajout de la relation : " + ajout); // Devrait afficher true

            // Test tentative d'ajout d'une relation déjà existante
            ajout = controller.ajouterRelation(1, 101); // Relation déjà existante
            System.out.println("Ajout relation déjà existante : " + ajout); // Devrait afficher false

            // Test suppression d'une relation existante
            boolean suppression = controller.supprimerRelation(1, 101);
            System.out.println("Suppression de la relation : " + suppression); // Devrait afficher true

            // Test tentative de suppression d'une relation inexistante
            suppression = controller.supprimerRelation(1, 101); // Relation supprimée
            System.out.println("Suppression relation inexistante : " + suppression); // Devrait afficher false

            // Test récupération des modules par professeur
            System.out.println("Modules pour Prof 1 : " + controller.getModulesParProf(1)); // Devrait afficher la liste des modules

            // Test récupération des professeurs par module
            System.out.println("Professeurs pour Module 101 : " + controller.getProfsParModule(101)); // Devrait afficher la liste des professeurs

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
