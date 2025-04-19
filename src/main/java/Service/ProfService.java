// terminé !
package Service;

import Model.Prof;
import Model.ProfDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProfService {

    private final ProfDAO profDAO;

    public ProfService(Connection cnx) {
        this.profDAO = new ProfDAO(cnx);
    }

    public boolean profExiste(int id) {
        if (id <= 0) return false;
        try {
            return profDAO.existe(id);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean ajouterProf(Prof prof) {
        if (prof == null || prof.getMatricule() <= 0) return false;
        try {
            if (profDAO.existe(prof.getMatricule())) return false;
            return profDAO.ajouterProf(prof);
        } catch (SQLException e) {
            return false;
        }
    }

    public Prof getProfByMat(int id) {
        if (id <= 0) return null;
        try {
            return profDAO.getProfByMat(id);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Prof> getProfByNom(String nom) {
        if (nom == null || nom.isEmpty()) return Collections.emptyList();
        try {
            return profDAO.getProfsByNom(nom);
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

    public List<Prof> getProfBySpecialite(String specialite) {
        if (specialite == null || specialite.isEmpty()) return Collections.emptyList();
        try {
            return profDAO.getProfBySpecialite(specialite);
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

    public List<Prof> getProfByGrade(String grade) {
        if (grade == null || grade.isEmpty()) return Collections.emptyList();
        try {
            return profDAO.getProfByGrade(grade);
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

    public List<Prof> getProfByDepartement(String dep) {
        if (dep == null || dep.isEmpty()) return Collections.emptyList();
        try {
            return profDAO.getProfByDepartement(dep);
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

    public boolean modifierProf(Prof prof) {
        if (prof == null || prof.getMatricule() <= 0) return false;
        try {
            if (!profDAO.existe(prof.getMatricule())) return false;
            return profDAO.modifierProf(prof);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean supprimerProf(int id) {
        if (id <= 0) return false;
        try {
            return profDAO.supprimerProf(id);
        } catch (SQLException e) {
            return false;
        }
    }
}
