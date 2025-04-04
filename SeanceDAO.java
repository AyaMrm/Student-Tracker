package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeanceDAO {
private Connection  connection;

public SeanceDAO(Connection connection) {
	super();
	this.connection = connection;
}

// Vérifie si une séance existe déjà par ID
public boolean seanceExiste(int idSeance) throws SQLException {
    String sql = "SELECT COUNT(*) FROM seances WHERE idSeance = ?";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, idSeance);
        try (ResultSet rs = ps.executeQuery()) {
            return rs.next() && rs.getInt(1) > 0;
        }
    }
}

//Ajouter une séance
public boolean ajouterSeance(Seance seance) throws SQLException {
    if (seanceExiste(seance.getIdSeance())) {
        System.out.println("Séance déjà existante avec l'ID : " + seance.getIdSeance());
        return false;
    }

    String sql = "INSERT INTO seances (idSeance, heure_debut, heure_fin, idModule, idProf, salle, idJour) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, seance.getIdSeance());
        ps.setTime(2, Time.valueOf(seance.getDebutSeance()));
        ps.setTime(3, Time.valueOf(seance.getFinSeance()));
        ps.setInt(4, seance.getIdModule());
        ps.setInt(5, seance.getIdProf());
        ps.setString(6, "Salle par défaut"); // à modifier selon ton modèle
        ps.setInt(7, seance.getIdJour());

        return ps.executeUpdate() > 0;
    }
}

//Modifier une séance
public boolean modifierSeance(Seance seance) throws SQLException {
    if (!seanceExiste(seance.getIdSeance())) {
        System.out.println(" Impossible de modifier : la séance n'existe pas.");
        return false;
    }

    String sql = "UPDATE seances SET heure_debut = ?, heure_fin = ?, idModule = ?, idProf = ?, salle = ?, idJour = ? WHERE idSeance = ?";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setTime(1, Time.valueOf(seance.getDebutSeance()));
        ps.setTime(2, Time.valueOf(seance.getFinSeance()));
        ps.setInt(3, seance.getIdModule());
        ps.setInt(4, seance.getIdProf());
        ps.setString(5, "Salle modifiée"); // à adapter
        ps.setInt(6, seance.getIdJour());
        ps.setInt(7, seance.getIdSeance());

        return ps.executeUpdate() > 0;
    }
}

//Supprimer une séance
public boolean supprimerSeance(int idSeance) throws SQLException {
    if (!seanceExiste(idSeance)) {
        System.out.println(" La séance à supprimer n'existe pas.");
        return false;
    }

    String sql = "DELETE FROM seances WHERE idSeance = ?";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, idSeance);
        return ps.executeUpdate() > 0;
    }
}

// Récupérer toutes les séances
public List<Seance> getToutesLesSeances() throws SQLException {
    List<Seance> seances = new ArrayList<>();
    String sql = "SELECT * FROM seances";
    try (PreparedStatement ps = connection.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            Seance seance = new Seance(
                    rs.getInt("idSeance"),
                    rs.getTime("heure_debut").toLocalTime(),
                    rs.getTime("heure_fin").toLocalTime(),
                    rs.getInt("idModule"),
                    rs.getInt("idProf"),
                    rs.getInt("idJour")
            );
            seances.add(seance);
        }
    }
    return seances;
}

// Récupérer une séance par ID
public Seance getSeanceParId(int idSeance) throws SQLException {
    String sql = "SELECT * FROM seances WHERE idSeance = ?";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, idSeance);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return new Seance(
                        rs.getInt("idSeance"),
                        rs.getTime("heure_debut").toLocalTime(),
                        rs.getTime("heure_fin").toLocalTime(),
                        rs.getInt("idModule"),
                        rs.getInt("idProf"),
                        rs.getInt("idJour")
                );
            }
        }
    }
    return null;
}

}
