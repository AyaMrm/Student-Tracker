package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class JourDAO {
	
	    private Connection connection;
	    private SeanceDAO seanceDAO; // les senace d'une seule journee

	    public JourDAO(Connection connection) {
	        this.connection = connection;
	        this.seanceDAO = new SeanceDAO(connection);
	    }

	    // Vérifier si un jour existe par ID
	    public boolean jourExiste(int idJour) throws SQLException {
	        String sql = "SELECT COUNT(*) FROM jours WHERE idJour = ?";
	        try (PreparedStatement ps = connection.prepareStatement(sql)) {
	            ps.setInt(1, idJour);
	            try (ResultSet rs = ps.executeQuery()) {
	                return rs.next() && rs.getInt(1) > 0;
	            }
	        }
	    }

	    // Ajouter un jour
	    public boolean ajouterJour(Jour jour) throws SQLException {
	        if (jourExiste(jour.getIdJour())) {
	            System.out.println(" Le jour existe déjà : " + jour.getIdJour());
	            return false;
	        }

	        String sql = "INSERT INTO jours (idJour, jour) VALUES (?, ?)";
	        try (PreparedStatement ps = connection.prepareStatement(sql)) {
	            ps.setInt(1, jour.getIdJour());
	            ps.setString(2, jour.getJour().name());
	            return ps.executeUpdate() > 0;
	        }
	    }

	    // Modifier un jour
	    public boolean modifierJour(Jour jour) throws SQLException {
	        if (!jourExiste(jour.getIdJour())) {
	            System.out.println(" Impossible de modifier : jour inexistant.");
	            return false;
	        }

	        String sql = "UPDATE jours SET jour = ? WHERE idJour = ?";
	        try (PreparedStatement ps = connection.prepareStatement(sql)) {
	            ps.setString(1, jour.getJour().name());
	            ps.setInt(2, jour.getIdJour());
	            return ps.executeUpdate() > 0;
	        }
	    }

	    // Supprimer un jour
	    public boolean supprimerJour(int idJour) throws SQLException {
	        if (!jourExiste(idJour)) {
	            System.out.println(" Le jour à supprimer n'existe pas.");
	            return false;
	        }

	        String sql = "DELETE FROM jours WHERE idJour = ?";
	        try (PreparedStatement ps = connection.prepareStatement(sql)) {
	            ps.setInt(1, idJour);
	            return ps.executeUpdate() > 0;
	        }
	    }

	    // Récupérer un jour par son ID
	    public Jour getJourParId(int idJour) throws SQLException {
	        String sql = "SELECT * FROM jours WHERE idJour = ?";
	        try (PreparedStatement ps = connection.prepareStatement(sql)) {
	            ps.setInt(1, idJour);
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    JourSemaine jourSemaine = JourSemaine.valueOf(rs.getString("jour"));
	                    List<Seance> seances = seanceDAO.getToutesLesSeances(); // à filtrer si nécessaire
	                    List<Seance> seancesDuJour = new ArrayList<>();
	                    for (Seance s : seances) {
	                        if (s.getIdJour() == idJour) {
	                            seancesDuJour.add(s);
	                        }
	                    }
	                    return new Jour(idJour, jourSemaine, seancesDuJour);
	                }
	            }
	        }
	        return null;
	    }

	    // Récupérer tous les jours
	    public List<Jour> getTousLesJours() throws SQLException {
	        List<Jour> jours = new ArrayList<>();
	        String sql = "SELECT * FROM jours";
	        try (PreparedStatement ps = connection.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            List<Seance> toutesLesSeances = seanceDAO.getToutesLesSeances();

	            while (rs.next()) {
	                int idJour = rs.getInt("idJour");
	                JourSemaine jourSemaine = JourSemaine.valueOf(rs.getString("jour"));

	                // Filtrer les séances du jour
	                List<Seance> seancesJour = new ArrayList<>();
	                for (Seance s : toutesLesSeances) {
	                    if (s.getIdJour() == idJour) {
	                        seancesJour.add(s);
	                    }
	                }

	                jours.add(new Jour(idJour, jourSemaine, seancesJour));
	            }
	        }
	        return jours;
	    }
}
