// terminé ! 
package Controller;

import Model.Utilisateur;
import Service.AuthService;
import Service.UtilisateurService;

import java.sql.Connection;
import java.util.ArrayList;

public class UtilisateurController {
	
    private final UtilisateurService utilisateurService;

    public UtilisateurController(Connection cnx) {
        this.utilisateurService = new UtilisateurService(cnx);
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
