// Terminé !
package Controller;

import Model.EmploiDuTemps;
import Controller.EmploiDuTempsService;

import java.sql.Connection;
import java.util.List;

public class EmploiDuTempsController {

    private final EmploiDuTempsService emploiService;

    public EmploiDuTempsController(Connection cnx) {
        this.emploiService = new EmploiDuTempsService(cnx);
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
