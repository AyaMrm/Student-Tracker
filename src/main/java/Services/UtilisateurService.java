package Services;
import Model.Utilisateur;
import Model.UtilisateurDAO;
import Model.PasswordCryp;
import Model.Role;

import java.lang.String;
import java.util.ArrayList;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class UtilisateurService {
    UtilisateurDAO userDAO = new UtilisateurDAO();

    public UtilisateurService(){
        this.userDAO = new UtilisateurDAO();
    }

    //finally il marche 🥳
    public Utilisateur authentifierUtilisateur(int idUser, String motdepasse) throws AuthException {
        if (motdepasse == null || motdepasse.trim().isEmpty()) {
            throw new AuthException("Le mot de passe ne peut pas être vide");
        }
        Utilisateur utilisateur = userDAO.authentifier(idUser, motdepasse);
        if (utilisateur == null) {
            throw new AuthException("Identifiants incorrects");
        }
        Session.getInstance().setUserConnecter(utilisateur);
        return utilisateur;
    }

    public void deconnecter(){
        Session.getInstance().clearUserConnecter();
        System.out.println("User Disconnected with succes !!");
    }

    public boolean estConnecter(){
        return Session.getInstance().getUserConnecter() != null;
    }

    public boolean verifierRole(String roleAttendu){
        Utilisateur user = Session.getInstance().getUserConnecter();
        if(user == null){
            return false;
        }
        Role role = Role.valueOf(roleAttendu.toUpperCase());
        return user.getRole().equals(role);
    }

    //tester et elle marche !
    public boolean userExists(int matricule) {
        return userDAO.existe(matricule);
    }

    //elle marche aussi
    public boolean ajouterUtilisateur(Utilisateur user){
        if(userDAO.existe(user.getMatricule())){
            System.err.println("L'utilisateur existe deja !!");
            return false;
        }
        return userDAO.ajouterUtilisateur(user);
    }

    //marche
    public Utilisateur getUtilisateurByMat(int matricule){
        return userDAO.getUtilisateurByMat(matricule);
    }

    // il maarchee
    public ArrayList<Utilisateur> getUtilisateurByRole(String strRole) {
        try {
            Role role = Role.valueOf(strRole.toUpperCase());
            return userDAO.getUtilisateursByRole(role);
        } catch (IllegalArgumentException e) {
            System.err.println("Utilisateur avec ce role n'existant pas !");
            return new ArrayList<>();
        }
    }

    //yepp
    public ArrayList<Utilisateur> getUtilisateurByNom(String nom){
        return userDAO.getUtilisateurByNom(nom);
    }

    //fait !
    public ArrayList<Utilisateur> getAllUtilisateurs(){
        return userDAO.getAllUtilisateurs();
    }

    //marche !!!
    public boolean modifierUtilisateur(Utilisateur user){
        return userDAO.modifierUtilisateur(user);
    }

    //il marche aussi :)))))))))))))))))))
    public boolean supprimerUtilisateur(int matricule){
        return userDAO.supprimerUtilisateur(matricule);
    }

    //en fin marcheeerr
    public boolean changerPassword(int matricule, String ancienMotDePasse, String nouveauMotDePasse) {
        return userDAO.changePassword(matricule, ancienMotDePasse, nouveauMotDePasse);
    }

}