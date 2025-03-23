package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmploiDuTempsDAO {
 private Connection connection;

public EmploiDuTempsDAO(Connection connection) {
	super();
	this.connection = connection;
}

//1
public boolean addEmploiDuTemps(EmploiDuTemps emploi) {
    // Vérifier si l'emploi du temps existe déjà par son ID
    if (emploiExists(emploi.getIdEmploiDuTemps())) {
        System.out.println("L'emploi du temps avec ID " + emploi.getIdEmploiDuTemps() + " existe déjà.");
        return false;
    }
    
    if (hasTimeConflict(emploi)) {
        System.out.println("Conflit d'horaires détecté pour la salle " + emploi.getSalle() + " à " + emploi.getJour());
        return false;
    }

    String query = "INSERT INTO emploisdutemps (idEmploiDuTemps, jour, heure_debut, heure_fin, salle, idModule, idProf, section, groupe, idAnnee) " +
                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, emploi.getIdEmploiDuTemps());
        statement.setString(2, emploi.getJour());
        statement.setTime(3, emploi.getHeureDebut());
        statement.setTime(4, emploi.getHeureFin());
        statement.setString(5, emploi.getSalle());
        statement.setInt(6, emploi.getIdModule());
        
        if (emploi.getIdProf() != null) {
            statement.setInt(7, emploi.getIdProf());
        } else {
            statement.setNull(7, Types.INTEGER);
        }
        
        statement.setString(8, emploi.getSection());
        statement.setString(9, emploi.getGroupe());
        statement.setInt(10, emploi.getIdAnnee());

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Emploi du temps ajouté avec succès !");
            return true;
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de l'ajout de l'emploi du temps : " + e.getMessage());
    }
    return false;
}
 
public boolean emploiExists(int idEmploiDuTemps) {
    String query = "SELECT COUNT(*) FROM emploisdutemps WHERE idEmploiDuTemps = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, idEmploiDuTemps);

        try (ResultSet resultSet = statement.executeQuery()) {
            return resultSet.next() && resultSet.getInt(1) > 0;
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la vérification de l'existence de l'emploi du temps : " + e.getMessage());
    }
    return false;
}

//2
public EmploiDuTemps getEmploiById(int idEmploiDuTemps) {
    String query = "SELECT * FROM emploisdutemps WHERE idEmploiDuTemps = ?";
    
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, idEmploiDuTemps);

        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return new EmploiDuTemps(
                        resultSet.getInt("idEmploiDuTemps"),
                        resultSet.getString("jour"),
                        resultSet.getTime("heure_debut"),
                        resultSet.getTime("heure_fin"),
                        resultSet.getString("salle"),
                        resultSet.getInt("idModule"),
                        resultSet.getObject("idProf") != null ? resultSet.getInt("idProf") : null,
                        resultSet.getString("section"),
                        resultSet.getString("groupe"),
                        resultSet.getInt("idAnnee")
                );
            }
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la récupération de l'emploi du temps : " + e.getMessage());
    }
    return null;
}

//3
public List<EmploiDuTemps> getAllEmplois() {
    List<EmploiDuTemps> emplois = new ArrayList<>();
    String query = "SELECT * FROM emploisdutemps ORDER BY jour ASC, heure_debut ASC";

    try (PreparedStatement statement = connection.prepareStatement(query);
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {
            EmploiDuTemps emploi = new EmploiDuTemps(
                    resultSet.getInt("idEmploiDuTemps"),
                    resultSet.getString("jour"),
                    resultSet.getTime("heure_debut"),
                    resultSet.getTime("heure_fin"),
                    resultSet.getString("salle"),
                    resultSet.getInt("idModule"),
                    resultSet.getObject("idProf") != null ? resultSet.getInt("idProf") : null,
                    resultSet.getString("section"),
                    resultSet.getString("groupe"),
                    resultSet.getInt("idAnnee")
            );
            emplois.add(emploi);
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la récupération des emplois du temps : " + e.getMessage());
    }
    return emplois;
}


//4
public boolean hasTimeConflict(EmploiDuTemps emploi) {
    String query = "SELECT COUNT(*) FROM emploisdutemps " +
                   "WHERE jour = ? AND salle = ? AND idEmploiDuTemps != ? " + 
                   "AND ((heure_debut BETWEEN ? AND ?) OR (heure_fin BETWEEN ? AND ?) OR " +
                   "(? BETWEEN heure_debut AND heure_fin) OR (? BETWEEN heure_debut AND heure_fin))";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, emploi.getJour());
        statement.setString(2, emploi.getSalle());
        statement.setInt(3, emploi.getIdEmploiDuTemps());
        statement.setTime(4, emploi.getHeureDebut());
        statement.setTime(5, emploi.getHeureFin());
        statement.setTime(6, emploi.getHeureDebut());
        statement.setTime(7, emploi.getHeureFin());
        statement.setTime(8, emploi.getHeureDebut());
        statement.setTime(9, emploi.getHeureFin());

        try (ResultSet resultSet = statement.executeQuery()) {
            return resultSet.next() && resultSet.getInt(1) > 0;
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la vérification des conflits d'horaires : " + e.getMessage());
    }
    return false;
}

//5
public boolean updateEmploiDuTemps(EmploiDuTemps emploi) {
    if (!emploiExists(emploi.getIdEmploiDuTemps())) {
        System.out.println("L'emploi du temps avec ID " + emploi.getIdEmploiDuTemps() + " n'existe pas.");
        return false;
    }

    if (hasTimeConflict(emploi)) {
        System.out.println("Conflit d'horaires détecté pour la salle " + emploi.getSalle() + " à " + emploi.getJour());
        return false;
    }

    String query = "UPDATE emploisdutemps SET jour = ?, heure_debut = ?, heure_fin = ?, salle = ?, idModule = ?, idProf = ?, section = ?, groupe = ?, idAnnee = ? " +
                   "WHERE idEmploiDuTemps = ?";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, emploi.getJour());
        statement.setTime(2, emploi.getHeureDebut());
        statement.setTime(3, emploi.getHeureFin());
        statement.setString(4, emploi.getSalle());
        statement.setInt(5, emploi.getIdModule());

        if (emploi.getIdProf() != null) {
            statement.setInt(6, emploi.getIdProf());
        } else {
            statement.setNull(6, Types.INTEGER);
        }

        statement.setString(7, emploi.getSection());
        statement.setString(8, emploi.getGroupe());
        statement.setInt(9, emploi.getIdAnnee());
        statement.setInt(10, emploi.getIdEmploiDuTemps());

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Emploi du temps mis à jour avec succès !");
            return true;
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la mise à jour de l'emploi du temps : " + e.getMessage());
    }
    return false;
}

//6
public boolean deleteEmploiDuTemps(int idEmploiDuTemps) {
    if (!emploiExists(idEmploiDuTemps)) {
        System.out.println("L'emploi du temps avec ID " + idEmploiDuTemps + " n'existe pas.");
        return false;
    }

    String query = "DELETE FROM emploisdutemps WHERE idEmploiDuTemps = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, idEmploiDuTemps);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Emploi du temps supprimé avec succès !");
            return true;
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la suppression de l'emploi du temps : " + e.getMessage());
    }
    return false;
}


}
