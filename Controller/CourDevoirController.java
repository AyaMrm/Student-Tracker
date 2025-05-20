// terminé !
package Controller;

import Model.CourDevoir;
import Controller.CourDevoirService;

import java.sql.Connection;
import java.util.List;

public class CourDevoirController {
	
    private final CourDevoirService courDevoirService;

    public CourDevoirController(Connection cnx) {
        this.courDevoirService = new CourDevoirService(cnx);
    }

    public boolean ajouterCourDevoir(CourDevoir cd) {
        return courDevoirService.ajouterCourDevoir(cd);
    }

    public boolean modifierCourDevoir(CourDevoir cd) {
        return courDevoirService.modifierCourDevoir(cd);
    }

    public boolean supprimerCourDevoir(int id) {
        return courDevoirService.supprimerCourDevoir(id);
    }

    public CourDevoir getCourPdfParId(int id) {
        return courDevoirService.getCourPdfParId(id);
    }

    public List<CourDevoir> getCourDevoirParModuleEtProf(int idModule, int idProf) {
        return courDevoirService.getCourDevoirParModuleEtProf(idModule, idProf);
    }

    public List<CourDevoir> getCourDevoirDoneParEtudiant(int idEtudiant) {
        return courDevoirService.getCourDevoirDoneParEtudiant(idEtudiant);
    }
}
