package Controllers;
import Model.Semestre;

import java.sql.Connection;
import java.util.List;

public class SemestreController {

    private final SemestreService semestreService;

    public SemestreController(Connection cnx) {
        this.semestreService = new SemestreService(cnx);
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