// terminé !
package Controller;

import Model.Seance;
import Service.SeanceService;
import java.util.List;

public class SeanceController {

    private final SeanceService seanceService;

    public SeanceController(SeanceService seanceService) {
        this.seanceService = seanceService;
    }

    public boolean ajouterSeance(Seance seance) {
        return seanceService.ajouterSeance(seance);
    }

    public boolean modifierSeance(Seance seance) {
        return seanceService.modifierSeance(seance);
    }

    public boolean supprimerSeance(int idSeance) {
        return seanceService.supprimerSeance(idSeance);
    }

    public Seance getSeanceParId(int idSeance) {
        return seanceService.getSeanceParId(idSeance);
    }

    public List<Seance> getToutesLesSeances() {
        return seanceService.getToutesLesSeances();
    }
}
