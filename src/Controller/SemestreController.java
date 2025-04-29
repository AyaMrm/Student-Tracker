// terminé !
package Controller;

import Model.Semestre;
import Service.SemestreService;
import java.util.List;

public class SemestreController {

    private final SemestreService semestreService;

    public SemestreController(SemestreService semestreService) {
        this.semestreService = semestreService;
    }

    public boolean ajouterSemestre(Semestre semestre) {
        return semestreService.ajouterSemestre(semestre);
    }

    public boolean modifierSemestre(Semestre semestre) {
        return semestreService.modifierSemestre(semestre);
    }

    public boolean supprimerSemestre(int idSemestre, int idAnnee) {
        return semestreService.supprimerSemestre(idSemestre, idAnnee);
    }

    public Semestre getSemestreById(int id) {
        return semestreService.getSemestreById(id);
    }

    public List<Semestre> getAllSemestres() {
        return semestreService.getAllSemestres();
    }
}
