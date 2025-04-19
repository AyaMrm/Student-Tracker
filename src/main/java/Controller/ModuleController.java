// terminé !
package Controller;

import Model.Module;
import Service.ModuleService;

import java.util.List;


public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
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
