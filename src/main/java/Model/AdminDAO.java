package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

public class AdminDAO extends UtilisateurDAO{
    public AdminDAO(){
        super();
    }

    public boolean ajouterAdmin(Admin admin) {
        String queryAdmin = "INSERT INTO Admins (idAdmin) VALUES (?)";

        try {
            cnx.setAutoCommit(false);

            if (!ajouterUtilisateur(admin)) {
                cnx.rollback();
                return false;
            }

            try (PreparedStatement stmtAdmin = cnx.prepareStatement(queryAdmin)) {
                stmtAdmin.setInt(1, admin.getMatricule());
                stmtAdmin.executeUpdate();
            }

            cnx.commit();
            System.out.println("✅ Admin ajouté avec succès !");
            return true;
        } catch (SQLException e) {
            try {
                cnx.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            System.err.println("❌ Erreur lors de l'ajout de l'admin : " + e.getMessage());
        } finally {
            try {
                cnx.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public Utilisateur getAdminByMat(int matricule) {
        String checkQuery = "SELECT idAdmin FROM admins WHERE idAdmin = ?";

        try (Connection cnx = ConnectionDB.getConnection();
             PreparedStatement checkStmt = cnx.prepareStatement(checkQuery)) {

            checkStmt.setInt(1, matricule);
            ResultSet checkResult = checkStmt.executeQuery();

            if (!checkResult.next()) {
                System.out.println("⚠️ L'ID " + matricule + " n'est pas un admin !");
                return null; // 🔴 Ce n'est pas un admin
            }


            Utilisateur utilisateur = getUtilisateurByMat(matricule);
            if (utilisateur != null) {
                return new Utilisateur(
                        utilisateur.getMatricule(),
                        utilisateur.getNom(),
                        utilisateur.getPrenom(),
                        utilisateur.getEmail(),
                        utilisateur.getRole()
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("❌ Erreur lors de la récupération de l'admin", e);
        }

        return null;
    }

    public boolean modifierAdmin(Admin admin) {

        String checkQuery = "SELECT idAdmin FROM admins WHERE idAdmin = ?";

        try (Connection cnx = ConnectionDB.getConnection();
             PreparedStatement checkStmt = cnx.prepareStatement(checkQuery)) {

            checkStmt.setInt(1, admin.getMatricule());
            ResultSet result = checkStmt.executeQuery();

            if (!result.next()) {
                System.out.println("⚠ L'ID " + admin.getMatricule() + " n'est pas un admin !");
                return false;
            }

            return modifierUtilisateur(admin);

        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la modification de l'admin : " + e.getMessage());
            return false;
        }
    }

}
