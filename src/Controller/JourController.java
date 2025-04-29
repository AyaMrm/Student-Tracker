// terminé !
package Controller;

import Model.Jour;
import Service.JourService;

import java.util.List;

public class JourController {

    private final JourService jourService;

    public JourController(JourService jourService) {
        this.jourService = jourService;
    }

    public boolean ajouterJour(Jour jour) {
        return jourService.ajouterJour(jour);
    }

    public boolean modifierJour(Jour jour) {
        return jourService.modifierJour(jour);
    }

    public boolean supprimerJour(int idJour) {
        return jourService.supprimerJour(idJour);
    }

    public Jour getJourParId(int idJour) {
        return jourService.getJourParId(idJour);
    }

    public List<Jour> getTousLesJours() {
        return jourService.getTousLesJours();
    }
}
