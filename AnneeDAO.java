package model;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnneeDAO {
 private Connection connection;

public AnneeDAO(Connection connection) {
	super();
	this.connection = connection;
}

// Méthode pour récupérer les semestres associés à une année
public Annee recupererAnneeAvecSemestres(int idAnnee) throws SQLException {
    // Récupérer l'année
    Annee annee = getAnneeById(idAnnee);
    if (annee != null) {
        String query = "SELECT * FROM semestres WHERE idAnnee = ? ORDER BY numero";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idAnnee);
            ResultSet rs = stmt.executeQuery();

            int count = 0;
            while (rs.next() && count < 2) {
                BigDecimal moyenneGenerale = rs.getBigDecimal("moyenneGenerale");

                Semestre semestre = new Semestre(
                    rs.getInt("idSemestre"),
                    NumeroSemestre.fromString(rs.getString("numero")),
                    moyenneGenerale,
                    rs.getInt("idAnnee")
                );

                // Affecter les semestres à l'année
                if (count == 0) {
                    annee.setSemestre1(semestre);
                } else {
                    annee.setSemestre2(semestre);
                }
                count++;
            }
        }
    }
    return annee;
}

public boolean addAnnee(Annee annee) {
	if(anneeExists("anneeScolaire",annee.getAnneeScolaire())) {
		System.out.println("l'année" +annee.getAnneeScolaire()+ "existe déjà" );
		return false;
	}
	String query = "INSERT INTO annees (idAnnee, anneeScolaire, idEtudiant, idSpecialite,moyenneGenerale ) VALUES (?, ?, ?, ?, ?)";
	try(PreparedStatement statement = connection.prepareStatement(query)){
		statement.setInt(1, annee.getIdAnnee());
		statement.setString(2, annee.getAnneeScolaire());
		statement.setInt(3, annee.getIdEtudiant());
		statement.setInt(4, annee.getIdSpecialite());
		statement.setBigDecimal(5, annee.getmoyenneGenerale());



		
		int rowsInserted = statement.executeUpdate();
		if( rowsInserted >0) {
			System.out.println("Année ajoutée avec succès!");
			return true;
		}
		
	}catch(SQLException e) {
		System.err.println("erreur lors de l'ajout de l'année" +e.getMessage());
	}
	return false;
}

private boolean anneeExists(String column, Object value) {
    List<String> allowedColumns = List.of("idAnnee", "anneeScolaire"); // Colonnes autorisées
    if (!allowedColumns.contains(column)) {
    	System.err.println("Tentative d'accès à une colonne non autorisée : " + column);
        return false;
    }

    String query = "SELECT COUNT(*) FROM annees WHERE " + column + " = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        if (value instanceof Integer) {
            statement.setInt(1, (Integer) value);
        } else {
            statement.setString(1, value.toString());
        }
        try (ResultSet resultSet = statement.executeQuery()) {
            return resultSet.next() && resultSet.getInt(1) > 0;
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de la vérification de l'année (" + column + " = " + value + ") : " + e.getMessage());
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
                    resultSet.getString("anneeScolaire"),
                    resultSet.getInt("idEtudiant"),
                    resultSet.getInt("idSpecialite"),
                    resultSet.getBigDecimal("moyenneGenerale"),

                    null,
                    null

            );
            annees.add(annee);
        }
    } catch (SQLException e) {
        System.err.println(" Erreur lors de la récupération des années : " + e.getMessage());
    }
    return annees;
}

public boolean deleteAnnee(int idAnnee) {
	if(!anneeExists("idAnnee" , idAnnee)) {
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
        System.err.println(" Erreur lors de la suppression : " + e.getMessage());
    }
    return false;
}

public boolean updateAnnee(Annee annee) {

	if (!anneeExists("idAnnee",annee.getIdAnnee())) {
        System.out.println(" L'année avec ID " + annee.getIdAnnee() + " n'existe pas.");
        return false;
    }
    String query = "UPDATE annees SET  anneeScolaire = ?, idEtudiant = ?, idSpecialite = ? moyenneGenerale = ? WHERE idAnnee = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, annee.getAnneeScolaire());
        statement.setInt(2, annee.getIdEtudiant());
        statement.setInt(3, annee.getIdSpecialite());
        statement.setBigDecimal(4, annee.getmoyenneGenerale()); 
        statement.setInt(5, annee.getIdAnnee());
        
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println(" Année mise à jour avec succès !");
            return true;
        }
    } catch (SQLException e) {
        System.err.println(" Erreur lors de la mise à jour de l'année : " + e.getMessage());
    }
    return false;
}

public Annee getAnneeById(int idAnnee) {
    String query = "SELECT * FROM annees WHERE idAnnee = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, idAnnee);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return new Annee(
                        resultSet.getInt("idAnnee"),
                        resultSet.getString("anneeScolaire"),
                        resultSet.getInt("idEtudiant"),
                        resultSet.getInt("idSpecialite"),
                        resultSet.getBigDecimal("moyenneGenerale"),

                        null,
                        null

                );
            }
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de la récupération de l'année : " + e.getMessage());
    }
    return null;
}
}
