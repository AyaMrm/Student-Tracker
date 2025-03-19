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


}
