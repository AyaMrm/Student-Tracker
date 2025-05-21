package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PresenceDAO {
	 private Connection connection;

	    public PresenceDAO(Connection connection) {
	        this.connection = connection;
	    }
	    
	    private boolean presenceExiste(Date date, Time heure, int idEtudiant, int idModule) throws SQLException {
	        String sql = "SELECT idPresence FROM presence WHERE datePresence = ? AND heure = ? AND idEtudiant = ? AND idModule = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setDate(1, date);
	            stmt.setTime(2, heure);
	            stmt.setInt(3, idEtudiant);
	            stmt.setInt(4, idModule);
	            ResultSet rs = stmt.executeQuery();
	            return rs.next();
	        }
	    }

	    public boolean ajouterPresence(Presence p) throws SQLException {
	        if (presenceExiste(p.getDatePresence(), p.getHeure(), p.getIdEtudiant(), p.getIdModule())) return false;

	        String sql = "INSERT INTO presence (idPresence, statut, heure, datePresence, idEtudiant, idModule, idProf) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, p.getIdPresence());
	            stmt.setString(2, p.getStatut().name());
	            stmt.setTime(3, p.getHeure());
	            stmt.setDate(4, p.getDatePresence());
	            stmt.setInt(5, p.getIdEtudiant());
	            stmt.setInt(6, p.getIdModule());
	            stmt.setInt(7, p.getIdProf());
	            return stmt.executeUpdate() > 0;
	        }
	    }

	    public boolean modifierPresence(Presence p) throws SQLException {
	        if (!presenceExiste(p.getDatePresence(), p.getHeure(), p.getIdEtudiant(), p.getIdModule())) return false;

	        String sql = "UPDATE presence SET statut=?, heure=?, datePresence=?, idEtudiant=?, idModule=?, idProf=? WHERE idPresence=?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setString(1, p.getStatut().name());
	            stmt.setTime(2, p.getHeure());
	            stmt.setDate(3, p.getDatePresence());
	            stmt.setInt(4, p.getIdEtudiant());
	            stmt.setInt(5, p.getIdModule());
	            stmt.setInt(6, p.getIdProf());
	            stmt.setInt(7, p.getIdPresence());
	            return stmt.executeUpdate() > 0;
	        }
	    }

	    public boolean supprimerPresence(int id) throws SQLException {
	        Presence presence = getPresenceParId(id);
	        if (presence == null || !presenceExiste(presence.getDatePresence(), presence.getHeure(), presence.getIdEtudiant(), presence.getIdModule()))
	            return false;

	        String sql = "DELETE FROM presence WHERE idPresence=?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, id);
	            return stmt.executeUpdate() > 0;
	        }
	    }

	    public Presence getPresenceParId(int id) throws SQLException {
	        String sql = "SELECT * FROM presence WHERE idPresence=?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, id);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return new Presence(
	                    rs.getInt("idPresence"),
	                    StatutPresence.valueOf(rs.getString("statut")),
	                    rs.getTime("heure"),
	                    rs.getDate("datePresence"),
	                    rs.getInt("idEtudiant"),
	                    rs.getInt("idModule"),
	                    rs.getInt("idProf")
	                );
	            }
	        }
	        return null;
	    }

	    public List<Presence> getPresenceParModule(int idModule) throws SQLException {
	        String sql = "SELECT * FROM presence WHERE idModule=?";
	        List<Presence> liste = new ArrayList<>();
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, idModule);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                liste.add(new Presence(
	                    rs.getInt("idPresence"),
	                    StatutPresence.valueOf(rs.getString("statut")),
	                    rs.getTime("heure"),
	                    rs.getDate("datePresence"),
	                    rs.getInt("idEtudiant"),
	                    rs.getInt("idModule"),
	                    rs.getInt("idProf")
	                ));
	            }
	        }
	        return liste;
	    }

	    public List<Presence> getPresencesParEtudiant(int idEtudiant) throws SQLException {
	        String sql = "SELECT * FROM presence WHERE idEtudiant=?";
	        List<Presence> liste = new ArrayList<>();
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, idEtudiant);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                liste.add(new Presence(
	                    rs.getInt("idPresence"),
	                    StatutPresence.valueOf(rs.getString("statut")),
	                    rs.getTime("heure"),
	                    rs.getDate("datePresence"),
	                    rs.getInt("idEtudiant"),
	                    rs.getInt("idModule"),
	                    rs.getInt("idProf")
	                ));
	            }
	        }
	        return liste;
	    }
}
