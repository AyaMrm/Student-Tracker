package model;

import java.sql.Connection;
import java.sql.SQLException;

public class ProfModuleTest {
	public static void main(String[] args) {
		try (Connection connection = DatabaseConnection.getConnection()) {
            // Désactiver temporairement les contraintes de clé étrangère
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");
            
            ProfModuleDAO profModuleDAO = new ProfModuleDAO(connection);

            // Test de l'ajout d'une relation entre un professeur et un module
            int idProf = 1;
            int idModule = 101;

            // Ajouter 
            boolean ajout = profModuleDAO.ajouterRelation(idProf, idModule);
            if (ajout) {
                System.out.println(" Relation ajoutée avec succès !");
            } else {
                System.out.println(" La relation existe déjà ou l'ajout a échoué.");
            }

            // Vérifier 
            boolean existe = profModuleDAO.existeRelation(idProf, idModule);
            if (existe) {
                System.out.println(" La relation existe !");
            } else {
                System.out.println(" La relation n'existe pas.");
            }

            // Récupérer les modules pour un professeur
            System.out.println("Modules du professeur " + idProf + ": " + profModuleDAO.getModulesParProf(idProf));

            // Récupérer les professeurs pour un module
            System.out.println("Professeurs du module " + idModule + ": " + profModuleDAO.getProfsParModule(idModule));

            // Supprimer 
            boolean suppression = profModuleDAO.supprimerRelation(idProf, idModule);
            if (suppression) {
                System.out.println(" Relation supprimée avec succès !");
            } else {
                System.out.println(" La relation n'existe pas ou la suppression a échoué.");
            }

            // Vérifier si la relation existe après suppression
            existe = profModuleDAO.existeRelation(idProf, idModule);
            if (existe) {
                System.out.println(" La relation existe encore !");
            } else {
                System.out.println(" La relation n'existe plus.");
            }

        } catch (SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution SQL : " + e.getMessage());
        }
	}
}
