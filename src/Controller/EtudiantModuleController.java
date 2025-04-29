// terminé !
package Controller;

import Service.EtudiantModuleService;

import java.util.List;
public class EtudiantModuleController {

    private final EtudiantModuleService service;

    public EtudiantModuleController(EtudiantModuleService service) {
        this.service = service;
    }

    public boolean ajouterRelation(int idEtudiant, int idModule) {
        return service.ajouterRelation(idEtudiant, idModule);
    }

    public boolean supprimerRelation(int idEtudiant, int idModule) {
        return service.supprimerRelation(idEtudiant, idModule);
    }

    public boolean existeRelation(int idEtudiant, int idModule) {
        return service.existeRelation(idEtudiant, idModule);
    }

    public List<Integer> getModulesParEtudiant(int idEtudiant) {
        return service.getModulesParEtudiant(idEtudiant);
    }

    public List<Integer> getEtudiantsParModule(int idModule) {
        return service.getEtudiantsParModule(idModule);
    }
}
