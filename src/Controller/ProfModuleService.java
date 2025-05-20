// terminé !
package Controller;

import Model.ProfModuleDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class ProfModuleService {

    private final ProfModuleDAO profModuleDAO;

    public ProfModuleService(Connection cnx) {
        this.profModuleDAO = new ProfModuleDAO(cnx);
    }

    public boolean ajouterRelation(int idProf, int idModule) {
        if (idProf <= 0 || idModule <= 0) return false;

        try {
            return profModuleDAO.ajouterRelation(idProf, idModule);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean supprimerRelation(int idProf, int idModule) {
        if (idProf <= 0 || idModule <= 0) return false;

        try {
            return profModuleDAO.supprimerRelation(idProf, idModule);
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Integer> getModulesParProf(int idProf) {
        try {
            return profModuleDAO.getModulesParProf(idProf);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Integer> getProfsParModule(int idModule) {
        try {
            return profModuleDAO.getProfsParModule(idModule);
        } catch (SQLException e) {
            return null;
        }
    }
}
