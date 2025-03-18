package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDAO{
    
    /*
    public boolean ajouterUtilisateur(Utilisateur utilisateur) {
        String query = "INSERT INTO utilisateurs (idUser, nom, prenom, email, motdepasse, role) VALUES (?, ?, ?, ?, ?, ?)";
        PasswordCryp p = new PasswordCryp();
        String hashedPassword = p.hashPassword(utilisateur.getPassword());

        try (PreparedStatement stmt = cnx.prepareStatement(query)) {
            // Verifie si le Mat utilisateur existe deja
            if (existe(utilisateur.getMatricule())) {
                System.out.println("⚠️ Erreur : Cet ID utilisateur existe déjà !");
                return false;
            }

            stmt.setInt(1, utilisateur.getMatricule());
            stmt.setString(2, utilisateur.getNom());
            stmt.setString(3, utilisateur.getPrenom());
            stmt.setString(4, utilisateur.getEmail());
            stmt.setString(5, hashedPassword);
            stmt.setString(6, utilisateur.getRole().name());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("✅ Utilisateur ajoutee avec succes !");
                return true;
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
        return false;
    }

     */
}
