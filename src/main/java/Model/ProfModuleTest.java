package Model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

    public static class SemestreTest {
        public static void main(String[] args) {
            try {
                // Connexion à la base
                Connection connection = DatabaseConnection.getConnection();

                if (connection == null) {
                    System.err.println(" Connexion à la base de données échouée.");
                    return;
                }
                connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");


                Role.SemestreDAO dao = new Role.SemestreDAO(connection);

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
}
