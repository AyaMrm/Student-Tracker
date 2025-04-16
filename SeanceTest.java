package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

public class SeanceTest {
	 public static void main(String[] args) throws SQLException {
	        Connection connection = DatabaseConnection.getConnection();

	        if (connection == null) {
	            System.err.println(" Connexion à la base de données échouée.");
	            return;
	        }
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");


	        SeanceDAO seanceDAO = new SeanceDAO(connection);

	        try {
	            // 🔹 Création d'une nouvelle séance
	            Seance seance = new Seance(
	                1,
	                LocalTime.of(9, 0),
	                LocalTime.of(11, 0),
	                101,        // idModule
	                201,        // idProf
	                "Salle A",  // salle
	                1           // idJour (par exemple, lundi)
	            );

	            // ➕ Ajout
	            System.out.println(" Ajout d'une séance...");
	            seanceDAO.ajouterSeance(seance);

	            // 🔄 Modification
	            System.out.println("Modification de la séance...");
	            seance.setSalle("Salle B");
	            seanceDAO.modifierSeance(seance);

	            // 🔍 Récupération par ID
	            System.out.println(" Récupération par ID...");
	            Seance s = seanceDAO.getSeanceParId(1);
	            if (s != null) {
	                System.out.println(" Séance récupérée : " + s);
	            } else {
	                System.out.println(" Séance non trouvée.");
	            }

	            // 📋 Affichage de toutes les séances
	            System.out.println(" Toutes les séances :");
	            List<Seance> toutes = seanceDAO.getToutesLesSeances();
	            for (Seance se : toutes) {
	                System.out.println(se);
	            }

	            // ❌ Suppression
	            System.out.println(" Suppression de la séance");
	            seanceDAO.supprimerSeance(1);

	        } catch (Exception e) {
	            System.err.println(" Erreur lors des opérations sur les séances : " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
}
