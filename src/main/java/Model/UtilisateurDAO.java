package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

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

    // avoir l'user par matricule
    public Utilisateur getUtilisateurByMat(int matricule) {
        String requete = "SELECT * FROM utilisateurs WHERE idUser = ?";

        try (Connection cnx = ConnectionDB.getConnection();
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

        try (Connection cnx = ConnectionDB.getConnection();
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

        try (Connection cnx = ConnectionDB.getConnection();
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

        try(Connection cnx = ConnectionDB.getConnection();
            PreparedStatement statement = cnx.prepareStatement(requette)){

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

        try (Connection cnx = ConnectionDB.getConnection();
             PreparedStatement statement = cnx.prepareStatement(requete)) {

            statement.setString(1, user.getNom());
            statement.setString(2, user.getPrenom());
            statement.setString(3, user.getEmail());



            statement.setString(4, user.getRole().name());


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
        try(Connection cnx = ConnectionDB.getConnection()){
            PreparedStatement statement = cnx.prepareStatement(requette);

            statement.setInt(1, matricule);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted >0;
        }catch (SQLException e){
            System.err.println("Erreur lors de la suppression de l'utilisateur !");
        }
        return false ;
    }


}