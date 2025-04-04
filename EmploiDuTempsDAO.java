package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class EmploiDuTempsDAO {
    private Connection connection;
    private JourDAO jourDAO;
    private SpecialiteDAO specialiteDAO;

    public EmploiDuTempsDAO(Connection connection) {
        this.connection = connection;
        this.jourDAO = new JourDAO(connection);
        this.specialiteDAO = new SpecialiteDAO(connection);
    }



    // Vérifie si un emploi du temps existe
    public boolean emploiExiste(int idEmploi) throws SQLException {
        String sql = "SELECT COUNT(*) FROM emploisdutemps WHERE idEmploiDuTemps = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idEmploi);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    // Ajouter un emploi du temps
    public boolean ajouterEmploiDuTemps(EmploiDuTemps edt) throws SQLException {
        if (emploiExiste(edt.getIdEmploiDuTemps())) {
            System.out.println("❌ Emploi du temps déjà existant !");
            return false;
        }

        String sql = "INSERT INTO emploisdutemps (idEmploiDuTemps, section, groupe, idAnnee, idSpecialite) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, edt.getIdEmploiDuTemps());
            ps.setString(2, edt.getSection());
            ps.setString(3, edt.getGroupe());
            ps.setInt(4, edt.getIdAnnee());
            ps.setInt(5, edt.getSpecialite().getIdSpecialite());
            boolean result = ps.executeUpdate() > 0;

            // Ajouter les jours associés
            for (Jour jour : edt.getJours()) {
                jourDAO.ajouterJour(jour); // vérifie déjà l'existence
            }

            return result;
        }
    }

    // Modifier un emploi du temps
    public boolean modifierEmploiDuTemps(EmploiDuTemps edt) throws SQLException {
        if (!emploiExiste(edt.getIdEmploiDuTemps())) {
            System.out.println("❌ Emploi du temps inexistant !");
            return false;
        }

        String sql = "UPDATE emploisdutemps SET section = ?, groupe = ?, idAnnee = ?, idSpecialite = ? WHERE idEmploiDuTemps = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, edt.getSection());
            ps.setString(2, edt.getGroupe());
            ps.setInt(3, edt.getIdAnnee());
            ps.setInt(4, edt.getSpecialite().getIdSpecialite());
            ps.setInt(5, edt.getIdEmploiDuTemps());
            return ps.executeUpdate() > 0;
        }
    }

    // Supprimer un emploi du temps
    public boolean supprimerEmploiDuTemps(int idEmploi) throws SQLException {
        if (!emploiExiste(idEmploi)) {
            System.out.println("❌ L'emploi du temps à supprimer n'existe pas.");
            return false;
        }

        String sql = "DELETE FROM emploisdutemps WHERE idEmploiDuTemps = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idEmploi);
            return ps.executeUpdate() > 0;
        }
    }

    // Récupérer un emploi du temps par ID
    public EmploiDuTemps getEmploiDuTempsParId(int idEmploi) throws SQLException {
        String sql = "SELECT * FROM emploisdutemps WHERE idEmploiDuTemps = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idEmploi);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String section = rs.getString("section");
                    String groupe = rs.getString("groupe");
                    int idAnnee = rs.getInt("idAnnee");
                    int idSpecialite = rs.getInt("idSpecialite");

                    Specialite specialite = specialiteDAO.getSpecialiteParId(idSpecialite);
                    List<Jour> jours = jourDAO.getTousLesJours(); // tu peux filtrer les jours si besoin

                    return new EmploiDuTemps(idEmploi, jours, section, groupe, idAnnee, specialite);
                }
            }
        }
        return null;
    }

    // Récupérer tous les emplois du temps
    public List<EmploiDuTemps> getTousLesEmploisDuTemps() throws SQLException {
        List<EmploiDuTemps> liste = new ArrayList<>();
        String sql = "SELECT * FROM emploisdutemps";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int idEmploi = rs.getInt("idEmploiDuTemps");
                String section = rs.getString("section");
                String groupe = rs.getString("groupe");
                int idAnnee = rs.getInt("idAnnee");
                int idSpecialite = rs.getInt("idSpecialite");

                Specialite specialite = specialiteDAO.getSpecialiteParId(idSpecialite);
                List<Jour> jours = jourDAO.getTousLesJours(); // à filtrer si besoin

                EmploiDuTemps edt = new EmploiDuTemps(idEmploi, jours, section, groupe, idAnnee, specialite);
                liste.add(edt);
            }
        }
        return liste;
    }
}