// terminé ! 
package Controller;

import Model.Utilisateur;
import Service.UtilisateurService;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;

public class UtilisateurController {
	
    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    public boolean ajouterUtilisateur(Utilisateur user) {
        return utilisateurService.modifierUtilisateur(user);
    }

    public boolean modifierUtilisateur(Utilisateur user) {
        return utilisateurService.modifierUtilisateur(user);
    }

    public boolean supprimerUtilisateur(int id) {
        return utilisateurService.supprimerUtilisateur(id);
    }

    public Utilisateur getUtilisateurByMat(int id) {
        return utilisateurService.getUtilisateurByMat(id);
    }

    public ArrayList<Utilisateur> getUtilisateursByNom(String nom) {
        return utilisateurService.getUtilisateursByNom(nom);
    }

    public ArrayList<Utilisateur> getUtilisateursByRole(String role) {
        return utilisateurService.getUtilisateursByRole(role);
    }

    public ArrayList<Utilisateur> getTousLesUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    public boolean utilisateurExiste(int id) {
        return utilisateurService.utilisateurExiste(id);
    }
}
