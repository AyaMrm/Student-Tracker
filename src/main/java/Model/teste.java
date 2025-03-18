package Model;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class teste {
    public static void main(String[] args) {

        Connection connection = ConnectionDB.getConnection();
        if (connection == null) {
            System.out.println("❌ Impossible de se connecter a la BD !");
            return;
        }


        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();


        Scanner scanner = new Scanner(System.in);


        System.out.print("Entrez le Mat d utilisateur : ");
        int idUser = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez le nom : ");
        String nom = scanner.nextLine();

        System.out.print("Entrez le prenom : ");
        String prenom = scanner.nextLine();

        System.out.print("Entrez l'email : ");
        String email = scanner.nextLine();

        System.out.print("Entrez le mot de passe : ");
        String password = scanner.nextLine();

        System.out.print("Entrez le roele (ADMIN, PROF, ETUDIANT) : ");
        String roleStr = scanner.nextLine();


        Role role;
        try {
            role = Role.valueOf(roleStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Role invalide !");
            return;
        }


        Utilisateur utilisateur = new Utilisateur(idUser, nom, prenom, email, password, role);


        boolean success = utilisateurDAO.ajouterUtilisateur(utilisateur);

        if (success) {
            System.out.println("✅ Utilisateur ajoutee avec succees !");
        } else {
            System.out.println("❌ echec de l'ajout de l'utili.");
        }


        /*
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

        int matriculeExistant = 1111;
        Utilisateur utilisateur1 = utilisateurDAO.getUtilisateurByMat(matriculeExistant);

        if (utilisateur1 != null) {
            System.out.println("✅ Utilisateur trouvé !");
            System.out.println("Matricule : " + utilisateur1.getMatricule());
            System.out.println("Nom : " + utilisateur1.getNom());
            System.out.println("Prénom : " + utilisateur1.getPrenom());
            System.out.println("Email : " + utilisateur1.getEmail());
            System.out.println("Rôle : " + utilisateur1.getRole());
        } else {
            System.out.println("❌ Aucun utilisateur trouvé avec ce matricule !");
        }
        */


        /*
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        Role roleTest = Role.ETUDIANT;

        System.out.println("🔍 Recherche des utilisateurs avec le rôle : " + roleTest);
        ArrayList<Utilisateur> utilisateurs = utilisateurDAO.getUtilisateursByRole(roleTest);

        if (utilisateurs == null || utilisateurs.isEmpty()) {
            System.out.println("⚠️ Aucun utilisateur trouvé pour le rôle : " + roleTest);
        } else {
            System.out.println("✅ Utilisateurs trouvés :");
            for (Utilisateur user : utilisateurs) {
                System.out.println("📌 " + user.getMatricule() + " | " + user.getNom() + " " + user.getPrenom() + " | " + user.getEmail() + " | " + user.getRole());
            }
        }
        */

        /*
        // teste de modification !!
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        Utilisateur utilisateurModifie = new Utilisateur(1111, "nom", "Prenom", "nvemail@example.com", Role.ETUDIANT);

        if (utilisateurDAO.modifierUtilisateur(utilisateurModifie)) {
            System.out.println("🎉 Modification réussie !");
        } else {
            System.out.println("❌ La modification a échoué.");
        }
        */


        /*
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        Scanner scanner = new Scanner(System.in);

        System.out.print("🔎 Entrez l'ID de l'utilisateur à supprimer : ");
        int idUser = scanner.nextInt();

        boolean success = utilisateurDAO.supprimerUtilisateur(idUser);

        if (success) {
            System.out.println("✅ L'utilisateur avec ID " + idUser + " a été supprimé avec succès !");
        } else {
            System.out.println("❌ Échec de la suppression. Vérifiez si l'ID existe !");
        }

        scanner.close();
        */


        /*
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();


        String namee = "jsp";

        System.out.println("🔍 Recherche des utilisateurs avec le rôle : ");
        ArrayList<Utilisateur> utilisateurs = utilisateurDAO.getUtilisateurByNom(namee);

        if (utilisateurs == null || utilisateurs.isEmpty()) {
            System.out.println("⚠️ Aucun utilisateur trouvé pour le rôle : " + namee);
        } else {
            System.out.println("✅ Utilisateurs trouvés :");
            for (Utilisateur user : utilisateurs) {
                System.out.println("📌 " + user.getMatricule() + " | " + user.getNom() + " " + user.getPrenom() + " | " + user.getEmail() + " | "+user.getRole());
            }
            */
         /*
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        System.out.println("📌 Test : Récupération des utilisateurs...");
        ArrayList<Utilisateur> utilisateurs = utilisateurDAO.getAllUtilisateurs();

        if (utilisateurs.isEmpty()) {
            System.out.println("⚠ Aucun utilisateur trouvé.");
        } else {
            System.out.println("✅ Liste des utilisateurs récupérée avec succès !");
            for (Utilisateur user : utilisateurs) {
                System.out.println("➡ ID: " + user.getMatricule() +
                        ", Nom: " + user.getNom() +
                        ", Prénom: " + user.getPrenom() +
                        ", Email: " + user.getEmail() +
                        ", Rôle: " + user.getRole());
            }
        }

         */
        //scanner.close();
    }
}

