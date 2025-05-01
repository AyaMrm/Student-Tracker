// Terminé !
package Service;

import Model.EmploiDuTempsDAO;
import Model.EmploiDuTemps;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class EmploiDuTempsService {

    private final EmploiDuTempsDAO emploiDAO;

    public EmploiDuTempsService(Connection cnx) {
        this.emploiDAO = new EmploiDuTempsDAO(cnx);
    }

    public boolean ajouterEmploiDuTemps(EmploiDuTemps edt) {
        if (edt == null || edt.getSpecialite() == null || edt.getSection() == null || edt.getGroupe() == null) {
            return false;
        }
        try {
            return emploiDAO.ajouterEmploiDuTemps(edt);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean modifierEmploiDuTemps(EmploiDuTemps edt) {
        try {
            return emploiDAO.modifierEmploiDuTemps(edt);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean supprimerEmploiDuTemps(int id) {
        try {
            return emploiDAO.supprimerEmploiDuTemps(id);
        } catch (SQLException e) {
            return false;
        }
    }

    public EmploiDuTemps getEmploiParId(int id) {
        try {
            return emploiDAO.getEmploiDuTempsParId(id);
        } catch (SQLException e) {
            return null;
        }
    }
    
    public List<EmploiDuTemps> getTousLesEmploisDuTemps() {
        try {
            return emploiDAO.getTousLesEmploisDuTemps();
        } catch (SQLException e) {
            return null;
        }
    }
}
