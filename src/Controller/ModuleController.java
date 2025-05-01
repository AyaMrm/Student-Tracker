// terminé !
package Controller;

import Model.Module;
import Service.ModuleService;

import java.sql.Connection;
import java.util.List;


public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController(Connection cnx) {
        this.moduleService = new ModuleService(cnx);
    }

    public boolean ajouterModule(Module module) {
        return moduleService.ajouterModule(module);
    }

    public boolean modifierModule(Module module) {
        return moduleService.modifierModule(module);
    }

    public boolean supprimerModule(int id) {
        return moduleService.supprimerModule(id);
    }

    public Module getModuleParId(int id) {
        return moduleService.getModuleParId(id);
    }

    public List<Module> getTousLesModules() {
        return moduleService.getTousLesModules();
    }

    public List<Module> getModulesParSpecialite(String idSpecialite) {
        return moduleService.getModulesParSpecialite(idSpecialite);
    }
}
