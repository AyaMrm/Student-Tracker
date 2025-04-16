package model;

import java.sql.Connection;
import java.sql.SQLException;

public class EtudiantModuleTest {
    public static void main(String[] args) {
    	try (Connection connection = DatabaseConnection.getConnection()) {
            // Désactiver temporairement les contraintes de clé étrangère
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");
            EtudiantModuleDAO etudiantModuleDAO = new EtudiantModuleDAO(connection);

            // Test de l'ajout d'une relation entre un étudiant et un module
            int idEtudiant = 1;
            int idModule = 101;

            // Ajouter la relation
            boolean ajout = etudiantModuleDAO.ajouterRelation(idEtudiant, idModule);
            if (ajout) {
                System.out.println(" Relation ajoutée avec succès !");
            } else {
                System.out.println(" La relation existe déjà ou l'ajout a échoué.");
            }

            // Vérifier si la relation existe
            boolean existe = etudiantModuleDAO.existeRelation(idEtudiant, idModule);
            if (existe) {
                System.out.println(" La relation existe !");
            } else {
                System.out.println(" La relation n'existe pas.");
            }

            // Récupérer les modules pour un étudiant
            System.out.println("Modules de l'étudiant " + idEtudiant + ": " + etudiantModuleDAO.getModulesParEtudiant(idEtudiant));

            // Récupérer les étudiants pour un module
            System.out.println("Étudiants inscrits au module " + idModule + ": " + etudiantModuleDAO.getEtudiantsParModule(idModule));

            // Supprimer la relation
            boolean suppression = etudiantModuleDAO.supprimerRelation(idEtudiant, idModule);
            if (suppression) {
                System.out.println(" Relation supprimée avec succès !");
            } else {
                System.out.println(" La relation n'existe pas ou la suppression a échoué.");
            }

            // Vérifier si la relation existe après suppression
            existe = etudiantModuleDAO.existeRelation(idEtudiant, idModule);
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
