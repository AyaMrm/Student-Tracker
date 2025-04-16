package model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class NoteTest {
	  public static void main(String[] args) {
		  try {
	        	// Connexion à la base
	        	Connection connection = DatabaseConnection.getConnection();

		        if (connection == null) {
		            System.err.println(" Connexion à la base de données échouée.");
		            return;
		        }
	            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");

	            NoteDAO noteDAO = new NoteDAO(connection);

	            // Créer une note test
	            Note note = new Note(
	                1, // idNote
	                2, // coefficient
	                new BigDecimal("14.5"), // cc
	                new BigDecimal("15.0"), // exam
	                new BigDecimal("14.75"), // moyenne
	                1, // idEtudiant
	                1, // idProf
	                1, // idModule
	                1  // idSemestre
	            );

	            // 🔸 Tester l'ajout
	            boolean ajoutOK = noteDAO.ajouterNote(note);
	            System.out.println("Ajout de la note : " + (ajoutOK ? "Succès" : "Échec"));

	            // Tester la modification
	            note.setCc(new BigDecimal("16.0"));
	            note.setExam(new BigDecimal("18.0"));
	            note.setMoyenne(new BigDecimal("17.0"));
	            boolean modifOK = noteDAO.modifierNote(note);
	            System.out.println("Modification de la note : " + (modifOK ? "Succès" : "Échec"));

	            //  Récupérer la note par ID
	            Note noteRecuperee = noteDAO.getNoteParId(note.getIdNote());
	            System.out.println("Note récupérée : " + noteRecuperee);

	            //  Tester la suppression
	            boolean suppressionOK = noteDAO.supprimerNote(note.getIdNote());
	            System.out.println("Suppression de la note : " + (suppressionOK ? "Succès" : "Échec"));

	            //  Afficher toutes les notes restantes
	            List<Note> listeNotes = noteDAO.getToutesLesNotes();
	            System.out.println("Toutes les notes en base :");
	            for (Note n : listeNotes) {
	                System.out.println(n);
	            }

	            // Fermer la connexion
	            connection.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
