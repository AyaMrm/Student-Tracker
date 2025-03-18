package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

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

}
