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

             /*
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
        }*/
        /*
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

        int matriculeExistant = 33;
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


        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();



        Role roleTest = Role.ADMIN;

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

        //scanner.close();
    }
}

