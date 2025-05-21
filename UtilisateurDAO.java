package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Model.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtilisateurDAO{
    protected final Connection cnx;

    public UtilisateurDAO(Connection cnx) {
        if (cnx == null) {
            throw new IllegalArgumentException("La connexion ne peut pas être null");
        }
        this.cnx = cnx;
    }

    public boolean existe(int matricule) {
        String requete = "SELECT COUNT(*) FROM utilisateurs WHERE idUser = ?";
        try {//Connection cnx = ConnectionDB.getConnection();
            // Vérifier si la connexion est ouverte avant toute opération
            if (cnx.isClosed()) {
                throw new SQLException("La connexion est déjà fermée");
            }
            try (PreparedStatement statement = cnx.prepareStatement(requete)) {
                statement.setInt(1, matricule);
                try (ResultSet response = statement.executeQuery()) {
                    if (response.next()) {
                        return response.getInt(1) > 0;
                    }
                }
            }
        } catch (SQLException e) {
            //System.err.println("Erreur lors de la vérification de l'utilisateur (matricule=" + matricule + ") : " + e.getMessage());
            //e.printStackTrace();
            return false;
        }
        return false;
    }

    //celui d'ajoute est dans Auth !

    public Utilisateur getUtilisateurByMat(int matricule) {
        String requete = "SELECT * FROM utilisateurs WHERE idUser = ?";

        try ( //Connection cnx = ConnectionDB.getConnection();
                PreparedStatement statement = cnx.prepareStatement(requete)) {

            statement.setInt(1, matricule);
            ResultSet response = statement.executeQuery();

            if (response.next()) {
                String roleStr = response.getString("role"); // Convertir en majuscules pour éviter les erreurs
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
            //throw new RuntimeException("Erreur lors de la récupération de l'utilisateur", e);
        }

        return null;
    }

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
                    //System.err.println("Rôle inconnu dans la base de données : " + response.getString("role"));
                }
            }
        } catch (SQLException e) {
            //System.err.println("Erreur lors de la recherche des utilisateurs : " + e.getMessage());
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
                    //System.err.println("Rôle inconnu dans la base de données : " + response.getString("role"));
                }
            }
        } catch (SQLException e) {
            //System.err.println("Erreur lors de la recherche des utilisateurs : " + e.getMessage());
        }
        return usr;
    }

    public ArrayList<Utilisateur> getAllUtilisateurs(){
        String requette = "SELECT idUser, nom, prenom, email, role, motdepasse FROM utilisateurs";
        ArrayList<Utilisateur> users = new ArrayList<>();

        try(//Connection cnx = ConnectionDB.getConnection();
                PreparedStatement statement = cnx.prepareStatement(requette)){

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                try {
                    int matricule = resultSet.getInt("idUser");
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom");
                    String email = resultSet.getString("email");
                    String motdepasse = resultSet.getString("motdepasse");
                    String roleString = resultSet.getString("role");
            

                    Role role;
                    try {
                        role = Role.valueOf(roleString);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Role inconu detecter !!");
                        role = Role.Etudiant;
                    }

                    Utilisateur user = new Utilisateur(matricule, nom, prenom, email,motdepasse, role);
                    users.add(user);
                }catch (SQLException e){
                    //System.err.println("Erreur lors de la recuperation d'un utilisateur !!");
                }
            }
        }catch (SQLException e){
            //System.err.format("❌ Erreur SQL lors de la récupération des utilisateurs : %s (Code: %d, État: %s)%n",
                    //e.getMessage(), e.getErrorCode(), e.getSQLState());
        }

        return users;
    }

    public boolean modifierUtilisateur(Utilisateur user) {
        String requete = "UPDATE utilisateurs SET nom = ?, prenom = ?, email = ?, role = ? WHERE idUser = ?";

        try (//Connection cnx = ConnectionDB.getConnection();
             PreparedStatement statement = cnx.prepareStatement(requete)) {

            statement.setString(1, user.getNom());
            statement.setString(2, user.getPrenom());
            statement.setString(3, user.getEmail());



            statement.setString(4, user.getRole().name());
            //statement.setString(4, (user.getRole() != null) ? user.getRole().name() : null);

            statement.setInt(5, user.getIdUser());

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
            //System.err.println("Erreur lors de la suppression de l'utilisateur !");
        }
        return false ;
    }

}