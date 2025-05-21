package Controllers;
import Model.Jour;

import java.sql.Connection;
import java.util.List;

public class JourController {

    private final JourService jourService;

    public JourController(Connection cnx) {
        this.jourService = new JourService(cnx);
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