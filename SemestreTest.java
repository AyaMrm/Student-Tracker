package model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

public class SemestreTest {
	public static void main(String[] args) {
        try {
        	// Connexion à la base
        	Connection connection = DatabaseConnection.getConnection();

	        if (connection == null) {
	            System.err.println(" Connexion à la base de données échouée.");
	            return;
	        }
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");


            SemestreDAO dao = new SemestreDAO(connection);

            // 🔹 Crée un semestre à tester
            Semestre s1 = new Semestre(
                    1001,                           // idSemestre
                    NumeroSemestre.SEMESTRE_1,             // numero
                    new BigDecimal("14.50"),       // moyenneSemestre
                    1                              // idAnnee (doit exister dans la table `annees`)
            );

            // 🔸 Ajout
            dao.ajouterSemestre(s1);

            // 🔸 Modification
            s1.setMoyenneSemestre(new BigDecimal("15.75"));
            s1.setNumero(NumeroSemestre.SEMESTRE_2);
            dao.updateSemestre(s1);

            // 🔸 Récupération par ID
            Semestre recupere = dao.getSemestreById(1001);
            System.out.println(" Semestre récupéré : " + recupere);

            //  Récupération de tous les semestres
            List<Semestre> tous = dao.getAllSemestres();
            System.out.println(" Liste de tous les semestres :");
            for (Semestre s : tous) {
                System.out.println(".. " + s);
            }

            // 🔸 Suppression (attention à la règle : ne pas supprimer si l'année a exactement deux semestres)
            // dao.deleteSemestre(1001, 1);

        } catch (Exception e) {
            System.err.println(" Erreur pendant le test : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
