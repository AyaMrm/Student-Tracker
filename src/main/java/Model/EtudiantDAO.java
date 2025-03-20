package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

public class EtudiantDAO extends UtilisateurDAO{
    public EtudiantDAO(){
        super();
    }

    @Override
    public boolean existe(int matricule) {
        String requette = "SELECT COUNT(*) FROM Etudiants WHERE idEtudiant=?";
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

    public boolean ajouterEtudiant(Etudiant etudiant){
        String queryEtudiant = "INSERT INTO etudiants (idEtudiant, specialite, section, groupe, idAnnee, idEmploiDuTemps) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection cnx = ConnectionDB.getConnection()) {
            cnx.setAutoCommit(false);


            if (!ajouterUtilisateur(etudiant)) {
                cnx.rollback();
                return false;
            }


            try (PreparedStatement stmtEtudiant = cnx.prepareStatement(queryEtudiant)) {
                stmtEtudiant.setInt(1, etudiant.getMatricule());
                stmtEtudiant.setString(2, etudiant.getSpecialite());
                stmtEtudiant.setString(3, etudiant.getSection());
                stmtEtudiant.setString(4, etudiant.getGroupe());
                // ces 2 a modifier apres faire les classes necessaire !
                //stmtEtudiant.setInt(5, etudiant.getIdAnnee());
                stmtEtudiant.setNull(5, java.sql.Types.INTEGER);
                //stmtEtudiant.setInt(6, etudiant.getIdEmploiDuTemps());
                stmtEtudiant.setNull(6, java.sql.Types.INTEGER);

                stmtEtudiant.executeUpdate();
            }

            cnx.commit();
            System.out.println("✅ etudiant ajoute avec succes !");
            return true;
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de l'ajout de l'etudiant : " + e.getMessage());
            return false;
        }
    }

