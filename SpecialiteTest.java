package model;

import java.sql.Connection;
import java.util.List;

public class SpecialiteTest {
	public static void main(String[] args) {
        try {
        	 // Connexion à la base
        	Connection connection = DatabaseConnection.getConnection();

	        if (connection == null) {
	            System.err.println(" Connexion à la base de données échouée.");
	            return;
	        }
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");


            // Création du DAO
            SpecialiteDAO dao = new SpecialiteDAO(connection);

            // 🔹 1. Test ajout
            Specialite s1 = new Specialite(1, "Informatique");
            if (dao.ajouterSpecialite(s1)) {
                System.out.println(" Spécialité ajoutée : " + s1);
            }

            // 🔹 2. Test modification
            s1.setNomSpecialite("Génie Informatique");
            if (dao.modifierSpecialite(s1)) {
                System.out.println(" Spécialité modifiée : " + s1);
            }

            // 🔹 3. Test récupération par ID
            Specialite recuperee = dao.getSpecialiteParId(1);
            System.out.println(" Spécialité récupérée : " + recuperee);

            // 🔹 4. Test récupération de toutes les spécialités
            List<Specialite> toutes = dao.getToutesLesSpecialites();
            System.out.println(" Liste de toutes les spécialités :");
            for (Specialite s : toutes) {
                System.out.println(".. " + s);
            }

            // 🔹 5. Test suppression
            if (dao.supprimerSpecialite(1)) {
                System.out.println(" Spécialité supprimée (ID 1)");
            }

        } catch (Exception e) {
            System.err.println(" Erreur pendant le test : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
