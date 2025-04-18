package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmploiTest {
	public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Initialisation des DAO
            EmploiDuTempsDAO edtDAO = new EmploiDuTempsDAO(connection);
            SpecialiteDAO specialiteDAO = new SpecialiteDAO(connection);
            JourDAO jourDAO = new JourDAO(connection);

            // Désactiver temporairement les contraintes FK pour simplifier les tests
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");

            Specialite specialite = new Specialite(1, "Informatique");  // Id et nom de spécialité

            // Créer une liste de jours en utilisant JourSemaine
            List<Jour> jours = new ArrayList<>();
            jours.add(new Jour(1, JourSemaine.Lundi, new ArrayList<Seance>()));  // Jour Lundi
            jours.add(new Jour(2, JourSemaine.Mardi, new ArrayList<Seance>()));  // Jour Mardi
            
            // Créer un objet EmploiDuTemps
            EmploiDuTemps emploiDuTemps = new EmploiDuTemps(1, jours, "S1", "A", 2023, specialite);

            // Étape 3 : Créer un objet EmploiDuTempsDAO
            EmploiDuTempsDAO emploiDuTempsDAO = new EmploiDuTempsDAO(connection);

            // Étape 4 : Tester l'ajout
            boolean ajout = emploiDuTempsDAO.ajouterEmploiDuTemps(emploiDuTemps);
            if (ajout) {
                System.out.println(" Emploi du temps ajouté avec succès !");
            } else {
                System.out.println(" Échec de l'ajout de l'emploi du temps.");
            }

            // Étape 5 : Tester la récupération d'un emploi du temps
            EmploiDuTemps edtRecup = emploiDuTempsDAO.getEmploiDuTempsParId(1);
            if (edtRecup != null) {
                System.out.println(" Emploi du temps récupéré : " + edtRecup);
            } else {
                System.out.println(" Emploi du temps non trouvé.");
            }

            // Étape 6 : Tester la modification
            emploiDuTemps.setSection("S2");  // Modification de la section
            boolean modification = emploiDuTempsDAO.modifierEmploiDuTemps(emploiDuTemps);
            if (modification) {
                System.out.println(" Emploi du temps modifié avec succès !");
            } else {
                System.out.println(" Échec de la modification de l'emploi du temps.");
            }

            // Étape 7 : Tester la suppression
            boolean suppression = emploiDuTempsDAO.supprimerEmploiDuTemps(1);
            if (suppression) {
                System.out.println(" Emploi du temps supprimé avec succès !");
            } else {
                System.out.println(" Échec de la suppression de l'emploi du temps.");
            }
            
            // Réactiver les contraintes FK après les tests
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=1");

        } catch (SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution SQL : " + e.getMessage());
        }
    }
}
