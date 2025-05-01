package Controller;

import Controller.UtilisateurController;
import Model.Role;
import Model.Utilisateur;
import Service.UtilisateurService;
import Model.UtilisateurDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtilisateurTestController {

    public static void main(String[] args) {
        try {
            // Connexion à la base de données
            Connection cnx = DatabaseConnection.getConnection();

            UtilisateurController controller = new UtilisateurController(cnx);

            // Création d’un utilisateur fictif ( devrait afficher false pcq cet utilisateur n'existe pas )
            Utilisateur user = new Utilisateur(1001, "NomTest", "PrenomTest", "test@test.com", "mdp123", Role.ETUDIANT);
            
            
            // Test existence
            boolean existe = controller.utilisateurExiste(1001);
            System.out.println("Utilisateur existe ? " + existe);

            // Test récupération
            Utilisateur recupere = controller.getUtilisateurByMat(1001);
            System.out.println("Utilisateur récupéré : " + recupere);

            // Test liste par rôle
            ArrayList<Utilisateur> etudiants = controller.getUtilisateursByRole("Etudiant");
            System.out.println("Liste des étudiants : " + etudiants);

        } catch (Exception e) {
            System.err.println("Erreur de connexion ou d’exécution : " + e.getMessage());
        }
    }
}
