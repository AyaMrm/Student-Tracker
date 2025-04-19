// terminé !
package Service;

import Model.PresenceDAO;
import Model.Presence;
import java.util.List;
import java.sql.SQLException;


public class PresenceService {

    private final PresenceDAO presenceDAO;

    public PresenceService(PresenceDAO presenceDAO) {
        this.presenceDAO = presenceDAO;
    }

    public boolean ajouterPresence(Presence p) {
        if (p == null || p.getStatut() == null || p.getDatePresence() == null || p.getHeure() == null) return false;

        try {
            return presenceDAO.ajouterPresence(p);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean modifierPresence(Presence p) {
        if (p == null || p.getIdPresence() <= 0) return false;

        try {
            return presenceDAO.modifierPresence(p);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean supprimerPresence(int id) {
        if (id <= 0) return false;

        try {
            return presenceDAO.supprimerPresence(id);
        } catch (SQLException e) {
            return false;
        }
    }

    public Presence getPresenceParId(int id) {
        if (id <= 0) return null;

        try {
            return presenceDAO.getPresenceParId(id);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Presence> getPresenceParModule(int idModule) {
        try {
            return presenceDAO.getPresenceParModule(idModule);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Presence> getPresencesParEtudiant(int idEtudiant) {
        try {
            return presenceDAO.getPresencesParEtudiant(idEtudiant);
        } catch (SQLException e) {
            return null;
        }
    }
}
