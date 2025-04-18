package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO {
    private Connection connection;
    private SpecialiteDAO specialiteDAO;
    private EmploiDuTempsDAO emploiDuTempsDAO;

    public EtudiantDAO(Connection connection) {
        this.connection = connection;
        this.specialiteDAO = new SpecialiteDAO(connection);
        this.emploiDuTempsDAO = new EmploiDuTempsDAO(connection);
    }

    public boolean etudiantExiste(int idEtudiant) throws SQLException {
        String sql = "SELECT COUNT(*) FROM etudiants WHERE idEtudiant = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idEtudiant);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    public boolean ajouterEtudiant(Etudiant etudiant) throws SQLException {
        if (etudiantExiste(etudiant.getIdEtudiant())) {
            System.out.println("❌ L'étudiant avec ID " + etudiant.getIdEtudiant() + " existe déjà !");
            return false;
        }

        String userSql = "INSERT INTO utilisateurs (idUser, nom, prenom, email, motDePasse, role) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement userPs = connection.prepareStatement(userSql)) {
            userPs.setInt(1, etudiant.getIdUser());
            userPs.setString(2, etudiant.getNom());
            userPs.setString(3, etudiant.getPrenom());
            userPs.setString(4, etudiant.getEmail());
            userPs.setString(5, etudiant.getMotdepasse() != null ? etudiant.getMotdepasse() : ""); // Handle optional password
            userPs.setString(6, Role.ETUDIANT.name());
            userPs.executeUpdate();
        }


        String etudiantSql = "INSERT INTO etudiants (idEtudiant, idSpecialite, section, groupe, idEmploiDuTemps) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement etudiantPs = connection.prepareStatement(etudiantSql)) {
            etudiantPs.setInt(1, etudiant.getIdEtudiant());
            etudiantPs.setInt(2, etudiant.getIdSpecialite());
            etudiantPs.setString(3, etudiant.getSection());
            etudiantPs.setString(4, etudiant.getGroupe());
            etudiantPs.setInt(5, etudiant.getIdEmploiDuTemps());
            boolean result = etudiantPs.executeUpdate() > 0;
            System.out.println("✅ Étudiant ajouté avec succès !");
            return result;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de l'étudiant : " + e.getMessage());
            String deleteUserSql = "DELETE FROM utilisateurs WHERE idUser = ?";
            try (PreparedStatement deletePs = connection.prepareStatement(deleteUserSql)) {
                deletePs.setInt(1, etudiant.getIdUser());
                deletePs.executeUpdate();
            }
            throw e;
        }
    }

    public boolean modifierEtudiant(Etudiant etudiant) throws SQLException {
        if (!etudiantExiste(etudiant.getIdEtudiant())) {
            System.out.println("❌ L'étudiant avec ID " + etudiant.getIdEtudiant() + " n'existe pas !");
            return false;
        }


        String userSql = "UPDATE utilisateurs SET nom = ?, prenom = ?, email = ?, motDePasse = ? WHERE idUser = ?";
        try (PreparedStatement userPs = connection.prepareStatement(userSql)) {
            userPs.setString(1, etudiant.getNom());
            userPs.setString(2, etudiant.getPrenom());
            userPs.setString(3, etudiant.getEmail());
            userPs.setString(4, etudiant.getMotdepasse() != null ? etudiant.getMotdepasse() : "");
            userPs.setInt(5, etudiant.getIdUser());
            userPs.executeUpdate();
        }

        String etudiantSql = "UPDATE etudiants SET idSpecialite = ?, section = ?, groupe = ?, idEmploiDuTemps = ? WHERE idEtudiant = ?";
        try (PreparedStatement etudiantPs = connection.prepareStatement(etudiantSql)) {
            etudiantPs.setInt(1, etudiant.getIdSpecialite());
            etudiantPs.setString(2, etudiant.getSection());
            etudiantPs.setString(3, etudiant.getGroupe());
            etudiantPs.setInt(4, etudiant.getIdEmploiDuTemps());
            etudiantPs.setInt(5, etudiant.getIdEtudiant());
            boolean result = etudiantPs.executeUpdate() > 0;
            System.out.println("✅ Étudiant mis à jour avec succès !");
            return result;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de l'étudiant : " + e.getMessage());
            return false;
        }
    }

    public boolean supprimerEtudiant(int idEtudiant) throws SQLException {
        if (!etudiantExiste(idEtudiant)) {
            System.out.println("❌ L'étudiant avec ID " + idEtudiant + " n'existe pas !");
            return false;
        }


        String etudiantSql = "DELETE FROM etudiants WHERE idEtudiant = ?";
        try (PreparedStatement etudiantPs = connection.prepareStatement(etudiantSql)) {
            etudiantPs.setInt(1, idEtudiant);
            etudiantPs.executeUpdate();
        }


        String userSql = "DELETE FROM utilisateurs WHERE idUser = ?";
        try (PreparedStatement userPs = connection.prepareStatement(userSql)) {
            userPs.setInt(1, idEtudiant);
            boolean result = userPs.executeUpdate() > 0;
            System.out.println("✅ Étudiant supprimé avec succès !");
            return result;
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la suppression de l'étudiant : " + e.getMessage());
            return false;
        }
    }

    public Etudiant getEtudiantParId(int idEtudiant) throws SQLException {
        String sql = "SELECT u.*, e.idSpecialite, e.section, e.groupe, e.idEmploiDuTemps " +
                "FROM utilisateurs u JOIN etudiants e ON u.idUser = e.idEtudiant " +
                "WHERE e.idEtudiant = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idEtudiant);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Etudiant(
                            rs.getInt("idUser"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("email"),
                            rs.getString("motDePasse"),
                            rs.getInt("idSpecialite"),
                            rs.getString("section"),
                            rs.getString("groupe"),
                            rs.getInt("idEmploiDuTemps"),
                            new ArrayList<>()
                    );
                }
            }
        }
        return null;
    }

    public List<Etudiant> getTousLesEtudiants() throws SQLException {
        List<Etudiant> etudiants = new ArrayList<>();
        String sql = "SELECT u.*, e.idSpecialite, e.section, e.groupe, e.idEmploiDuTemps " +
                "FROM utilisateurs u JOIN etudiants e ON u.idUser = e.idEtudiant";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Etudiant etudiant = new Etudiant(
                        rs.getInt("idUser"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("motDePasse"),
                        rs.getInt("idSpecialite"),
                        rs.getString("section"),
                        rs.getString("groupe"),
                        rs.getInt("idEmploiDuTemps"),
                        new ArrayList<>()
                );
                etudiants.add(etudiant);
            }
        }
        return etudiants;
    }

    public List<Etudiant> getEtudiantParNom(String nom) throws SQLException {
        List<Etudiant> li = new ArrayList<>();
        String sql = "SELECT u.idUser, u.nom, u.prenom, u.email, u.motDePasse, u.role, " +
                "e.idSpecialite, e.section, e.groupe, e.idEmploiDuTemps " +
                "FROM utilisateurs u JOIN etudiants e ON u.idUser = e.idEtudiant " +
                "WHERE u.nom = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nom);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    li.add(new Etudiant(
                            rs.getInt("idUser"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("email"),
                            rs.getString("motDePasse"),
                            rs.getInt("idSpecialite"),
                            rs.getString("section"),
                            rs.getString("groupe"),
                            rs.getInt("idEmploiDuTemps"),
                            new ArrayList<>()
                    ));
                }
            }
        }
        return li;
    }

    public List<Etudiant> getEtudiantParSpecialite(int idSpecialite) throws SQLException {
        List<Etudiant> listeEtudiants = new ArrayList<>();

        String sql = "SELECT u.idUser, u.nom, u.prenom, u.email, u.motDePasse, u.role, " +
                "e.idSpecialite, e.section, e.groupe, e.idEmploiDuTemps " +
                "FROM utilisateurs u JOIN etudiants e ON u.idUser = e.idEtudiant " +
                "WHERE e.idSpecialite = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idSpecialite);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Etudiant etudiant = new Etudiant(
                            rs.getInt("idUser"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("email"),
                            rs.getString("motDePasse"),
                            rs.getInt("idSpecialite"),
                            rs.getString("section"),
                            rs.getString("groupe"),
                            rs.getInt("idEmploiDuTemps"),
                            new ArrayList<>()
                    );
                    listeEtudiants.add(etudiant);
                }
            }
        }

        return listeEtudiants;
    }


}