package Model;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO extends UtilisateurDAO{
    //private final Connection cnx;

    public AdminDAO(Connection cnx) {
        super(cnx);
        if (cnx == null) {
            throw new IllegalArgumentException("Y a un probleme dans la conexion!!!");
        }
    }

    
    public boolean existe(int matricule){
        String requette = "SELECT COUNT(*) FROM Admins WHERE idAdmin=?";
        try(PreparedStatement statement = cnx.prepareStatement(requette)){
            statement.setInt(1, matricule);
            ResultSet response = statement.executeQuery();
            if(response.next()){
                return response.getInt(1)>0;
            }
        }catch (SQLException e){
            //e.printStackTrace();
        }
        return false;
    }

    public boolean ajouterAdmin(Admin admin) throws SQLException {
        if (admin == null) {
            System.err.println("Admin est Null!!");
            return false;
        }

        if (existe(admin.getIdAdmin())) {
            System.err.println("L'admin avec ID " + admin.getIdAdmin() + " existe déjà !");
            return false;
        }

        try {
            cnx.setAutoCommit(false);

            Auth auth = new Auth(cnx);
            boolean addUser = auth.ajouterUtilisateur(
                    new Utilisateur(
                            admin.getIdUser(),
                            admin.getNom(),
                            admin.getPrenom(),
                            admin.getEmail(),
                            admin.getMotdepasse(),
                            Role.Admin
                    ),
                    admin.getMotdepasse()
            );
            if (!addUser) {
                cnx.rollback();
                return false;
            }

            String queryAdmin = "INSERT INTO admins (idAdmin) VALUES (?)";
            try (PreparedStatement stmtAdmin = cnx.prepareStatement(queryAdmin)) {
                stmtAdmin.setInt(1, admin.getIdAdmin());
                stmtAdmin.executeUpdate();
            }

            cnx.commit();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            try {
                cnx.rollback();
            } catch (SQLException rollbackEx) {
                System.err.println(rollbackEx.getMessage());
            }
            throw e;
        } finally {
            try {
                cnx.setAutoCommit(true);
            } catch (SQLException ex) {
                System.err.println("Erreur lors de la restauration de l'auto-commit : " + ex.getMessage());
            }
        }
    }

    public Admin getAdminByMat(int matricule) {
        String query = "SELECT idAdmin FROM admins WHERE idAdmin = ?";

        try (//Connection cnx = ConnectionDB.getConnection();
             PreparedStatement checkStmt = cnx.prepareStatement(query)) {

            checkStmt.setInt(1, matricule);
            ResultSet checkResult = checkStmt.executeQuery();

            if (!checkResult.next()) {
                return null;
            }


            Utilisateur utilisateur = getUtilisateurByMat(matricule);

            if (utilisateur != null) {
                return new Admin(
                        utilisateur.getIdUser(),
                        utilisateur.getNom(),
                        utilisateur.getPrenom(),
                        utilisateur.getEmail()
                );
            }
        } catch (SQLException e) {
            //throw new RuntimeException("❌ Erreur lors de la récupération de l'admin", e);
        }

        return null;
    }

    public boolean modifierAdmin(Admin admin) {

        String checkQuery = "SELECT idAdmin FROM admins WHERE idAdmin = ?";

        try (//Connection cnx = ConnectionDB.getConnection();
             PreparedStatement checkStmt = cnx.prepareStatement(checkQuery)) {

            checkStmt.setInt(1, admin.getIdAdmin());
            ResultSet result = checkStmt.executeQuery();

            if (!result.next()) {
                System.out.println("⚠ L'ID " + admin.getIdAdmin() + " n'est pas un admin !");
                return false;
            }

            return modifierUtilisateur(admin);

        } catch (SQLException e) {
            //System.err.println("❌ Erreur lors de la modification de l'admin : " + e.getMessage());
            return false;
        }
    }

    public boolean supprimerAdmin(int matricule){
        if(!existe(matricule)){
            return false;
        }
        String queryAdmin = "DELETE FROM Admins WHERE idAdmin =?";
        String queryUser = "DELETE FROM utilisateurs WHERE idUser = ?";

        try (Connection cnx = ConnectionDB.getConnection()) {
            cnx.setAutoCommit(false);

            try (PreparedStatement statementAdmin = cnx.prepareStatement(queryAdmin)) {
                statementAdmin.setInt(1, matricule);
                statementAdmin.executeUpdate();
            }

            try (PreparedStatement statementUser = cnx.prepareStatement(queryUser)) {
                statementUser.setInt(1, matricule);
                int rowsDeleted = statementUser.executeUpdate();

                if (rowsDeleted > 0) {
                    cnx.commit();
                    //System.out.println("✅ Admin supprimé avec succès !");
                    return true;
                }
            }

            cnx.rollback();
        } catch (SQLException e) {
            //System.err.println("❌ Erreur lors de la suppression de l'admin : " + e.getMessage());
        }
        return false;
    }

}