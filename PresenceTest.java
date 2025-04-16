package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

public class PresenceTest {
	public static void main(String[] args) {
        try {
             	// Connexion à la base
             	Connection connection = DatabaseConnection.getConnection();

     	        if (connection == null) {
     	            System.err.println(" Connexion à la base de données échouée.");
     	            return;
     	        }
               
     	        connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");
            
     	        PresenceDAO dao = new PresenceDAO(connection);
            

            // Créer une présence 
            Presence presence = new Presence(
                1,
                StatutPresence.Présent,
                Time.valueOf("10:00:00"),
                Date.valueOf("2025-04-16"),
                101, // idEtudiant
                201, // idModule
                301  // idProf
            );

            //  Ajouter
            boolean ajout = dao.ajouterPresence(presence);
            System.out.println("Ajout réussi ? " + ajout);

            //  Modifier
            presence.setStatut(StatutPresence.Justifié);
            boolean modif = dao.modifierPresence(presence);
            System.out.println("Modification réussie ? " + modif);

            //  Récupérer par ID
            Presence p = dao.getPresenceParId(1);
            System.out.println("Présence récupérée : " + p);

            // Lister les présences d’un module
            List<Presence> parModule = dao.getPresenceParModule(201);
            System.out.println("Présences pour module 201 :");
            for (Presence pr : parModule) {
                System.out.println(pr);
            }

            //  Supprimer
            boolean supprime = dao.supprimerPresence(1);
            System.out.println("Suppression réussie ? " + supprime);

            //  Fermer connexion
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
