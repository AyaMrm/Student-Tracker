// terminé !
package Controller;

import Model.Prof;
import Service.ProfService;

import java.sql.Connection;
import java.util.List;

public class ProfController {

    private final ProfService profService;

    public ProfController(Connection cnx) {
        this.profService = new ProfService(cnx);
    }

    public boolean ajouterProf(Prof prof) {
        return profService.ajouterProf(prof);
    }

    public boolean modifierProf(Prof prof) {
        return profService.modifierProf(prof);
    }

    public boolean supprimerProf(int id) {
        return profService.supprimerProf(id);
    }

    public Prof getProfByMat(int id) {
        return profService.getProfByMat(id);
    }

    public List<Prof> getProfByNom(String nom) {
        return profService.getProfByNom(nom);
    }

    public List<Prof> getProfBySpecialite(String specialite) {
        return profService.getProfBySpecialite(specialite);
    }

    public List<Prof> getProfByGrade(String grade) {
        return profService.getProfByGrade(grade);
    }

    public List<Prof> getProfByDepartement(String departement) {
        return profService.getProfByDepartement(departement);
    }

    public boolean profExiste(int id) {
        return profService.profExiste(id);
    }
}
