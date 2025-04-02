package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnneeDAO {
 private Connection connection;

public AnneeDAO(Connection connection) {
	super();
	this.connection = connection;
}
 
public boolean addAnnee(Annee annee) {
	if(anneeExists(annee.getAnneeScolaire())) {
		System.out.println("cette annee" +annee.getAnneeScolaire()+ "existe deja" );
		return false;
	}
	String query = "INSERT INTO annees (idAnnee, moyGeneral, methodeCalcul, anneeScolaire) VALUES (?, ?, ?, ?)";
	try(PreparedStatement statement = connection.prepareStatement(query)){
		statement.setInt(1, annee.getIdAnnee());
		statement.setBigDecimal(2, annee.getMoyGeneral());
		statement.setString(3, annee.getMethodeCalcul());
		statement.setString(4, annee.getAnneeScolaire());
		
		int rowsInserted = statement.executeUpdate();
		if( rowsInserted >0) {
			System.out.println("annee ajoutee avec succes!");
			return true;
		}
		
	}catch(SQLException e) {
		System.out.println("erreur lors de l'ajout de l'annee" +e.getMessage());
	}
	return false;
}
public boolean anneeExists(String anneeScolaire) {
    String query = "SELECT COUNT(*) FROM annees WHERE anneeScolaire = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, anneeScolaire);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                return true; 
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; 
}

public List<Annee> getAllAnneesSorted() {
    List<Annee> annees = new ArrayList<>();
    String query = "SELECT * FROM annees ORDER BY anneeScolaire ASC";
    try (PreparedStatement statement = connection.prepareStatement(query);
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {
            Annee annee = new Annee(
                    resultSet.getInt("idAnnee"),
                    resultSet.getBigDecimal("moyGeneral"),
                    resultSet.getString("methodeCalcul"),
                    resultSet.getString("anneeScolaire")
            );
            annees.add(annee);
        }
    } catch (SQLException e) {
        System.out.println(" Erreur lors de la récupération des années : " + e.getMessage());
    }
    return annees;
}

public boolean deleteAnnee(int idAnnee) {
	if(!anneeExistsById(idAnnee)) {
		System.out.println("l'annee avec ID" +idAnnee+ "n'existe pas");
		return false;
	}
    String query = "DELETE FROM annees WHERE idAnnee = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, idAnnee);
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println(" Année supprimée avec succès !");
            return true;
        }
        
    } catch (SQLException e) {
        System.out.println(" Erreur lors de la suppression : " + e.getMessage());
    }
    return false;
}
private boolean anneeExistsById(int idAnnee) {
    String query = "SELECT COUNT(*) FROM annees WHERE idAnnee = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, idAnnee);
        try (ResultSet resultSet = statement.executeQuery()) {
            return resultSet.next() && resultSet.getInt(1) > 0;
        }
    } catch (SQLException e) {
        System.out.println(" Erreur lors de la vérification de l'ID de l'année : " + e.getMessage());
    }
    return false;
}


public boolean updateAnnee(Annee annee) {
	if (!anneeExistsById(annee.getIdAnnee())) {
        System.out.println(" L'année avec ID " + annee.getIdAnnee() + " n'existe pas.");
        return false;
    }
    String query = "UPDATE annees SET moyGeneral = ?, methodeCalcul = ?, anneeScolaire = ? WHERE idAnnee = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setBigDecimal(1, annee.getMoyGeneral()); 
        statement.setString(2, annee.getMethodeCalcul());
        statement.setString(3, annee.getAnneeScolaire());
        statement.setInt(4, annee.getIdAnnee());
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println(" Année mise à jour avec succès !");
            return true;
        }
    } catch (SQLException e) {
        System.out.println(" Erreur lors de la mise à jour de l'année : " + e.getMessage());
    }
    return false;
}
}

