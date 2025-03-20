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
        String query = "SELECT COUNT(*) FROM Etudiants WHERE idEtudiants = ?";
        try (PreparedStatement statement = cnx.prepareStatement(query)){
            statement.setInt(1, matricule);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                return result.getInt(1)>0;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean ajouterProf(Prof prof){
        String query = "INSERT INTO etudiants (idProf, specialite, grade, departement) " +
                "VALUES (?, ?, ?, ?)";

        try(Connection cnx = ConnectionDB.getConnection()){
            cnx.setAutoCommit(false);

            if(!ajouterUtilisateur(prof)){
                cnx.rollback();
                return false;
            }
            try(PreparedStatement statement = cnx.prepareStatement(query)){
                statement.setInt(1, prof.getMatricule());
                statement.setString(2, prof.getSpecialite());
                statement.setString(3,prof.getGrade());
                statement.setString(4, prof.getDepartement());
                statement.executeUpdate();
            }
            cnx.commit();
            System.out.println("Prof ajouter avec succes ! 😊");
            return true;
        }catch (SQLException e){
            System.err.println("une erreur lors de l'ajout du nouveau Prof !!😔");
        }
        return false;
    }

    public Prof getProfByMat(int matricule){
        String query = "SELECT u.nom, u.prenom, u.email, p.specialite, p.grade, p.departement "+
                "FROM utilisaures u "+
                "JOIN profs p ON u.idUser = idProf "+
                "WHERE e.idProf = ?";

        try(Connection cnx = ConnectionDB.getConnection();
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


}