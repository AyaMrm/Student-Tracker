package Service;

import Model.Role;
import Model.Utilisateur;
import Model.UtilisateurDAO;

import java.sql.Connection;
import java.util.ArrayList;

public class UtilisateurService {
    protected UtilisateurDAO utilisateurDAO;

    public UtilisateurService(Connection cnx){
        this.utilisateurDAO = new UtilisateurDAO(cnx);
    }

    public boolean existe(int idUser){
        try {
            return utilisateurDAO.existe(idUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Utilisateur getUserByMat(int id){
        return utilisateurDAO.getUtilisateurByMat(id);
    }

    public ArrayList<Utilisateur> getUserByRole(String roleStr){
        Role role = Role.valueOf(roleStr);
        return utilisateurDAO.getUtilisateursByRole(role);
    }

    public ArrayList<Utilisateur> getUserByNom(String nom){
        return utilisateurDAO.getUtilisateurByNom(nom);
    }

    public ArrayList<Utilisateur> getAllUsers(){
        return utilisateurDAO.getAllUtilisateurs();
    }

    public boolean modifierUser(Utilisateur user){
        return utilisateurDAO.modifierUtilisateur(user);
    }

    public boolean supprimerUser(int id){
        return utilisateurDAO.supprimerUtilisateur(id);
    }

}
