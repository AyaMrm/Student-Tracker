// terminé !
package Controller;

import Model.JourDAO;
import Model.Jour;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class JourService {

    private final JourDAO jourDAO;

    public JourService(Connection cnx) {
        this.jourDAO = new JourDAO(cnx);
    }

    public boolean ajouterJour(Jour jour) {
        if (jour == null || jour.getJour() == null) {
            return false;
        }
        try {
            return jourDAO.ajouterJour(jour);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean modifierJour(Jour jour) {
        try {
            return jourDAO.modifierJour(jour);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean supprimerJour(int idJour) {
        try {
            return jourDAO.supprimerJour(idJour);
        } catch (SQLException e) {
            return false;
        }
    }

    public Jour getJourParId(int idJour) {
        try {
            return jourDAO.getJourParId(idJour);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Jour> getTousLesJours() {
        try {
            return jourDAO.getTousLesJours();
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
            return null;
        }
    }
}
