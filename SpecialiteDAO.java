package Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class SpecialiteDAO {

	private Connection connection;

    public SpecialiteDAO(Connection connection) {
        this.connection = connection;
    }

    // Vérifie si une spécialité existe par ID
    public boolean specialiteExiste(int idSpecialite) throws SQLException {
        String sql = "SELECT COUNT(*) FROM specialites WHERE idSpecialite = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idSpecialite);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    // Ajouter une spécialité
    public boolean ajouterSpecialite(Specialite s) throws SQLException {
        if (specialiteExiste(s.getIdSpecialite())) {
            System.out.println(" La spécialité existe déjà !");
            return false;
        }

        String sql = "INSERT INTO specialites (idSpecialite, nomSpecialite) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, s.getIdSpecialite());
            ps.setString(2, s.getNomSpecialite());
            return ps.executeUpdate() > 0;
        }
    }

    // Modifier une spécialité
    public boolean modifierSpecialite(Specialite s) throws SQLException {
        if (!specialiteExiste(s.getIdSpecialite())) {
            System.out.println(" La spécialité à modifier n'existe pas !");
            return false;
        }

        String sql = "UPDATE specialites SET nomSpecialite = ? WHERE idSpecialite = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, s.getNomSpecialite());
            ps.setInt(2, s.getIdSpecialite());
            return ps.executeUpdate() > 0;
        }
    }

    // Supprimer une spécialité
    public boolean supprimerSpecialite(int idSpecialite) throws SQLException {
        if (!specialiteExiste(idSpecialite)) {
            System.out.println("❌ La spécialité à supprimer n'existe pas !");
            return false;
        }

        String sql = "DELETE FROM specialites WHERE idSpecialite = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idSpecialite);
            return ps.executeUpdate() > 0;
        }
    }

    // Récupérer une spécialité par ID
    public Specialite getSpecialiteParId(int idSpecialite) throws SQLException {
        String sql = "SELECT * FROM specialites WHERE idSpecialite = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idSpecialite);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("nomSpecialite");
                    return new Specialite(idSpecialite, nom);
                }
            }
        }
        return null;
    }

    // Récupérer toutes les spécialités
    public List<Specialite> getToutesLesSpecialites() throws SQLException {
        List<Specialite> liste = new ArrayList<>();
        String sql = "SELECT * FROM specialites";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("idSpecialite");
                String nom = rs.getString("nomSpecialite");
                liste.add(new Specialite(id, nom));
            }
        }
        return liste;
    }
}