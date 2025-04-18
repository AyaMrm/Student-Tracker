package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfDAO extends UtilisateurDAO {

    public ProfDAO(Connection cnx) {
        super(cnx);
        if (cnx == null) {
            throw new IllegalArgumentException("Y a un probleme dans la conexion!!!");
        }
    }

    public boolean existe(int matricule) {
        String requette = "SELECT COUNT(*) FROM Profs WHERE idProf=?";
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

    public boolean ajouterProf(Prof prof) {
        String query = "INSERT INTO profs (idProf, idSpecialite, grade, departement) VALUES (?, ?, ?, ?)";

        try //(Connection cnx = ConnectionDB.getConnection())
        {
            cnx.setAutoCommit(false);

            String checkSpecialite = "SELECT COUNT(*) FROM specialites WHERE idSpecialite=?";
            try (PreparedStatement checkStmt = cnx.prepareStatement(checkSpecialite)) {
                checkStmt.setInt(1, prof.getIdSpecialite());
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next() && rs.getInt(1) == 0) {
                    System.err.println("Erreur : idSpecialite " + prof.getIdSpecialite() + " n'existe pas dans specialites !");
                    return false;
                }
            }

            Auth auth = new Auth(cnx);
            if (!auth.ajouterUtilisateur(new Utilisateur(prof.getIdProf(), prof.getNom(), prof.getPrenom(), prof.getEmail(), prof.getMotdepasse(), Role.PROF), prof.getMotdepasse())) {
                cnx.rollback();
                System.err.println("Erreur lors de l'ajout de l'utilisateur !");
                return false;
            }

            try (PreparedStatement statement = cnx.prepareStatement(query)) {
                statement.setInt(1, prof.getIdProf());
                statement.setInt(2, prof.getIdSpecialite());
                statement.setString(3, prof.getGrade());
                statement.setString(4, prof.getDepartement());
                statement.executeUpdate();
            }

            cnx.commit();
            //System.out.println("Prof ajouté avec succès ! 😊");
            return true;
        } catch (SQLException e) {
            //System.err.println("Une erreur est survenue lors de l'ajout du nouveau Prof !! 😔");
            //e.printStackTrace();
            try {
                if (cnx != null && !cnx.isClosed()) {
                    cnx.rollback();
                }
            } catch (SQLException ex) {
                //ex.printStackTrace();
            }
            return false;
        }
    }

    public Prof getProfByMat(int matricule){
        String query = "SELECT u.nom, u.prenom, u.email, p.idSpecialite, p.grade, p.departement "+
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
                int idSpecialite = result.getInt("idSpecialite");
                String grade = result.getString("grade");
                String departement = result.getString("departement");

                return new Prof(matricule, nom, prenom, email, idSpecialite, grade, departement);
            }
        }catch (SQLException e){
            //System.err.println("aucune prof trouver avec le matricule "+ matricule+" 😔!!");
        }
        return null;
    }

    public ArrayList<Prof> getProfsByNom(String nom){
        ArrayList<Prof> profs = new ArrayList<>();
        String query = "SELECT u.idUser, u.nom, u.prenom, u.email, p.idSpecialite, p.grade, p.departement "+
                "FROM utilisateurs u "+
                "JOIN profs p ON u.idUser = p.idProf "+
                "WHERE u.nom = ?";

        try(//Connection cnx = ConnectionDB.getConnection();
            PreparedStatement statement = cnx.prepareStatement(query)){
            statement.setString(1, nom);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                int matricule = result.getInt("idUser");
                String prenom = result.getString("prenom");
                String email = result.getString("email");
                int idSpecialite =  result.getInt("idSpecialite");
                String grade = result.getString("grade");
                String departement = result.getString("departement");

                Prof p = new Prof(matricule, nom, prenom, email, idSpecialite, grade, departement);
                profs.add(p);
            }
        }catch(SQLException e){
            //System.err.println("Erreur lors de la recherche du prof avec le nom "+nom+" 😔!!");
        }
        return profs;
    }

    public ArrayList<Prof> getProfBySpecialite(String specialite) {
        ArrayList<Prof> profs = new ArrayList<>();
        String query = "SELECT u.idUser, u.nom, u.prenom, u.email, s.idSpecialite, p.grade, p.departement " +
                "FROM utilisateurs u " +
                "JOIN profs p ON u.idUser = p.idProf " +
                "JOIN specialites s ON p.idSpecialite = s.idSpecialite " +
                "WHERE s.nomSpecialite = ?";

        try (//Connection cnx = ConnectionDB.getConnection();
             PreparedStatement statement = cnx.prepareStatement(query)) {
            statement.setString(1, specialite);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int idUser = result.getInt("idUser");
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");
                String email = result.getString("email");
                int idSpecialite = result.getInt("idSpecialite");
                String grade = result.getString("grade");
                String departement = result.getString("departement");

                Prof p = new Prof(idUser, nom, prenom, email, idSpecialite, grade, departement);
                profs.add(p);
            }
        } catch (SQLException e) {
            //System.err.println("Erreur lors de la recherche des profs avec spécialité " + specialite + " : " + e.getMessage());
            //e.printStackTrace();
        }
        return profs;
    }

    public ArrayList<Prof> getProfByGrade(String grade){
        ArrayList<Prof> profs = new ArrayList<>() ;

        String query = "SELECT u.idUser, u.nom, u.prenom, u.email, p.idSpecialite, p.grade, p.departement "+
                "FROM utilisateurs u "+
                "JOIN profs p ON u.idUser = p.idProf "+
                "WHERE p.grade = ?";

        try(//Connection cnx = ConnectionDB.getConnection();
            PreparedStatement statement = cnx.prepareStatement(query)){
            statement.setString(1, grade);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                int matricule = result.getInt("idUser");
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");
                String email = result.getString("email");
                int  idSpecialite = result.getInt("idSpecialite");
                String departement = result.getString("departement");

                Prof p = new Prof(matricule, nom, prenom, email, idSpecialite, grade, departement);
                profs.add(p);
            }
        }catch (SQLException e){
            //System.err.println("Erreur lors de la recherche des profs avec grade "+grade+" 😔!!");
        }
        return profs;
    }

    public ArrayList<Prof> getProfByDepartement(String departement){
        ArrayList<Prof> profs = new ArrayList<>();
        String query = "SELECT u.idUser, u.nom, u.prenom, u.email, p.idSpecialite, p.grade, p.departement "+
                "FROM utilisateurs u "+
                "JOIN profs p ON u.idUser = idProf "+
                "WHERE p.departement = ?";
        try(//Connection cnx = ConnectionDB.getConnection();
            PreparedStatement statement = cnx.prepareStatement(query)){
            statement.setString(1, departement);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                int matricule = result.getInt("idUser");
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");
                String email = result.getString("email");
                int idSpecialite = result.getInt("idSpecialite");
                String grade = result.getString("grade");

                Prof p = new Prof(matricule, nom, prenom, email, idSpecialite, grade, departement);
                profs.add(p);
            }
        }catch(SQLException e){
            //System.err.println("Erreur lors de la recherche des profs avec grade "+departement+" 😔!!");
        }
        return profs;
    }

    public ArrayList<Prof> getAllProfs(){
        ArrayList<Prof> all = new ArrayList<>();
        String query = "SELECT u.idUser, u.nom, u.prenom, u.email, p.idSpecialite, p.grade, p.departement "+
                "FROM utilisateurs u "+
                "JOIN profs p ON u.idUser = p.idProf";

        try(//Connection cnx = ConnectionDB.getConnection();
            PreparedStatement statement = cnx.prepareStatement(query)){
            ResultSet result = statement.executeQuery();
            while(result.next()){
                int matricule = result.getInt("idUser");
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");
                String email = result.getString("email");
                int idSpecialite = result.getInt("idSpecialite");
                String grade = result.getString("grade");
                String departement = result.getString("departement");

                Prof p= new Prof(matricule, nom, prenom, email, idSpecialite, grade, departement);
                all.add(p);
            }
        }catch (SQLException e){
            System.err.println("Erreur lors de la recherche des profs 😔!!");
        }
        return all;
    }

    public boolean modifierProf(Prof prof) {
        String updateProfQuery = "UPDATE profs SET idSpecialite = ?, grade = ?, departement = ? WHERE idProf = ?";

        SpecialiteDAO specialiteDAO = new SpecialiteDAO(cnx);
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(cnx);

        try {
            if (!specialiteDAO.specialiteExiste(prof.getIdSpecialite())) {
                System.out.println("❌ La spécialité avec l'ID " + prof.getIdSpecialite() + " n'existe pas.");
                return false;
            }

            Utilisateur utilisateur = new Utilisateur(
                    prof.getIdUser(),
                    prof.getNom(),
                    prof.getPrenom(),
                    prof.getEmail(),
                    Role.PROF
            );

            if (!utilisateurDAO.modifierUtilisateur(utilisateur)) {
                //System.out.println("❌ Échec de la mise à jour de l'utilisateur associé.");
                return false;
            }

            try (PreparedStatement stmt = cnx.prepareStatement(updateProfQuery)) {
                stmt.setInt(1, prof.getIdSpecialite());
                stmt.setString(2, prof.getGrade());
                stmt.setString(3, prof.getDepartement());
                stmt.setInt(4, prof.getIdProf());

                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;

            } catch (SQLException e) {
                //System.err.println("❌ Erreur lors de la mise à jour de la table 'profs' : " + e.getMessage());
                return false;
            }

        } catch (SQLException e) {
            //System.err.println("❌ Erreur lors des vérifications initiales : " + e.getMessage());
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