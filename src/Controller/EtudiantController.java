package Controller;

import java.util.List;
import Model.Etudiant;
import Service.EtudiantService;

public class EtudiantController {

	private EtudiantService etudiantService;

	public EtudiantController() {
		this.etudiantService = new EtudiantService();
	}
	
	public void ajouterEtudiant(Etudiant etudiant) {
		etudiantService.ajouterEtudiant(etudiant);
	}
	
	public void modifierEtudiant(Etudiant etudiant) {
		etudiantService.modifierEtudiant(etudiant);
	}
	
	public void supprimerEtudiant(int idEtudiant) {
		etudiantService.supprimerEtudiant(idEtudiant);
	}
	
	public Etudiant getEtudiant(int idEtudiant) {
		return etudiantService.getEtudiant(idEtudiant);
	}
	
	public List<Etudiant> getAllEtudiands(){
		return etudiantService.getAllEtudiants();
	}
	
}
