package Controller;
import java.util.List;
import Model.Presence;
import Service.PresenceService;

public class PresenceController {
	private PresenceService presenceService;
	
	public PresenceController() {
		this.presenceService = new PresenceService();
	}
	
	public void marquerPresence(Presence presence) {
		presenceService.marquerPresence(presence);
	}
	
	public void modifierPresence(int idPresence, String nouveauStatut) {
		presenceService.modifierPresence(idPresence, nouveauStatut);
	}
	
	public void supprimerPresence(int idPresence) {
		presenceService.supprimerPresence(idPresence);
	}
	
	public List<Presence> getPresencesParEtudiant(int idEtudiant){
		return presenceService.getPresencesParEtudiant(idEtudiant);
	}
}
