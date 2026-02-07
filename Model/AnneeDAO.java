package Model;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnneeDAO {
    private Connection connection;

    public AnneeDAO(Connection connection) {
        this.connection = connection;
    }

    //marcheee
    public Annee recupererAnneeAvecSemestres(int idAnnee) throws SQLException {
        Annee annee = getAnneeById(idAnnee);
        if (annee != null) {
            String query = "SELECT * FROM semestres WHERE idAnnee = ? ORDER BY numero";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, idAnnee);
                ResultSet rs = stmt.executeQuery();

                int count = 0;
                while (rs.next() && count < 2) {
                    BigDecimal moyenneSemestre = rs.getBigDecimal("moyenneSemestre");

                    Semestre semestre = new Semestre(
                            rs.getInt("idSemestre"),
                            NumeroSemestre.fromString(rs.getString("numero")),
                            moyenneSemestre,
                            rs.getInt("idAnnee")
                    );

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
    

    // Marchee
    public boolean ajouterAnnee(Annee annee, int idEtudiant) throws SQLException {
        if (annee == null) {
            System.err.println("Annee est Null!!");
            return false;
        }

        int idAnnee = annee.getIdAnnee();
        if (idAnnee <= 0) {
            System.err.println("Invalid idAnnee: " + idAnnee);
            return false;
        }

        if (idEtudiant <= 0) {
            System.err.println("Invalid idEtudiant: " + idEtudiant);
            return false;
        }

        try {
            connection.setAutoCommit(false);

            String checkEtudiantQuery = "SELECT idSpecialite FROM etudiants WHERE idEtudiant = ?";
            int etudiantSpecialite;
            try (PreparedStatement checkEtudiantStmt = connection.prepareStatement(checkEtudiantQuery)) {
                checkEtudiantStmt.setInt(1, idEtudiant);
                ResultSet rs = checkEtudiantStmt.executeQuery();
                if (!rs.next()) {
                    System.err.println("Invalid idEtudiant: " + idEtudiant + " does not exist in etudiants");
                    return false;
                }
                etudiantSpecialite = rs.getInt("idSpecialite");
            }

            String checkSpecialiteQuery = "SELECT COUNT(*) FROM specialites WHERE idSpecialite = ?";
            try (PreparedStatement checkSpecialiteStmt = connection.prepareStatement(checkSpecialiteQuery)) {
                checkSpecialiteStmt.setInt(1, annee.getIdSpecialite());
                ResultSet rs = checkSpecialiteStmt.executeQuery();
                if (!rs.next() || rs.getInt(1) == 0) {
                    System.err.println("Invalid idSpecialite: " + annee.getIdSpecialite() + " does not exist in specialites");
                    return false;
                }
            }

            
            if (etudiantSpecialite != annee.getIdSpecialite()) {
                System.err.println("Specialite mismatch: Etudiant " + idEtudiant + " has idSpecialite " + etudiantSpecialite +
                        ", but Annee " + idAnnee + " has idSpecialite " + annee.getIdSpecialite());
                return false;
            }

            String checkAnneeQuery = "SELECT idEtudiant FROM annees WHERE idAnnee = ?";
            boolean anneeExists;
            int existingIdEtudiant = 0;
            try (PreparedStatement checkAnneeStmt = connection.prepareStatement(checkAnneeQuery)) {
                checkAnneeStmt.setInt(1, idAnnee);
                ResultSet rs = checkAnneeStmt.executeQuery();
                if (rs.next()) {
                    anneeExists = true;
                    existingIdEtudiant = rs.getInt("idEtudiant");
                    if (rs.wasNull()) {
                        existingIdEtudiant = 0;
                    }
                } else {
                    anneeExists = false;
                }
            }

            if (!anneeExists) {
                String insertAnneeQuery = "INSERT INTO annees (idAnnee, anneeScolaire, idEtudiant, idSpecialite, moyenneGenerale) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement insertAnneeStmt = connection.prepareStatement(insertAnneeQuery)) {
                    insertAnneeStmt.setInt(1, idAnnee);
                    insertAnneeStmt.setString(2, annee.getAnneeScolaire());
                    insertAnneeStmt.setInt(3, idEtudiant);
                    insertAnneeStmt.setInt(4, annee.getIdSpecialite());
                    insertAnneeStmt.setBigDecimal(5, annee.getmoyenneGenerale());
                    insertAnneeStmt.executeUpdate();
                }
                System.out.println("Annee " + idAnnee + " inserted into annees with idEtudiant=" + idEtudiant);
            } else if (existingIdEtudiant != 0 && existingIdEtudiant != idEtudiant) {
                
                System.err.println("Annee " + idAnnee + " is already assigned to Etudiant " + existingIdEtudiant);
                return false;
            } else if (existingIdEtudiant == 0) {
                
                String updateAnneeQuery = "UPDATE annees SET idEtudiant = ? WHERE idAnnee = ?";
                try (PreparedStatement updateAnneeStmt = connection.prepareStatement(updateAnneeQuery)) {
                    updateAnneeStmt.setInt(1, idEtudiant);
                    updateAnneeStmt.setInt(2, idAnnee);
                    updateAnneeStmt.executeUpdate();
                }
                System.out.println("Annee " + idAnnee + " updated with idEtudiant=" + idEtudiant);
            }
            
            associerAnneeAEtudiant(idEtudiant, idAnnee);

            connection.commit();
            System.out.println("Année ajoutée et associée avec succès !");
            return true;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de l'annee : " + e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                System.err.println("Erreur lors du rollback : " + rollbackEx.getMessage());
            }
            throw e;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                System.err.println("Erreur lors de la restauration de l'auto-commit : " + ex.getMessage());
            }
        }
    }

    //Marche
    private boolean anneeExists(String column, Object value) {
        List<String> allowedColumns = List.of("idAnnee", "anneeScolaire");
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

    // fait
    public List<Annee> getAllAnneesSorted() {
        List<Annee> annees = new ArrayList<>();
        String query = "SELECT * FROM annees ORDER BY anneeScolaire ASC";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Annee annee = new Annee(
                        resultSet.getInt("idAnnee"),
                        resultSet.getString("anneeScolaire"),
                        resultSet.getInt("idSpecialite"),
                        resultSet.getBigDecimal("moyenneGenerale"),
                        null,
                        null
                );
                annees.add(annee);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des années : " + e.getMessage());
        }
        return annees;
    }

    // Rahi temchi
    public List<Annee> getAnneesByEtudiantId(int idEtudiant) {
        List<Annee> annees = new ArrayList<>();
        String query = "SELECT a.* FROM annees a JOIN etudiants_annees ea ON a.idAnnee = ea.idAnnee WHERE ea.idEtudiant = ? ORDER BY a.anneeScolaire ASC";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idEtudiant);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Annee annee = new Annee(
                            resultSet.getInt("idAnnee"),
                            resultSet.getString("anneeScolaire"),
                            resultSet.getInt("idSpecialite"),
                            resultSet.getBigDecimal("moyenneGenerale"),
                            null,
                            null
                    );
                    annees.add(annee);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des années pour l'étudiant : " + e.getMessage());
        }
        return annees;
    }

    // temchiii
    public boolean deleteAnnee(int idAnnee) {
        if (!anneeExists("idAnnee", idAnnee)) {
            System.out.println("L'année avec ID " + idAnnee + " n'existe pas.");
            return false;
        }

        try {
            connection.setAutoCommit(false);

            String assocQuery = "DELETE FROM etudiants_annees WHERE idAnnee = ?";
            try (PreparedStatement assocStmt = connection.prepareStatement(assocQuery)) {
                assocStmt.setInt(1, idAnnee);
                assocStmt.executeUpdate();
            }
            
            String query = "DELETE FROM annees WHERE idAnnee = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, idAnnee);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    connection.commit();
                    System.out.println("Année supprimée avec succès !");
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'année : " + e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                System.err.println("Erreur lors du rollback : " + rollbackEx.getMessage());
            }
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                System.err.println("Erreur lors de la restauration de l'auto-commit : " + ex.getMessage());
            }
        }
        return false;
    }

    // haha :))
    public boolean updateAnnee(Annee annee) {
        if (!anneeExists("idAnnee", annee.getIdAnnee())) {
            System.out.println("L'année avec ID " + annee.getIdAnnee() + " n'existe pas.");
            return false;
        }

        String query = "UPDATE annees SET anneeScolaire = ?, idSpecialite = ?, moyenneGenerale = ? WHERE idAnnee = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, annee.getAnneeScolaire());
            statement.setInt(2, annee.getIdSpecialite());
            statement.setBigDecimal(3, annee.getmoyenneGenerale());
            statement.setInt(4, annee.getIdAnnee());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Année mise à jour avec succès !");
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de l'année : " + e.getMessage());
        }
        return false;
    }

    // :
    public boolean associerAnneeAEtudiant(int idEtudiant, int idAnnee) throws SQLException {
        if (!anneeExists("idAnnee", idAnnee)) {
            System.err.println("L'année avec ID " + idAnnee + " n'existe pas.");
            return false;
        }

        String checkEtudiantQuery = "SELECT COUNT(*) FROM etudiants WHERE idEtudiant = ?";
        try (PreparedStatement checkEtudiantStmt = connection.prepareStatement(checkEtudiantQuery)) {
            checkEtudiantStmt.setInt(1, idEtudiant);
            ResultSet rs = checkEtudiantStmt.executeQuery();
            if (!rs.next() || rs.getInt(1) == 0) {
                System.err.println("Invalid idEtudiant: " + idEtudiant + " does not exist in etudiants");
                return false;
            }
        }

        String checkDuplicateQuery = "SELECT COUNT(*) FROM etudiants_annees WHERE idEtudiant = ? AND idAnnee = ?";
        try (PreparedStatement checkDuplicateStmt = connection.prepareStatement(checkDuplicateQuery)) {
            checkDuplicateStmt.setInt(1, idEtudiant);
            checkDuplicateStmt.setInt(2, idAnnee);
            ResultSet rs = checkDuplicateStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.err.println("Annee " + idAnnee + " already assigned to Etudiant " + idEtudiant + " in etudiants_annees");
                return false;
            }
        }

        String query = "INSERT INTO etudiants_annees (idEtudiant, idAnnee) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idEtudiant);
            statement.setInt(2, idAnnee);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Année associée à l'étudiant avec succès !");
                return true;
            } else {
                throw new SQLException("Failed to insert into etudiants_annees");
            }
        }
    }

    // and yeahh
    public Annee getAnneeById(int idAnnee) {
        String query = "SELECT * FROM annees WHERE idAnnee = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idAnnee);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Annee(
                            resultSet.getInt("idAnnee"),
                            resultSet.getString("anneeScolaire"),
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