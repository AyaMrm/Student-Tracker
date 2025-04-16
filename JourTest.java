package model;

import java.sql.Connection;
import java.util.List;

public class JourTest {
	public static void main(String[] args) {
        try {
            // Connexion à la base
        	Connection connection = DatabaseConnection.getConnection();

	        if (connection == null) {
	            System.err.println(" Connexion à la base de données échouée.");
	            return;
	        }
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");


            JourDAO jourDAO = new JourDAO(connection);

            //  1. Ajouter 
            Jour jour = new Jour(1, JourSemaine.Lundi, null);
            if (jourDAO.ajouterJour(jour)) {
                System.out.println(" Jour ajouté avec succès !");
            }

            //  2. Modifier 
            jour.setJour(JourSemaine.Mardi);
            if (jourDAO.modifierJour(jour)) {
                System.out.println(" Jour modifié !");
            }

            //  3. Récupérer par ID
            Jour recupere = jourDAO.getJourParId(1);
            System.out.println(" Jour récupéré : " + recupere);

            // 🔹 4. Lister tous les jours
            List<Jour> tousLesJours = jourDAO.getTousLesJours();
            System.out.println(" Liste des jours :");
            for (Jour j : tousLesJours) {
                System.out.println(j);
            }

            //  5. Supprimer 
            if (jourDAO.supprimerJour(1)) {
                System.out.println(" Jour supprimé !");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
