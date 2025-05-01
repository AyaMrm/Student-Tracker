// terminé !
package Controller;

import java.sql.Connection;

import Model.Utilisateur;
import Service.AuthService;


public class AuthController {

    private final AuthService authService;

    public AuthController(Connection cnx) {
        this.authService = new AuthService(cnx);
    }

    public boolean ajouterUtilisateur(Utilisateur user, String password) {
        return authService.ajouterUtilisateur(user, password);
    }

    public Utilisateur connecter(int idUser, String password) {
        return authService.connecter(idUser, password);
    }

    public boolean changerMotDePasse(int idUser, String ancien, String nouveau) {
        return authService.changePassword(idUser, ancien, nouveau);
    }
}
