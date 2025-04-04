package Controller;

import java.util.List;
import Model.CoursDevoirs;
import Service.CoursService;

public class CoursController {
	
	private final CoursService coursService;
	
	public CoursController() {
		this.coursService = new CoursService();
	}
	
	public void ajouterCours(CoursDevoirs cours) {
		coursService.ajouterCours(cours);
	}
	
	public void modifierCours(CoursDevoirs cours) {
		coursService.modifierCours(cours);
	}
	
	public void supprimerCours(int idCoursDevoirs) {
		coursService.supprimerCours(idCoursDevoirs);
	}
	
	public void marquerDevoirFait(int idCoursDevoirs) {
		coursService.marquerDevoirFait(idCoursDevoirs);
	}
	
	public List<CoursDevoirs> getAllCours() {
		return coursService.getAllCours();
	}
	
	public List<CoursDevoirs> getCoursParEtudiant(int idEtudiant){
		return coursService.getCoursParEtudiant(idEtudiant);
	}
	
	public List<CoursDevoirs> getCoursParProf(int idProf){
		return coursService.getCoursParProf(idProf);
	}
}
