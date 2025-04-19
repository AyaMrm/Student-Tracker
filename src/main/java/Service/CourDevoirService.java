//terminé !
package Service;

import Model.CourDevoirDAO;
import Model.CourDevoir;
import java.util.List;
import java.sql.SQLException;

public class CourDevoirService {
	
    private final CourDevoirDAO courDevoirDAO;

    public CourDevoirService(CourDevoirDAO courDevoirDAO) {
        this.courDevoirDAO = courDevoirDAO;
    }

    public boolean ajouterCourDevoir(CourDevoir cd) {
        if (cd == null || cd.getMessage() == null || cd.getType() == null) return false;

        try {
            return courDevoirDAO.ajouterCourDevoir(cd);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean modifierCourDevoir(CourDevoir cd) {
        if (cd == null || cd.getIdCoursDevoirs() <= 0) return false;

        try {
            return courDevoirDAO.modifierCourDevoir(cd);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean supprimerCourDevoir(int id) {
        if (id <= 0) return false;

        try {
            return courDevoirDAO.supprimerCourDevoir(id);
        } catch (SQLException e) {
            return false;
        }
    }

    public CourDevoir getCourPdfParId(int id) {
        if (id <= 0) return null;

        try {
            return courDevoirDAO.getCourPdfParId(id);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<CourDevoir> getCourDevoirParModuleEtProf(int idModule, int idProf) {
        try {
            return courDevoirDAO.getCourDevoirParModuleEtProf(idModule, idProf);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<CourDevoir> getCourDevoirDoneParEtudiant(int idEtudiant) {
        try {
            return courDevoirDAO.getCourDevoirDoneParEtudiant(idEtudiant);
        } catch (SQLException e) {
            return null;
        }
    }
}
