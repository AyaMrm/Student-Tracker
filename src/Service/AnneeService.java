//Terminé !
package Service;

import Model.AnneeDAO;
import Model.Annee;
import java.sql.SQLException;
import java.util.List;


public class AnneeService {

    private final AnneeDAO anneeDAO;

    public AnneeService(AnneeDAO anneeDAO) {
        this.anneeDAO = anneeDAO;
    }

    public boolean ajouterAnnee(Annee annee) {
        if (annee == null || annee.getAnneeScolaire() == null || annee.getAnneeScolaire().isEmpty() || annee.getIdSpecialite() <= 0) {
            return false;
        }
        return anneeDAO.addAnnee(annee);
    }

    public boolean modifierAnnee(Annee annee) {
        if (annee == null || annee.getIdAnnee() <= 0 || annee.getAnneeScolaire() == null || annee.getAnneeScolaire().isEmpty()) {
            return false;
        }
        return anneeDAO.updateAnnee(annee);
    }

    public boolean supprimerAnnee(int idAnnee) {
        if (idAnnee <= 0) return false;
        return anneeDAO.deleteAnnee(idAnnee);
    }

    public Annee getAnneeById(int idAnnee) {
        if (idAnnee <= 0) return null;
        return anneeDAO.getAnneeById(idAnnee);
    }

    public List<Annee> getToutesLesAnneesTriees() {
        return anneeDAO.getAllAnneesSorted();
    }

    public Annee getAnneeAvecSemestres(int idAnnee) {
        if (idAnnee <= 0) return null;
        try {
            return anneeDAO.recupererAnneeAvecSemestres(idAnnee);
        } catch (SQLException e) {
            return null;
        }
    }
}
