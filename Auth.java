package Model;

import Model.ConnectionDB;
import Model.Role;
import Model.Utilisateur;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Auth {
    private final Connection cnx;

    public Auth(Connection cnx) {
        this.cnx = cnx;
    }


    public boolean ajouterUtilisateur(Utilisateur nouvelUtilisateur, String motdepasse) {
        PasswordValidator val = new PasswordValidator();
        /*if(val.isWeak(motdepasse)){
            return false;
        }*/
        String hashedMotDePasse = BCrypt.hashpw(motdepasse, BCrypt.gensalt());
        String sql = "INSERT INTO utilisateurs (idUser, nom, prenom, email, motdepasse, role) VALUES (?, ?, ?, ?, ?, ?)";

        
        try (PreparedStatement statement = cnx.prepareStatement(sql)) {
            statement.setInt(1, nouvelUtilisateur.getIdUser());
            statement.setString(2, adjustedNom(nouvelUtilisateur.getNom()));
            statement.setString(3, nouvelUtilisateur.getPrenom());
            statement.setString(4, nouvelUtilisateur.getEmail());
            statement.setString(5, hashedMotDePasse);
            statement.setString(6, nouvelUtilisateur.getRole().name());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            //System.err.println("Erreur lors de l'ajout d'utilisateur : " + e.getMessage());
            //e.printStackTrace();
            return false;
        }
    }

    public Utilisateur connecter(int idUser, String motdepasse) {
        String sql = "SELECT * FROM utilisateurs WHERE idUser = ?";

        try (PreparedStatement statement = cnx.prepareStatement(sql)) {
            statement.setInt(1, idUser);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    String hashedPassword = rs.getString("motdepasse");
                    //motdepasse.equals(hashedPassword))
                    if (motdepasse.equals(hashedPassword)) {
                        return new Utilisateur(
                                rs.getInt("idUser"),
                                adjustedNom(rs.getString("nom")),
                                rs.getString("prenom"),
                                rs.getString("email"),
                                Role.valueOf(rs.getString("role"))
                        );
                    }
                }
            }
        } catch (SQLException e) {
            //System.err.println("Erreur lors de la connexion : " + e.getMessage());
            //e.printStackTrace();
        }
        return null;
    }

    private String adjustedNom(String nom) {
        return nom != null ? nom.trim() : "";
    }

    public boolean changePassword(int idUser, String oldPassword, String newPassword) {
        String sql = "SELECT motdepasse FROM utilisateurs WHERE idUser = ?";

        PasswordValidator val = new PasswordValidator();
        if(val.isWeak(newPassword)){
            return false;
        }

        try (PreparedStatement selectStmt = cnx.prepareStatement(sql)) {
            selectStmt.setInt(1, idUser);
            try (ResultSet rs = selectStmt.executeQuery()) {
                if (rs.next()) {
                    String hashedPassword = rs.getString("motdepasse");
                    if (BCrypt.checkpw(oldPassword, hashedPassword)) {
                        // Old password is correct, proceed to update
                        String newHashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
                        String updateSql = "UPDATE utilisateurs SET motdepasse = ? WHERE idUser = ?";

                        try (PreparedStatement updateStmt = cnx.prepareStatement(updateSql)) {
                            updateStmt.setString(1, newHashedPassword);
                            updateStmt.setInt(2, idUser);
                            return updateStmt.executeUpdate() > 0;
                        }
                    } else {
                        //System.err.println("Erreur : mot de passe actuel incorrect");
                        return false;
                    }
                } else {
                    //System.err.println("Erreur : utilisateur avec idUser " + idUser + " non trouvÃ©");
                    return false;
                }
            }
        } catch (SQLException e) {
            //System.err.println("Erreur lors du changement de mot de passe : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}