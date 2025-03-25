package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;

public class UtilisateurDAO {
    protected Connection cnx;

    // pour ce connecter
    public UtilisateurDAO(){
        this.cnx = ConnectionDB.getConnection();
    }

    //verification de l'existance de l'user
    public boolean existe(int matricule){
        String requette = "SELECT COUNT(*) FROM utilisateurs WHERE idUser=?";
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

    //On commence par creer un User
    public boolean ajouterUtilisateur(Utilisateur user) {
        String sql = "INSERT INTO utilisateurs (idUser, nom, prenom, email, motdepasse, role) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
            stmt.setInt(1, user.getMatricule());
            stmt.setString(2, user.getNom());
            stmt.setString(3, user.getPrenom());
            stmt.setString(4, user.getEmail());
            String motdepasseHashe = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            stmt.setString(5, motdepasseHashe);
            stmt.setString(6, user.getRole().name());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // avoir l'user par matricule
    public Utilisateur getUtilisateurByMat(int matricule) {
        String requete = "SELECT * FROM utilisateurs WHERE idUser = ?";

        try (//Connection cnx = ConnectionDB.getConnection();
             PreparedStatement statement = cnx.prepareStatement(requete)) {

            statement.setInt(1, matricule);
            ResultSet response = statement.executeQuery();

            if (response.next()) {
                String roleStr = response.getString("role").toUpperCase(); // Convertir en majuscules pour éviter les erreurs
                Role role;

                try {
                    role = Role.valueOf(roleStr); // Vérifie si la valeur correspond bien à un rôle défini dans l'énumération
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException("Rôle inconnu : " + roleStr, e);
                }

                return new Utilisateur(
                        response.getInt("idUser"),
                        response.getString("nom"),
                        response.getString("prenom"),
                        response.getString("email"),
                        role
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération de l'utilisateur", e);
        }

        return null;
    }

    // les utilisateurs par role
    public ArrayList<Utilisateur> getUtilisateursByRole(Role role) {
        String requete = "SELECT * FROM utilisateurs WHERE role = ?";
        ArrayList<Utilisateur> userList = new ArrayList<>();

        try (//Connection cnx = ConnectionDB.getConnection();
             PreparedStatement statement = cnx.prepareStatement(requete)) {

            statement.setString(1, role.name());
            ResultSet response = statement.executeQuery();

            while (response.next()) {
                try {
                    Role userRole = Role.valueOf(response.getString("role").toUpperCase());
                    Utilisateur user = new Utilisateur(
                            response.getInt("idUser"),
                            response.getString("nom"),
                            response.getString("prenom"),
                            response.getString("email"),
                            userRole
                    );
                    userList.add(user);
                } catch (IllegalArgumentException e) {
                    System.err.println("❌ Rôle inconnu dans la base de données : " + response.getString("role"));
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la recherche des utilisateurs : " + e.getMessage());
        }

        return userList;
    }

    // voir les utilisateurs par nom
    public ArrayList<Utilisateur> getUtilisateurByNom(String nom){
        String requete = "SELECT * FROM utilisateurs WHERE nom = ?";
        ArrayList<Utilisateur> usr = new ArrayList<Utilisateur>();

        try (//Connection cnx = ConnectionDB.getConnection();
             PreparedStatement statement = cnx.prepareStatement(requete)) {

            statement.setString(1, nom);
            ResultSet response = statement.executeQuery();

            while (response.next()) {
                try {
                    String userNom = response.getString("nom");
                    Utilisateur user = new Utilisateur(
                            response.getInt("idUser"),
                            userNom,
                            response.getString("prenom"),
                            response.getString("email"),
                            Role.valueOf(response.getString("role").toUpperCase())
                    );
                    usr.add(user);
                } catch (IllegalArgumentException e) {
                    System.err.println("❌ Rôle inconnu dans la base de données : " + response.getString("role"));
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la recherche des utilisateurs : " + e.getMessage());
        }
        return usr;
    }

    public ArrayList<Utilisateur> getAllUtilisateurs(){
        String requette = "SELECT idUser, nom, prenom, email, role FROM utilisateurs";
        ArrayList<Utilisateur> users = new ArrayList<>();

        try(PreparedStatement statement = cnx.prepareStatement(requette)){

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                try {
                    int matricule = resultSet.getInt("idUser");
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom");
                    String email = resultSet.getString("email");
                    String roleString = resultSet.getString("role").toUpperCase();

                    Role role;
                    try {
                        role = Role.valueOf(roleString);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Role inconu detecter !!");
                        role = Role.ETUDIANT;
                    }

                    Utilisateur user = new Utilisateur(matricule, nom, prenom, email, role);
                    users.add(user);
                }catch (SQLException e){
                    System.err.println("Erreur lors de la recuperation d'un utilisateur !!");
                }
            }
        }catch (SQLException e){
            System.err.format("❌ Erreur SQL lors de la récupération des utilisateurs : %s (Code: %d, État: %s)%n",
                    e.getMessage(), e.getErrorCode(), e.getSQLState());
        }

        return users;
    }

    //  Methode pour modifier l'utilisateur
    public boolean modifierUtilisateur(Utilisateur user) {
        String requete = "UPDATE utilisateurs SET nom = ?, prenom = ?, email = ?, role = ? WHERE idUser = ?";

        try (//Connection cnx = ConnectionDB.getConnection();
             PreparedStatement statement = cnx.prepareStatement(requete)) {

            statement.setString(1, user.getNom());
            statement.setString(2, user.getPrenom());
            statement.setString(3, user.getEmail());



            statement.setString(4, user.getRole().name());
            //statement.setString(4, (user.getRole() != null) ? user.getRole().name() : null);

            statement.setInt(5, user.getMatricule());

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("✅ Utilisateur mis à jour avec succès !");
                return true;
            } else {
                System.out.println("⚠ Aucun utilisateur trouvé avec cet ID.");
            }

        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la modification de l'utilisateur : " + e.getMessage());
        }
        return false;
    }

    //supprimer utilisateur
    public boolean supprimerUtilisateur(int matricule){
        if(!existe(matricule)){
            System.err.println("Utilisateur inexistant !!");
            return false;
        }
        String requette = "DELETE FROM utilisateurs WHERE idUser = ?";
        try//(Connection cnx = ConnectionDB.getConnection())
        {
            PreparedStatement statement = cnx.prepareStatement(requette);

            statement.setInt(1, matricule);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted >0;
        }catch (SQLException e){
            System.err.println("Erreur lors de la suppression de l'utilisateur !");
        }
        return false ;
    }

    public boolean changePassword(int matricule, String ancienPassword, String newPassword) {
        String queryRecuperer = "SELECT motdepasse FROM utilisateurs WHERE idUser = ?";
        String passwordStocker = null;

        try (PreparedStatement statementRecuper = cnx.prepareStatement(queryRecuperer)) {
            statementRecuper.setInt(1, matricule);
            ResultSet result = statementRecuper.executeQuery();

            if (result.next()) {
                passwordStocker = result.getString("motdepasse");
            } else {
                System.err.println("Aucun utilisateur trouvé !");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du password : " + e.getMessage());
            return false;
        }

        System.out.println("Mot de passe stocké : " + passwordStocker);
        System.out.println("Ancien mot de passe saisi : " + ancienPassword);

        if (passwordStocker == null || !BCrypt.checkpw(ancienPassword, passwordStocker)) {
            System.err.println("⚠️ Ancien password incorrect !!");
            return false;
        }

        // Hachage du nouveau mot de passe
        String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt(12));

        String queryUpdate = "UPDATE utilisateurs SET motdepasse = ? WHERE idUser = ?";
        try (PreparedStatement statementUpdate = cnx.prepareStatement(queryUpdate)) {
            statementUpdate.setString(1, hashedPassword);
            statementUpdate.setInt(2, matricule);

            int rowsUpdate = statementUpdate.executeUpdate();
            if (rowsUpdate > 0) {
                System.out.println("✅ Mot de passe mis à jour avec succès !");
                return true;
            } else {
                System.err.println("❌ Erreur lors de la mise à jour");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL lors de la mise à jour : " + e.getMessage());
            return false;
        }
    }

    public Utilisateur authentifier(int idUser, String motdepasse) {
        String sql = "SELECT * FROM utilisateurs WHERE idUser = ?";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
            stmt.setInt(1, idUser);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String motdepasseStocke = rs.getString("motdepasse");
                System.out.println("Mot de passe stocké : " + motdepasseStocke);
                System.out.println("Mot de passe fourni : " + motdepasse);
                if (BCrypt.checkpw(motdepasse, motdepasseStocke)) {
                    Utilisateur user = new Utilisateur();
                    user.setMatricule(rs.getInt("idUser"));
                    user.setNom(rs.getString("nom"));
                    user.setPrenom(rs.getString("prenom"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(motdepasseStocke);
                    user.setRole(Role.valueOf(rs.getString("role")));
                    return user;
                } else {
                    System.out.println("Echec de la verification du mot de passe");
                }
            } else {
                System.out.println("Utilisateur non trouvé pour idUser = " + idUser);
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}