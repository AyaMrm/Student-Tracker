package Controllers;

import Model.SeanceDAO;
import Model.Seance;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class SeanceService {

    private final SeanceDAO seanceDAO;

    public SeanceService(Connection cnx) {
        this.seanceDAO = new SeanceDAO(cnx);
    }

    public boolean ajouterSeance(Seance seance) {
        if (seance == null || seance.getDebutSeance() == null || seance.getFinSeance() == null || seance.getSalle() == null) {
            return false;
        }
        try {
            return seanceDAO.ajouterSeance(seance);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean modifierSeance(Seance seance) {
        if (seance == null || seance.getIdSeance() <= 0) {
            return false;
        }
        try {
            return seanceDAO.modifierSeance(seance);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean supprimerSeance(int idSeance) {
        if (idSeance <= 0) return false;
        try {
            return seanceDAO.supprimerSeance(idSeance);
        } catch (SQLException e) {
            return false;
        }
    }

    public Seance getSeanceParId(int idSeance) {
        if (idSeance <= 0) return null;
        try {
            return seanceDAO.getSeanceParId(idSeance);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Seance> getToutesLesSeances() {
        try {
            return seanceDAO.getToutesLesSeances();
        } catch (SQLException e) {
            return null;
        }
    }
}