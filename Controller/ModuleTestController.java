package Controller;

import Controller.ModuleService;
import Model.Module;
import Model.ModuleDAO;
import Model.DatabaseConnection;
import Model.MethodeCalcul;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ModuleTestController {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");

            ModuleController moduleController = new ModuleController(connection);

            // 1. Test Ajout d'un module
            System.out.println("\n--- Test Ajout Module ---");
            Module module = new Module(2, "POO", 1, 1, 1, MethodeCalcul.CLASSIQUE_40_60, 0.40, 0.60);
            boolean ajoutReussi = moduleController.ajouterModule(module);
            System.out.println("Ajout réussi ? " + ajoutReussi);

            // 2. Test Récupération d'un module
            System.out.println("\n--- Test Récupération Module ---");
            Module moduleRecup = moduleController.getModuleParId(1);
            System.out.println("Module récupéré : " + moduleRecup);

            // 3. Test Liste de tous les modules
            System.out.println("\n--- Test Liste Modules ---");
            List<Module> modules = moduleController.getTousLesModules();
            System.out.println("Tous les modules : " + modules);

            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=1");

        } catch (SQLException e) {
            System.err.println("Erreur lors du test Module : " + e.getMessage());
        }
    }
}
