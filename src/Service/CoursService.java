package Service;

import Model.CoursDAO;
import Model.CoursDevoirs;
import java.util.List;

public class CoursService {
	
	private CoursDAO coursDAO;
	
	public CoursService() {
		this.coursDAO = new CoursDAO();
	}
	
    public void ajouterCours(CoursDevoirs cours) {
        if (cours.getMessage().isEmpty()) {
            throw new IllegalArgumentException("Le nom du cours ne peut pas être vide !");
        }
        coursDAO.ajouterCours(cours);
    }
    public void modifierCours(CoursDevoirs cours) {
        coursDAO.modifierCours(cours);
    }
    
    public void marquerDevoirFait(int idCoursDevoirs) {
    	boolean existe = coursDAO.verifierDevoirExiste(idCoursDevoirs);
    	if(!existe) {
    		throw new IllegalArgumentException("Le devoir avec l'id " + idCoursDevoirs + " n'existe pas ! ");
    	}
    	coursDAO.marquerDevoirFait(idCoursDevoirs);
    }
    
    public void supprimerCours(int idCoursDevoirs) {
        coursDAO.supprimerCours(idCoursDevoirs);
    }

    public List<CoursDevoirs> getAllCours() {
        return coursDAO.getAllCours();
    }

    public List<CoursDevoirs> getCoursParEtudiant(int idEtudiant) {
        return coursDAO.getCoursParEtudiant(idEtudiant);
    }

    public List<CoursDevoirs> getCoursParProf(int idProf) {
        return coursDAO.getCoursParProfesseur(idProf);
    }
}
