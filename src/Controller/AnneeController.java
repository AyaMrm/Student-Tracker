// terminé : 
package Controller;

import Model.Annee;
import Service.AnneeService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AnneeController {

    private final AnneeService anneeService;

    public AnneeController(Connection cnx) {
        this.anneeService = new AnneeService(cnx);
    }

    public boolean ajouterAnnee(Annee annee) {
        return anneeService.ajouterAnnee(annee);
    }

    public boolean supprimerAnnee(int idAnnee) {
        return anneeService.supprimerAnnee(idAnnee);
    }

    public boolean modifierAnnee(Annee annee) {
        return anneeService.modifierAnnee(annee);
    }

    public Annee getAnneeById(int idAnnee) {
        return anneeService.getAnneeById(idAnnee);
    }

    public List<Annee> getAllAnneesTriees() {
        return anneeService.getToutesLesAnneesTriees();
    }

    public Annee getAnneeAvecSemestres(int idAnnee){
        return anneeService.getAnneeAvecSemestres(idAnnee);
    }
 
}
