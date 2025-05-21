package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class TestExamDAO {

    private Connection connection;

    public TestExamDAO(Connection connection) {
        this.connection = connection;
    }

    // Méthode pour vérifier si un Test ou un Examen existe déjà pour cette date et heure
    private boolean testExamExiste(Date date, Time heure, TypeTestExam type) throws SQLException {
        String sql = "SELECT COUNT(*) FROM testsexams WHERE date = ? AND heure = ? AND type = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, date);
            stmt.setTime(2, heure);
            stmt.setString(3, type.name());  // Le type est un Enum, donc on doit le convertir en chaîne
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }

    // Méthode pour vérifier qu'il n'y a pas déjà 2 tests ou 2 examens pour cette date
    private boolean verifMaxTestExamParDate(Date date, TypeTestExam type) throws SQLException {
        String sql = "SELECT COUNT(*) FROM testsexams WHERE date = ? AND type = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, date);
            stmt.setString(2, type.name());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) < 2;  // Si moins de 2, on peut ajouter
            }
        }
        return false;  // Si il y en a déjà 2, on ne peut pas en ajouter
    }

    // Méthode pour ajouter un Test ou un Examen
    public boolean ajouterTestExam(TestExam testExam) throws SQLException {
        if (testExamExiste(testExam.getDate(), testExam.getHeure(), testExam.getType())) {
            return false;  // Si le Test ou l'Examen existe déjà à cette date et heure, on retourne false
        }
        if (!verifMaxTestExamParDate(testExam.getDate(), testExam.getType())) {
            return false;  // Si il y a déjà 2 Tests ou Examens pour cette date, on retourne false
        }

        String sql = "INSERT INTO testsexams (idTestExam, type, date, heure, idModule, idProf, section, groupe, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, testExam.getIdTestExam());
            stmt.setString(2, testExam.getType().name());  // Convertir l'énum en String
            stmt.setDate(3, testExam.getDate());
            stmt.setTime(4, testExam.getHeure());
            stmt.setInt(5, testExam.getIdModule());
            stmt.setInt(6, testExam.getIdProf());
            stmt.setString(7, testExam.getSection());
            stmt.setString(8, testExam.getGroupe());
            stmt.setString(9, testExam.getDescription());
            return stmt.executeUpdate() > 0;
        }
    }
    public TestExam getTestExamParId(int idTestExam) throws SQLException {
        String sql = "SELECT * FROM testsexams WHERE idTestExam = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idTestExam);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new TestExam(
                        rs.getInt("idTestExam"),
                        TypeTestExam.valueOf(rs.getString("type")),
                        rs.getDate("date"),
                        rs.getTime("heure"),
                        rs.getInt("idModule"),
                        rs.getInt("idProf"),
                        rs.getString("section"),
                        rs.getString("groupe"),
                        rs.getString("description")
                );
            } else {
                throw new SQLException("Test/Examen avec l'ID " + idTestExam + " n'a pas été trouvé.");
            }
        }
    }

    // Méthode pour récupérer tous les tests/examens
    public List<TestExam> getAllTestExams() throws SQLException {
        List<TestExam> testExams = new ArrayList<>();
        String sql = "SELECT * FROM testsexams";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                testExams.add(new TestExam(
                        rs.getInt("idTestExam"),
                        TypeTestExam.valueOf(rs.getString("type")),
                        rs.getDate("date"),
                        rs.getTime("heure"),
                        rs.getInt("idModule"),
                        rs.getInt("idProf"),
                        rs.getString("section"),
                        rs.getString("groupe"),
                        rs.getString("description")
                ));
            }
        }
        return testExams;
    }

    // Méthode pour supprimer un Test/Examen par ID
    public boolean supprimerTestExam(int idTestExam) throws SQLException {
        String sql = "DELETE FROM testsexams WHERE idTestExam = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idTestExam);
            return stmt.executeUpdate() > 0;
        }
    }
    
    
 // Méthode pour modifier la date et l'heure d'un test ou examen
    public boolean modifierTestExamDateHeure(int idTestExam, Date newDate, Time newHeure) throws SQLException {
        // Vérifier s'il y a déjà un Test/Examen à cette date et cette heure
        if (testExamExiste(newDate, newHeure, TypeTestExam.valueOf("TEST")) ||
            testExamExiste(newDate, newHeure, TypeTestExam.valueOf("EXAM"))) {
            return false;  // Si un Test ou Examen existe déjà à cette date et heure, on ne modifie pas
        }

        String sql = "UPDATE testsexams SET date = ?, heure = ? WHERE idTestExam = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, newDate);
            stmt.setTime(2, newHeure);
            stmt.setInt(3, idTestExam);
            return stmt.executeUpdate() > 0;
        }
    }

 // Méthode pour obtenir tous les tests/examens d'une date spécifique
    public List<TestExam> getAllTestExamsParDate(Date date) throws SQLException {
        List<TestExam> testExams = new ArrayList<>();
        String sql = "SELECT * FROM testsexams WHERE date = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, date);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                testExams.add(new TestExam(
                        rs.getInt("idTestExam"),
                        TypeTestExam.valueOf(rs.getString("type")),
                        rs.getDate("date"),
                        rs.getTime("heure"),
                        rs.getInt("idModule"),
                        rs.getInt("idProf"),
                        rs.getString("section"),
                        rs.getString("groupe"),
                        rs.getString("description")
                ));
            }
        }
        return testExams;
    }

 // Méthode pour obtenir un Test/Examen à une date spécifique, pour un module et un professeur donnés
    public TestExam getTestExamParDateModuleProf(Date date, int idModule, int idProf) throws SQLException {
        String sql = "SELECT * FROM testsexams WHERE date = ? AND idModule = ? AND idProf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, date);
            stmt.setInt(2, idModule);
            stmt.setInt(3, idProf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new TestExam(
                        rs.getInt("idTestExam"),
                        TypeTestExam.valueOf(rs.getString("type")),
                        rs.getDate("date"),
                        rs.getTime("heure"),
                        rs.getInt("idModule"),
                        rs.getInt("idProf"),
                        rs.getString("section"),
                        rs.getString("groupe"),
                        rs.getString("description")
                );
            }
        }
        return null;
    }

}
