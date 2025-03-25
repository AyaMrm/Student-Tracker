package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfDAO extends UtilisateurDAO{
    public ProfDAO(){
        super();
    }

    @Override
    public boolean existe(int matricule) {
        String requette = "SELECT COUNT(*) FROM Profs WHERE idProf=?";
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

    public boolean ajouterProf(Prof prof) {
        String query = "INSERT INTO profs (idProf, specialite, grade, departement) VALUES (?, ?, ?, ?)";

        try (Connection cnx = ConnectionDB.getConnection()) {
            cnx.setAutoCommit(false);

            if (!ajouterUtilisateur(prof)) {
                cnx.rollback();
                return false;
            }

            try (PreparedStatement statement = cnx.prepareStatement(query)) {
                statement.setInt(1, prof.getMatricule());
                statement.setString(2, prof.getSpecialite());
                statement.setString(3, prof.getGrade());
                statement.setString(4, prof.getDepartement());
                statement.executeUpdate();
            }

            cnx.commit();
            System.out.println("Prof ajouté avec succès ! 😊");
            return true;
        } catch (SQLException e) {
            System.err.println("Une erreur est survenue lors de l'ajout du nouveau Prof !! 😔");
            e.printStackTrace(); // Pour voir l'erreur exacte dans la console
            return false;
        }
    }

    public Prof getProfByMat(int matricule){
        String query = "SELECT u.nom, u.prenom, u.email, p.specialite, p.grade, p.departement "+
                "FROM utilisateurs u "+
                "JOIN profs p ON u.idUser = idProf "+
                "WHERE p.idProf = ?";

        try(//Connection cnx = ConnectionDB.getConnection();
        PreparedStatement statement = cnx.prepareStatement(query)){
            statement.setInt(1, matricule);
            ResultSet result = statement.executeQuery();

            if(result.next()){
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");
                String email = result.getString("email");
                String specialite = result.getString("specialite");
                String grade = result.getString("grade");
                String departement = result.getString("departement");

                return new Prof(matricule, nom, prenom, email, specialite, grade, departement);
            }
        }catch (SQLException e){
            System.err.println("aucune prof trouver avec le matricule "+ matricule+" 😔!!");
        }
        return null;
    }

    public ArrayList<Prof> getProfsByNom(String nom){
        ArrayList<Prof> profs = new ArrayList<>();
        String query = "SELECT u.idUser, u.nom, u.prenom, u.email, p.specialite, p.grade, p.departement "+
                "FROM utilisateurs u "+
                "JOIN profs p ON u.idUser = p.idProf "+
                "WHERE u.nom = ?";

        try(Connection cnx = ConnectionDB.getConnection();
        PreparedStatement statement = cnx.prepareStatement(query)){
            statement.setString(1, nom);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                int matricule = result.getInt("idUser");
                String prenom = result.getString("prenom");
                String email = result.getString("email");
                String specialite =  result.getString("specialite");
                String grade = result.getString("grade");
                String departement = result.getString("departement");

                Prof p = new Prof(matricule, nom, prenom, email, specialite, grade, departement);
                profs.add(p);
            }
        }catch(SQLException e){
            System.err.println("Erreur lors de la recherche du prof avec le nom "+nom+" 😔!!");
        }
        return profs;
    }

    public ArrayList<Prof> getProfBySpecialite(String specialite){
        ArrayList<Prof> profs = new ArrayList<>();
        String query = "SELECT u.idUser, u.nom, u.prenom, u.email, p.specialite, p.grade, p.departement "+
                "FROM utilisateurs u "+
                "JOIN profs p ON u.idUser = p.idProf "+
                "WHERE p.specialite = ?";

        try(Connection cnx = ConnectionDB.getConnection();
        PreparedStatement statement = cnx.prepareStatement(query)){
            statement.setString(1, specialite);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                int matricule = result.getInt("idUser");
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");
                String email = result.getString("email");
                String grade = result.getString("grade");
                String departement = result.getString("departement");

                Prof p = new Prof(matricule, nom, prenom, email, specialite, grade, departement);
                profs.add(p);
            }
        }catch (SQLException e){
            System.err.println("Erreur lors de la recherche du prof avec specialite "+specialite+" 😔!!");
        }
        return profs;
    }

    public ArrayList<Prof> getProfByGrade(String grade){
        ArrayList<Prof> profs = new ArrayList<>() ;

        String query = "SELECT u.idUser, u.nom, u.prenom, u.email, p.specialite, p.grade, p.departement "+
                "FROM utilisateurs u "+
                "JOIN profs p ON u.idUser = p.idProf "+
                "WHERE p.grade = ?";

        try(Connection cnx = ConnectionDB.getConnection();
        PreparedStatement statement = cnx.prepareStatement(query)){
            statement.setString(1, grade);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                int matricule = result.getInt("idUser");
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");
                String email = result.getString("email");
                String specialite = result.getString("specialite");
                String departement = result.getString("departement");

                Prof p = new Prof(matricule, nom, prenom, email, specialite, grade, departement);
                profs.add(p);
            }
        }catch (SQLException e){
            System.err.println("Erreur lors de la recherche des profs avec grade "+grade+" 😔!!");
        }
        return profs;
    }

    public ArrayList<Prof> getProfByDepartement(String departement){
        ArrayList<Prof> profs = new ArrayList<>();
        String query = "SELECT u.idUser, u.nom, u.prenom, u.email, p.specialite, p.grade, p.departement "+
                "FROM utilisateurs u "+
                "JOIN profs p ON u.idUser = idProf "+
                "WHERE p.departement = ?";
        try(Connection cnx = ConnectionDB.getConnection();
        PreparedStatement statement = cnx.prepareStatement(query)){
            statement.setString(1, departement);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                int matricule = result.getInt("idUser");
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");
                String email = result.getString("email");
                String specialite = result.getString("specialite");
                String grade = result.getString("grade");

                Prof p = new Prof(matricule, nom, prenom, email, specialite, grade, departement);
                profs.add(p);
            }
        }catch(SQLException e){
            System.err.println("Erreur lors de la recherche des profs avec grade "+departement+" 😔!!");
        }
        return profs;
    }

    public ArrayList<Prof> getAllProfs(){
        ArrayList<Prof> all = new ArrayList<>();
        String query = "SELECT u.idUser, u.nom, u.prenom, u.email, p.specialite, p.grade, p.departement "+
                "FROM utilisateurs u "+
                "JOIN profs p ON u.idUser = p.idProf";

        try(Connection cnx = ConnectionDB.getConnection();
        PreparedStatement statement = cnx.prepareStatement(query)){
            ResultSet result = statement.executeQuery();
            while(result.next()){
                int matricule = result.getInt("idUser");
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");
                String email = result.getString("email");
                String specialite = result.getString("specialite");
                String grade = result.getString("grade");
                String departement = result.getString("departement");

                Prof p= new Prof(matricule, nom, prenom, email, specialite, grade, departement);
                all.add(p);
            }
        }catch (SQLException e){
            System.err.println("Erreur lors de la recherche des profs 😔!!");
        }
        return all;
    }

    public boolean modifierProf(Prof prof){
        String query = "UPDATE profs SET specialite = ?, grade = ?, departement = ? WHERE idProf = ?";
        String queryUser = "UPDATE utilisateurs SET nom =?, prenom = ?, email = ? WHERE idUser = ?";

        try (Connection cnx = ConnectionDB.getConnection();
        PreparedStatement statement = cnx.prepareStatement(query);
        PreparedStatement statementUser = cnx.prepareStatement(queryUser)){
            statement.setString(1, prof.getSpecialite());
            statement.setString(2, prof.getGrade());
            statement.setString(3, prof.getDepartement());
            statement.setInt(4, prof.getMatricule());

            statementUser.setString(1, prof.getNom());
            statementUser.setString(2, prof.getPrenom());
            statementUser.setString(3, prof.getEmail());
            statementUser.setInt(4, prof.getMatricule());

            int rowUpdated = statement.executeUpdate();
            int rowUpdatedUser =statementUser.executeUpdate();
            return rowUpdatedUser>0 && rowUpdated>0;

        }catch (SQLException e){
            System.err.println("Erreur lors de la mis a jours du prof 😔!!");
            return false;
        }
    }

    public boolean supprimerProf(int matricule){
        if(!existe(matricule)){
            System.err.println("Prof non trouver !!");
            return false;
        }
        String queryProf = "DELETE FROM profs WHERE idProf = ?";
        String queryUsr = "DELETE FROM utilisateurs WHERE idUser = ?";

        try(Connection cnx = ConnectionDB.getConnection();
            PreparedStatement statementEtd = cnx.prepareStatement(queryProf);
            PreparedStatement statementUsr = cnx.prepareStatement(queryUsr)){

            statementEtd.setInt(1, matricule);
            int rowsDeletedProf = statementEtd.executeUpdate();

            statementUsr.setInt(1, matricule);
            int rowsDeletedUsr = statementUsr.executeUpdate();

            return rowsDeletedProf>0 && rowsDeletedUsr>0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}