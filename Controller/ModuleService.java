// terminé !
package Controller;

import Model.ModuleDAO;
import Model.Module;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class ModuleService {

    private final ModuleDAO moduleDAO;

    public ModuleService(Connection cnx) {
        this.moduleDAO = new ModuleDAO(cnx);
    }

    public boolean ajouterModule(Module module) {
        if (module == null || module.getNom() == null || module.getNom().isEmpty()) {
            return false;
        }
        try {
            moduleDAO.ajouterModule(module);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean modifierModule(Module module) {
        try {
            moduleDAO.updateModule(module);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean supprimerModule(int idModule) {
        try {
            moduleDAO.supprimerModule(idModule);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public Module getModuleParId(int id) {
        try {
            return moduleDAO.getModuleById(id);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Module> getTousLesModules() {
        try {
            return moduleDAO.getAllModules();
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Module> getModulesParSpecialite(String idSpecialite) {
        try {
            return moduleDAO.getAllModulesBySpecialite(idSpecialite);
        } catch (SQLException e) {
            return null;
        }
    }
}
