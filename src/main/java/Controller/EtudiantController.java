package Controller;

import java.util.List;
import Model.Etudiant;
import Service.EtudiantService;

public class EtudiantController {

	private EtudiantService etudiantService;

	public EtudiantController() {
		this.etudiantService = new EtudiantService();
	}
	
	public boolean etudiantExist(int matricule) {
	    return etudiantService.etudiantExist(matricule);
	}
	
	public void ajouterEtudiant(Etudiant etudiant) {
		etudiantService.ajouterEtudiant(etudiant);
	}
	
	public Etudiant getEtudiantByMat(int matricule) {
	    return etudiantService.getEtudiantByMat(matricule);
	}

	public List<Etudiant> getEtudiantByNom(String nom) {
	    return etudiantService.getEtudiantByNom(nom);
	}

	public List<Etudiant> getEtudiantBySpecialite(String specialite) {
	    return etudiantService.getEtudiantBySpecialite(specialite);
	}

	public List<Etudiant> getEtudiantBySection(String specialite, String section) {
	    return etudiantService.getEtudiantBySection(specialite, section);
	}

	public List<Etudiant> getEtudiantByGroupe(String specialite, String section, String groupe) {
	    return etudiantService.getEtudiantByGroupe(specialite, section, groupe);
	}

	
	public void modifierEtudiant(Etudiant etudiant) {
		etudiantService.modifierEtudiant(etudiant);
	}
	
	public void supprimerEtudiant(int idEtudiant) {
		etudiantService.supprimerEtudiant(idEtudiant);
	}
	
	public List<Etudiant> getAllEtudiands(){
		return etudiantService.getAllEtudiants();
	}
	
}
