// terminé ! 
package Controller;

import Model.Specialite;
import Service.SpecialiteService;

import java.sql.Connection;
import java.util.List;


public class SpecialiteController {

    private final SpecialiteService specialiteService;

    public SpecialiteController(Connection cnx) {
        this.specialiteService = new SpecialiteService(cnx);
    }

    public boolean ajouterSpecialite(Specialite s) {
        return specialiteService.ajouterSpecialite(s);
    }

    public boolean modifierSpecialite(Specialite s) {
        return specialiteService.modifierSpecialite(s);
    }

    public boolean supprimerSpecialite(int id) {
        return specialiteService.supprimerSpecialite(id);
    }

    public Specialite getSpecialiteParId(int id) {
        return specialiteService.getSpecialiteParId(id);
    }

    public List<Specialite> getToutesLesSpecialites() {
        return specialiteService.getToutesLesSpecialites();
    }
}