    public Etudiant getEtudiantByMat(int matricule){
        String query = "SELECT u.nom, u.prenom, u.email, e.specialite, e.section, e.groupe, e.idAnnee, e.idEmploiDuTemps " +
                "FROM utilisateurs u " +
                "JOIN etudiants e ON u.idUser = e.idEtudiant " +
                "WHERE e.idEtudiant = ?";

        try (Connection cnx = ConnectionDB.getConnection();
             PreparedStatement statement = cnx.prepareStatement(query)) {

            statement.setInt(1, matricule);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String specialite = rs.getString("specialite");
                String section = rs.getString("section");
                String groupe = rs.getString("groupe");
                int idAnnee = rs.getInt("idAnnee");
                int idEmploiDuTemps = rs.getInt("idEmploiDuTemps");

                return new Etudiant(matricule, nom, prenom, email, specialite, section, groupe, idAnnee, idEmploiDuTemps);
            } else {
                System.out.println("⚠ Aucun étudiant trouvé avec le matricule : " + matricule);
            }

        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la récupération de l'étudiant : " + e.getMessage());
        }
        return null;
    }

    public ArrayList<Etudiant> getEtudiantByNom(String nom) {
        ArrayList<Etudiant> etudiants = new ArrayList<>();

        String query = "SELECT u.idUser, u.prenom, u.email, e.specialite, e.section, e.groupe, e.idAnnee, e.idEmploiDuTemps " +
                "FROM utilisateurs u " +
                "JOIN etudiants e ON u.idUser = e.idEtudiant " +
                "WHERE u.nom = ?";

        try (Connection cnx = ConnectionDB.getConnection();
             PreparedStatement statement = cnx.prepareStatement(query)) {

            statement.setString(1, nom);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int matricule = rs.getInt("idUser");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String specialite = rs.getString("specialite");
                String section = rs.getString("section");
                String groupe = rs.getString("groupe");
                int idAnnee = rs.getInt("idAnnee");
                int idEmploiDuTemps = rs.getInt("idEmploiDuTemps");

                etudiants.add(new Etudiant(matricule, nom, prenom, email, specialite, section, groupe, idAnnee, idEmploiDuTemps));
            }

        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la récupération des étudiants : " + e.getMessage());
        }

        return etudiants;
    }

    public ArrayList<Etudiant> getAllEtudiants(){
        ArrayList<Etudiant> etudiants = new ArrayList<>();

        String query = "SELECT u.idUser, u.nom, u.prenom, u.email, e.specialite, e.section, e.groupe, e.idAnnee, e.idEmploiDuTemps " +
                "FROM utilisateurs u " +
                "JOIN etudiants e ON u.idUser = e.idEtudiant";

        try (Connection cnx = ConnectionDB.getConnection();
             PreparedStatement statement = cnx.prepareStatement(query);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                int matricule = rs.getInt("idUser");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String specialite = rs.getString("specialite");
                String section = rs.getString("section");
                String groupe = rs.getString("groupe");
                int idAnnee = rs.getInt("idAnnee");
                int idEmploiDuTemps = rs.getInt("idEmploiDuTemps");

                // Ajouter l'étudiant à la liste
                etudiants.add(new Etudiant(matricule, nom, prenom, email, specialite, section, groupe, idAnnee, idEmploiDuTemps));
            }

        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la récupération des étudiants : " + e.getMessage());
        }


        return etudiants;
    }

    public ArrayList<Etudiant> getEtudiantsBySpecialite(String specialite){
        ArrayList<Etudiant> etd = new ArrayList<>();
        String query = "SELECT u.idUser, u.nom, u.prenom, u.email, e.specialite, e.section, e.groupe, e.idAnnee, e.idEmploiDuTemps "+
                "FROM utilisateurs u "+
                "JOIN etudiants e ON u.idUser = e.idEtudiant "+
                "WHERE e.specialite = ?";
        try(Connection cnx = ConnectionDB.getConnection();
        PreparedStatement statement = cnx.prepareStatement(query)) {
            statement.setString(1, specialite);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                int matricule = result.getInt("idUser");
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");
                String email = result.getString("email");
                String section = result.getString("section");
                String groupe = result.getString("groupe");
                int idAnnee = result.getInt("idAnnee");
                int idEmploiDuTemps = result.getInt("idEmploiDuTemps");

                Etudiant e = new Etudiant(matricule, nom, prenom, email, specialite, section, groupe, idAnnee, idEmploiDuTemps);
                etd.add(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return etd;
    }

    public ArrayList<Etudiant> getEtudiantsBySection(String specialite, String section){
        ArrayList<Etudiant> etd = new ArrayList<>();

        String query = "SELECT u.idUser, u.nom, u.prenom, u.email, e.specialite, e.section, e.groupe, e.idAnnee, e.idEmploiDuTemps " +
                "FROM utilisateurs u " +
                "JOIN etudiants e ON u.idUser = e.idEtudiant " +
                "WHERE e.specialite = ? AND e.section = ?";


        try(Connection cnx = ConnectionDB.getConnection();
        PreparedStatement statement = cnx.prepareStatement(query)){
            statement.setString(1, specialite);
            statement.setString(2, section);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                int matricule = result.getInt("idUser");
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");
                String email = result.getString("email");
                //String specialite = result.getString("specialite");
                String groupe = result.getString("groupe");
                int idAnnee = result.getInt("idAnnee");
                int idEmploiDuTemps = result.getInt("idEmploiDuTemps");

                Etudiant e = new Etudiant(matricule, nom, prenom, email, specialite,section, groupe, idAnnee, idEmploiDuTemps);
                etd.add(e);
            }
        }catch (SQLException e){
            System.err.println("Une erreur est survenu lors de la recherche d'etudiants ! 😔");
        }

        return etd;
    }

    public ArrayList<Etudiant> getEtudiantsByGroupe(String specialite, String section, String groupe){
        ArrayList<Etudiant> etd = new ArrayList<>();

        String query = "SELECT u.idUser, u.nom, u.prenom, u.email, e.specialite, e.section, e.groupe, e.idAnnee, e.idEmploiDuTemps "+
                "FROM utilisateurs u "+
                "JOIN etudiants e ON idUser = idEtudiant "+
                "WHERE e.specialite = ? AND e.section = ? AND e.groupe = ? ";

        try(Connection cnx = ConnectionDB.getConnection();
        PreparedStatement statement = cnx.prepareStatement(query)){
            statement.setString(1, specialite);
            statement.setString(2, section);
            statement.setString(3, groupe);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                int matricule =result.getInt("idUser");
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");
                String email = result.getString("email");
                int idAnnee = result.getInt("idAnnee");
                int idEmploiDuTemps = result.getInt("idEmploiDuTemps");

                Etudiant e = new Etudiant(matricule, nom, prenom, email, specialite, section, groupe, idAnnee, idEmploiDuTemps);
                etd.add(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return etd;
    }

    public boolean modifierEtudiant(Etudiant etudiant) {
        String query = "UPDATE etudiants SET specialite = ?, section = ?, groupe = ?, idAnnee = ?, idEmploiDuTemps = ? WHERE idEtudiant = ?";
        String queryUser = "UPDATE utilisateurs SET nom = ?, prenom = ?, email = ? WHERE idUser = ?";

        try (Connection cnx = ConnectionDB.getConnection();
             PreparedStatement statementEtd = cnx.prepareStatement(query);
             PreparedStatement statementUser = cnx.prepareStatement(queryUser)) {

            statementEtd.setString(1, etudiant.getSpecialite());
            statementEtd.setString(2, etudiant.getSection());
            statementEtd.setString(3, etudiant.getGroupe());
            statementEtd.setInt(4, etudiant.getIdAnnee());
            statementEtd.setInt(5, etudiant.getIdEmploiDuTemps());
            statementEtd.setInt(6, etudiant.getMatricule());

            statementUser.setString(1, etudiant.getNom());
            statementUser.setString(2, etudiant.getPrenom());
            statementUser.setString(3, etudiant.getEmail());
            statementUser.setInt(4, etudiant.getMatricule());

            int rowsUpdatedEtd = statementEtd.executeUpdate();
            int rowsUpdatedUser = statementUser.executeUpdate();

            return rowsUpdatedEtd > 0 && rowsUpdatedUser > 0;

        } catch (SQLException e) {
            System.err.println("Erreur lors de la modification de l'étudiant : " + e.getMessage());
            return false;
        }
    }

    public boolean supprimerEtudiant(int matricule){
        if(!existe(matricule)){
            System.err.println("Etudiant non trouver !!");
            return false;
        }
        String queryEtd = "DELETE FROM etudiants WHERE idEtudiant = ?";
        String queryUsr = "DELETE FROM utilisateurs WHERE idUser = ?";

        try(Connection cnx = ConnectionDB.getConnection();
        PreparedStatement statementEtd = cnx.prepareStatement(queryEtd);
        PreparedStatement statementUsr = cnx.prepareStatement(queryUsr)){

            statementEtd.setInt(1, matricule);
            int rowsDeletedEtd = statementEtd.executeUpdate();

            statementUsr.setInt(1, matricule);
            int rowsDeletedUsr = statementUsr.executeUpdate();

            return rowsDeletedEtd>0 && rowsDeletedUsr>0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
