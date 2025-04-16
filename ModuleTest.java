package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ModuleTest {
	 public static void main(String[] args) {
		 try {
	          	// Connexion à la base
	          	Connection connection = DatabaseConnection.getConnection();

	  	        if (connection == null) {
	  	            System.err.println(" Connexion à la base de données échouée.");
	  	            return;
	  	        }
	            
	  	        connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");
	         
	            ModuleDAO moduleDAO = new ModuleDAO(connection);
	            // Création d’un module
	            // Création d'un module pour le test
	            Module module = new Module(1, "Mathématiques", 101, 10, 1, MethodeCalcul.CLASSIQUE_40_60, null, null);

	            // Test d'ajout de module
	            System.out.println("Ajout d'un module...");
	            moduleDAO.ajouterModule(module);

	            // Test de récupération d'un module par ID
	            System.out.println("\nRécupération du module avec ID 1...");
	            Module retrievedModule = moduleDAO.getModuleById(1);
	            System.out.println(retrievedModule);

	            // Test de mise à jour du module
	            System.out.println("\nMise à jour du module...");
	            module.setNom("Mathématiques Avancées");
	            moduleDAO.updateModule(module);

	            // Test de récupération de tous les modules
	            System.out.println("\nRécupération de tous les modules...");
	            List<Module> modules = moduleDAO.getAllModules();
	            for (Module m : modules) {
	                System.out.println(m);
	            }

	            // Test de suppression de module
	            System.out.println("\nSuppression du module avec ID 1...");
	            moduleDAO.supprimerModule(1);

	            // Vérification que le module a bien été supprimé
	            System.out.println("\nVérification de la suppression...");
	            Module deletedModule = moduleDAO.getModuleById(1);
	            if (deletedModule == null) {
	                System.out.println("Le module avec ID 1 a été supprimé.");
	            } else {
	                System.out.println("Le module avec ID 1 existe toujours.");
	            }

	            // Fermeture de la connexion
	            connection.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

		 }
	    }

