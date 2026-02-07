package Controllers;

import Model.Role;
import Model.Utilisateur;
import Model.UtilisateurDAO;

import java.sql.Connection;
import java.util.ArrayList;


public class UtilisateurService {

    private final UtilisateurDAO utilisateurDAO;

    public UtilisateurService(Connection cnx) {
        this.utilisateurDAO = new UtilisateurDAO(cnx);
    }

    public boolean utilisateurExiste(int idUser) {
        if (idUser <= 0) return false;
        return utilisateurDAO.existe(idUser);
    }

    public Utilisateur getUtilisateurByMat(int id) {
        if (id <= 0) return null;
        return utilisateurDAO.getUtilisateurByMat(id);
    }

    public ArrayList<Utilisateur> getUtilisateursByRole(String roleStr) {
        if (roleStr == null || roleStr.isEmpty()) return new ArrayList<>();
        try {
            Role role = Role.valueOf(roleStr.toUpperCase());
            return utilisateurDAO.getUtilisateursByRole(role);
        } catch (IllegalArgumentException e) {
            return new ArrayList<>(); // rôle non valide
        }
    }

    public ArrayList<Utilisateur> getUtilisateursByNom(String nom) {
        if (nom == null || nom.isEmpty()) return new ArrayList<>();
        return utilisateurDAO.getUtilisateurByNom(nom);
    }

    public ArrayList<Utilisateur> getAllUtilisateurs() {
        return utilisateurDAO.getAllUtilisateurs();
    }

    public boolean modifierUtilisateur(Utilisateur user) {
        if (user == null || user.getIdUser() <= 0) return false;
        return utilisateurDAO.modifierUtilisateur(user);
    }

    public boolean supprimerUtilisateur(int id) {
        if (id <= 0) return false;
        return utilisateurDAO.supprimerUtilisateur(id);
    }
}