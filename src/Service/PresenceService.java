package Service;

import Model.PresenceDAO;
import Model.Presence;
import java.util.List;

public class PresenceService {

	private PresenceDAO presenceDAO;

    public PresenceService() {
        this.presenceDAO = new PresenceDAO();
    }

    public void marquerPresence(Presence presence) {
        presenceDAO.marquerPresence(presence);
    }

    public void modifierPresence(int idPresence, String nouveauStatut) {
        if (!nouveauStatut.equals("Présent") && !nouveauStatut.equals("Absent") && !nouveauStatut.equals("Justifié")) {
            throw new IllegalArgumentException("Statut invalide !");
        }
        presenceDAO.modifierPresence(idPresence, nouveauStatut);
    }

    public void supprimerPresence(int idPresence) {
        presenceDAO.supprimerPresence(idPresence);
    }

    public List<Presence> getPresencesParEtudiant(int idEtudiant) {
        return presenceDAO.getPresencesParEtudiant(idEtudiant);
    }
}
