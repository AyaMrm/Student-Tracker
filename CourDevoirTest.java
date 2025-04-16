package model;
import java.sql.Connection;
import java.sql.SQLException;

import model.*;
public class CourDevoirTest {
    public static void main(String[] args) {


    	        try (Connection connection = DatabaseConnection.getConnection()) {
    	                	            
    	            // Désactiver temporairement les contraintes (pour simplifier les tests)
    	            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");
    	            CourDevoirDAO courDevoirDAO  = new CourDevoirDAO(connection);

    	         // Création d'un nouvel objet CourDevoir
    	            CourDevoir nouveauCourDevoir = new CourDevoir(
    	                1, // idCoursDevoirs
    	                "Message du devoir", // message
    	                "chemin/vers/le/fichier.pdf", // coursEnPDF
    	                TypeCourDevoir.DEVOIR, // type
    	                1, // idProf
    	                101, // idModule
    	                false, // devoirDone
    	                2001 // idEtudiant
    	            );

    	            // Test de l'ajout
    	            boolean ajoutReussi = courDevoirDAO.ajouterCourDevoir(nouveauCourDevoir);
    	            System.out.println("Ajout réussi : " + ajoutReussi);

    	            // Test de la récupération par ID
    	            CourDevoir recupereCour = courDevoirDAO.getCourPdfParId(1);
    	            System.out.println("Cour récupéré : " + recupereCour);

    	            // Test de la modification
    	            nouveauCourDevoir.setMessage("Message modifié");
    	            boolean modificationReussie = courDevoirDAO.modifierCourDevoir(nouveauCourDevoir);
    	            System.out.println("Modification réussie : " + modificationReussie);

    	            // Test de la récupération après modification
    	            CourDevoir courModifie = courDevoirDAO.getCourPdfParId(1);
    	            System.out.println("Cour après modification : " + courModifie);

    	            // Test de la suppression
    	            boolean suppressionReussie = courDevoirDAO.supprimerCourDevoir(1);
    	            System.out.println("Suppression réussie : " + suppressionReussie);

    	            // Test de la récupération après suppression (devrait être null)
    	            CourDevoir courSupp = courDevoirDAO.getCourPdfParId(1);
    	            System.out.println("Cour après suppression : " + courSupp);

    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
}
}
