// Terminé !
package Controller;

import Model.EmploiDuTemps;
import Service.EmploiDuTempsService;

import java.util.List;

public class EmploiDuTempsController {

    private final EmploiDuTempsService emploiService;

    public EmploiDuTempsController(EmploiDuTempsService emploiService) {
        this.emploiService = emploiService;
    }

    public boolean ajouterEmploiDuTemps(EmploiDuTemps edt) {
        return emploiService.ajouterEmploiDuTemps(edt);
    }

    public boolean modifierEmploiDuTemps(EmploiDuTemps edt) {
        return emploiService.modifierEmploiDuTemps(edt);
    }

    public boolean supprimerEmploiDuTemps(int id) {
        return emploiService.supprimerEmploiDuTemps(id);
    }

    public EmploiDuTemps getEmploiParId(int id) {
        return emploiService.getEmploiParId(id);
    }

    public List<EmploiDuTemps> getTousLesEmploisDuTemps() {
        return emploiService.getTousLesEmploisDuTemps();
    }
}
