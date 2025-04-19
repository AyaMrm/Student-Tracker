// terminé !
package Controller;

import Service.ProfModuleService;
import java.util.List;

public class ProfModuleController {

    private final ProfModuleService profModuleService;

    public ProfModuleController(ProfModuleService profModuleService) {
        this.profModuleService = profModuleService;
    }

    public boolean ajouterRelation(int idProf, int idModule) {
        return profModuleService.ajouterRelation(idProf, idModule);
    }

    public boolean supprimerRelation(int idProf, int idModule) {
        return profModuleService.supprimerRelation(idProf, idModule);
    }

    public List<Integer> getModulesParProf(int idProf) {
        return profModuleService.getModulesParProf(idProf);
    }

    public List<Integer> getProfsParModule(int idModule) {
        return profModuleService.getProfsParModule(idModule);
    }
}
