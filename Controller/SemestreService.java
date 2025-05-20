// terminé !
package Controller;

import Model.SemestreDAO;
import Model.Semestre;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SemestreService {

    private final SemestreDAO semestreDAO;

    public SemestreService(Connection cnx) {
        this.semestreDAO = new SemestreDAO(cnx);
    }

    public boolean ajouterSemestre(Semestre semestre) {
        if (semestre == null || semestre.getIdAnnee() <= 0 || semestre.getNumero() == null) return false;

        try {
            if (!semestreDAO.anneeExiste(semestre.getIdAnnee())) return false;
            if (semestreDAO.nombreDeSemestres(semestre.getIdAnnee()) >= 2) return false;
            semestreDAO.ajouterSemestre(semestre);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean modifierSemestre(Semestre semestre) {
        if (semestre == null || semestre.getIdSemestre() <= 0) return false;

        try {
            if (!semestreDAO.anneeExiste(semestre.getIdAnnee())) return false;
            semestreDAO.updateSemestre(semestre);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean supprimerSemestre(int idSemestre, int idAnnee) {
        if (idSemestre <= 0 || idAnnee <= 0) return false;

        try {
            if (!semestreDAO.anneeExiste(idAnnee)) return false;
            if (semestreDAO.nombreDeSemestres(idAnnee) <= 2) return false;
            semestreDAO.deleteSemestre(idSemestre, idAnnee);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public Semestre getSemestreById(int id) {
        try {
            return semestreDAO.getSemestreById(id);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Semestre> getAllSemestres() {
        try {
            return semestreDAO.getAllSemestres();
        } catch (SQLException e) {
            return null;
        }
    }
}
