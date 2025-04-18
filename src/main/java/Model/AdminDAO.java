package Model;

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
            e.printStackTrace();
        }
        return false;
    }

    public boolean ajouterAdmin(Admin admin) {
        String queryAdmin = "INSERT INTO Admins idAdmin VALUES ?";

        try {
            cnx.setAutoCommit(false);
            Auth auth = new Auth(cnx);

            if (!auth.ajouterUtilisateur(new Utilisateur(admin.getIdAdmin(), admin.getNom(), admin.getPrenom(), admin.getEmail(), admin.getMotdepasse(), Role.ADMIN), admin.getMotdepasse())) {
                cnx.rollback();
                return false;
            }

            try (PreparedStatement stmtAdmin = cnx.prepareStatement(queryAdmin)) {
                stmtAdmin.setInt(1, admin.getIdAdmin());
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

    public Admin getAdminByMat(int matricule) {
        String query = "SELECT idAdmin FROM admins WHERE idAdmin = ?";

        try (//Connection cnx = ConnectionDB.getConnection();
             PreparedStatement checkStmt = cnx.prepareStatement(query)) {

            checkStmt.setInt(1, matricule);
            ResultSet checkResult = checkStmt.executeQuery();

            if (!checkResult.next()) {
                System.out.println("⚠️ L'ID " + matricule + " n'est pas un admin !");
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
            throw new RuntimeException("❌ Erreur lors de la récupération de l'admin", e);
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
            System.err.println("❌ Erreur lors de la modification de l'admin : " + e.getMessage());
            return false;
        }
    }

    public boolean supprimerAdmin(int matricule){
        if(!existe(matricule)){
            System.err.println("Admin Non Trouver !!");
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
                    System.out.println("✅ Admin supprimé avec succès !");
                    return true;
                }
            }

            cnx.rollback();
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la suppression de l'admin : " + e.getMessage());
        }
        return false;
    }

}
