// terminé !
package Controller;

import java.sql.Connection;
import java.util.List;
import Model.Presence;
import Service.PresenceService;

public class PresenceController {
	
    private final PresenceService presenceService;

    public PresenceController(Connection cnx) {
        this.presenceService = new PresenceService(cnx);
    }

    public boolean ajouterPresence(Presence p) {
        return presenceService.ajouterPresence(p);
    }

    public boolean modifierPresence(Presence p) {
        return presenceService.modifierPresence(p);
    }

    public boolean supprimerPresence(int id) {
        return presenceService.supprimerPresence(id);
    }

    public Presence getPresenceParId(int id) {
        return presenceService.getPresenceParId(id);
    }

    public List<Presence> getPresenceParModule(int idModule) {
        return presenceService.getPresenceParModule(idModule);
    }

    public List<Presence> getPresencesParEtudiant(int idEtudiant) {
        return presenceService.getPresencesParEtudiant(idEtudiant);
    }
}
