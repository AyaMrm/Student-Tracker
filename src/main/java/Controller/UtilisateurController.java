package Controller;


import Model.Utilisateur;
import Service.UtilisateurService;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;

public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController() {
        this.utilisateurService = new UtilisateurService();
    }

    public void authentifierUtilisateur(int matricule, String motDePasse) {
        try {
            Utilisateur utilisateur = utilisateurService.authentifierUtilisateur(matricule, motDePasse);
            System.out.println("Connexion réussie ! Bienvenue " + utilisateur.getNom() + " (" + utilisateur.getRole() + ")");
        } catch (Exception e) {
            System.out.println("Erreur lors de l'authentification : " + e.getMessage());
        }
    }

    public void deconnecter() {
        utilisateurService.deconnecter();
        System.out.println("Déconnexion réussie.");
    }

    public void estConnecte() {
        if (utilisateurService.estConnecter()) {
            System.out.println("Un utilisateur est actuellement connecté.");
        } else {
            System.out.println("Aucun utilisateur connecté.");
        }
    }

    public void verifierRole(String roleAttendu) {
        boolean ok = utilisateurService.verifierRole(roleAttendu);
        if (ok) {
            System.out.println("L'utilisateur a le rôle : " + roleAttendu);
        } else {
            System.out.println("L'utilisateur n'a PAS le rôle : " + roleAttendu);
        }
    }

    public void ajouterUtilisateur(Utilisateur user) {
        if (utilisateurService.ajouterUtilisateur(user)) {
            System.out.println("Utilisateur ajouté avec succès !");
        } else {
            System.out.println("Erreur : L'utilisateur existe déjà ou un problème est survenu.");
        }
    }

    public void modifierUtilisateur(Utilisateur user) {
        if (utilisateurService.modifierUtilisateur(user)) {
            System.out.println("Utilisateur modifié avec succès !");
        } else {
            System.out.println("Échec de la modification de l'utilisateur.");
        }
    }

    public void supprimerUtilisateur(int matricule) {
        if (utilisateurService.supprimerUtilisateur(matricule)) {
            System.out.println("Utilisateur supprimé avec succès !");
        } else {
            System.out.println("Échec de la suppression de l'utilisateur.");
        }
    }

    public void changerPassword(int matricule, String ancien, String nouveau) {
        if (utilisateurService.changerPassword(matricule, ancien, nouveau)) {
            System.out.println("Mot de passe changé avec succès !");
        } else {
            System.out.println("Erreur : Échec du changement de mot de passe.");
        }
    }

    public void getUtilisateurByMat(int matricule) {
        Utilisateur user = utilisateurService.getUtilisateurByMat(matricule);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("Aucun utilisateur trouvé.");
        }
    }

    public void getAllLesUtilisateurs() {
        ArrayList<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();
        if (utilisateurs.isEmpty()) {
            System.out.println("Aucun utilisateur trouvé.");
        } else {
            for (Utilisateur u : utilisateurs) {
                System.out.println(u);
            }
        }
    }

    public void getUtilisateurByNom(String nom) {
        ArrayList<Utilisateur> utilisateurs = utilisateurService.getUtilisateurByNom(nom);
        if (utilisateurs.isEmpty()) {
            System.out.println("Aucun utilisateur avec ce nom.");
        } else {
            utilisateurs.forEach(System.out::println);
        }
    }

    public void getUtilisateurByRole(String role) {
        ArrayList<Utilisateur> utilisateurs = utilisateurService.getUtilisateurByRole(role);
        if (utilisateurs.isEmpty()) {
            System.out.println("Aucun utilisateur avec le rôle " + role);
        } else {
            utilisateurs.forEach(System.out::println);
        }
    }
}
