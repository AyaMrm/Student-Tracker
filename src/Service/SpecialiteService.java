// terminé !
package Service;

import Model.SpecialiteDAO;
import Model.Specialite;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class SpecialiteService {

    private final SpecialiteDAO specialiteDAO;

    public SpecialiteService(Connection cnx) {
        this.specialiteDAO = new SpecialiteDAO(cnx);
    }

    public boolean ajouterSpecialite(Specialite specialite) {
        if (specialite == null || specialite.getNomSpecialite() == null || specialite.getNomSpecialite().isEmpty()) {
            return false;
        }
        try {
            if (specialiteDAO.specialiteExiste(specialite.getIdSpecialite())) return false;
            return specialiteDAO.ajouterSpecialite(specialite);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean modifierSpecialite(Specialite specialite) {
        if (specialite == null || specialite.getIdSpecialite() <= 0) return false;
        try {
            if (!specialiteDAO.specialiteExiste(specialite.getIdSpecialite())) return false;
            return specialiteDAO.modifierSpecialite(specialite);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean supprimerSpecialite(int idSpecialite) {
        if (idSpecialite <= 0) return false;
        try {
            if (!specialiteDAO.specialiteExiste(idSpecialite)) return false;
            return specialiteDAO.supprimerSpecialite(idSpecialite);
        } catch (SQLException e) {
            return false;
        }
    }

    public Specialite getSpecialiteParId(int id) {
        if (id <= 0) return null;
        try {
            return specialiteDAO.getSpecialiteParId(id);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Specialite> getToutesLesSpecialites() {
        try {
            return specialiteDAO.getToutesLesSpecialites();
        } catch (SQLException e) {
            return null;
        }
    }
}
