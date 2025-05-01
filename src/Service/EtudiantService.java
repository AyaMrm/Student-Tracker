package Service;

import Model.Etudiant;
import Model.EtudiantDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class EtudiantService {

    private final EtudiantDAO etudiantDAO;

    public EtudiantService(Connection cnx) {
        this.etudiantDAO = new EtudiantDAO(cnx);
    }

    public boolean etudiantExiste(int id) {
        if (id <= 0) return false;
        try {
            return etudiantDAO.etudiantExiste(id);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean ajouterEtudiant(Etudiant etd) {
        if (etd == null || etd.getIdEtudiant() <= 0) return false;
        try {
            if (etudiantDAO.etudiantExiste(etd.getIdEtudiant())) return false;
            return etudiantDAO.ajouterEtudiant(etd);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean modifierEtudiant(Etudiant etd) {
        if (etd == null || etd.getIdEtudiant() <= 0) return false;
        try {
            if (!etudiantDAO.etudiantExiste(etd.getIdEtudiant())) return false;
            return etudiantDAO.modifierEtudiant(etd);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean supprimerEtudiant(int id) {
        if (id <= 0) return false;
        try {
            return etudiantDAO.supprimerEtudiant(id);
        } catch (SQLException e) {
            return false;
        }
    }

    public Etudiant getEtudiantById(int id) {
        if (id <= 0) return null;
        try {
            return etudiantDAO.getEtudiantParId(id);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Etudiant> getAllEtudiants() {
        try {
            return etudiantDAO.getTousLesEtudiants();
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

    public List<Etudiant> getEtudiantByNom(String nom) {
        if (nom == null || nom.isEmpty()) return Collections.emptyList();
        try {
            return etudiantDAO.getEtudiantParNom(nom);
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

    public List<Etudiant> getEtudiantBySpecialite(int idSpecialite) {
        if (idSpecialite <= 0) return Collections.emptyList();
        try {
            return etudiantDAO.getEtudiantParSpecialite(idSpecialite);
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }
}