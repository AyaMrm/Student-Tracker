package Controller;

import Service.EtudiantModuleService;
import Model.EtudiantModule;
import Model.EtudiantModuleDAO;
import Model.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EtudiantModuleTestController {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");

            EtudiantModuleDAO etudiantModuleDAO = new EtudiantModuleDAO(connection);
            EtudiantModuleService etudiantModuleService = new EtudiantModuleService(etudiantModuleDAO);
            EtudiantModuleController etudiantModuleController = new EtudiantModuleController(etudiantModuleService);

            // 1. Test Ajout d'un lien étudiant-module
            System.out.println("\n--- Test Ajout EtudiantModule ---");
            EtudiantModule etudiantModule = new EtudiantModule(1, 1);
            boolean ajoutReussi = etudiantModuleController.ajouterRelation(1, 2);
            System.out.println("Ajout réussi ? " + ajoutReussi);

            // 2. Test Récupération
            System.out.println("\n--- Test Récupération EtudiantModule ---");
            List<Integer> etudiantModuleRecup = etudiantModuleController.getEtudiantsParModule(1);
            System.out.println("Lien récupéré : " + etudiantModuleRecup);

            // 3. Test Liste de tous les liens
            System.out.println("\n--- Test Liste EtudiantModules ---");
            List<Integer> liens = etudiantModuleController.getModulesParEtudiant(1);
            System.out.println("Tous les liens : " + liens);

            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=1");

        } catch (SQLException e) {
            System.err.println("Erreur lors du test EtudiantModule : " + e.getMessage());
        }
    }
}
