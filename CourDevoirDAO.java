package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CourDevoirDAO {

	private Connection connection;

    public CourDevoirDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean courDevoirExiste(int idCoursDevoirs) throws SQLException {
        String sql = "SELECT 1 FROM coursdevoirs WHERE idCoursDevoirs = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idCoursDevoirs);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }

    public boolean ajouterCourDevoir(CourDevoir cd) throws SQLException {
        if (courDevoirExiste(cd.getIdCoursDevoirs())) return false;

        String sql = "INSERT INTO coursdevoirs (idCoursDevoirs, message, coursEnPDF, type ,idProf, idModule, devoirDone, idEtudiant, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cd.getIdCoursDevoirs());
            stmt.setString(2, cd.getMessage());
            stmt.setString(3, cd.getCoursEnPDF());
            stmt.setString(4, cd.getType().name());  // Enregistrer le type sous forme de String
            stmt.setInt(5, cd.getIdProf());
            stmt.setInt(6, cd.getIdModule());
            stmt.setBoolean(7, cd.isDevoirDone());
            stmt.setInt(8, cd.getIdEtudiant());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean modifierCourDevoir(CourDevoir cd) throws SQLException {
        if (!courDevoirExiste(cd.getIdCoursDevoirs())) return false;

        String sql = "UPDATE coursdevoirs SET message = ?, coursEnPDF = ?, type =? idProf = ?, idModule = ?, devoirDone = ?, idEtudiant = ? WHERE idCoursDevoirs = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cd.getMessage());
            stmt.setString(2, cd.getCoursEnPDF());
            stmt.setString(3, cd.getType().name());  // Mettre à jour le type
            stmt.setInt(4, cd.getIdProf());
            stmt.setInt(5, cd.getIdModule());
            stmt.setBoolean(6, cd.isDevoirDone());
            stmt.setInt(7, cd.getIdEtudiant());
            stmt.setInt(8, cd.getIdCoursDevoirs());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean supprimerCourDevoir(int idCoursDevoirs) throws SQLException {
        if (!courDevoirExiste(idCoursDevoirs)) return false;

        String sql = "DELETE FROM coursdevoirs WHERE idCoursDevoirs = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idCoursDevoirs);
            return stmt.executeUpdate() > 0;
        }
    }

    //chercher un cour ou devoirs b son ID
    public CourDevoir getCourPdfParId(int idCoursDevoirs) throws SQLException {
        String sql = "SELECT * FROM coursdevoirs WHERE idCoursDevoirs = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idCoursDevoirs);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractCourDevoir(rs);
            }
        }
        return null;
    }

    
    //liste tae les cours d'un prof 
    public List<CourDevoir> getCourDevoirParModuleEtProf(int idModule, int idProf) throws SQLException {
        List<CourDevoir> liste = new ArrayList<>();
        String sql = "SELECT * FROM coursdevoirs WHERE idModule = ? AND idProf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idModule);
            stmt.setInt(2, idProf);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                liste.add(extractCourDevoir(rs));
            }
        }
        return liste;
    }

    // return les devoirs li darhom etudiant 
    public List<CourDevoir> getCourDevoirDoneParEtudiant(int idEtudiant) throws SQLException {
        List<CourDevoir> liste = new ArrayList<>();
        String sql = "SELECT * FROM coursdevoirs WHERE idEtudiant = ? AND devoirDone = true";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idEtudiant);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                liste.add(extractCourDevoir(rs));
            }
        }
        return liste;
    }

    private CourDevoir extractCourDevoir(ResultSet rs) throws SQLException {
        return new CourDevoir(
                rs.getInt("idCoursDevoirs"),
                rs.getString("message"),
                rs.getString("coursEnPDF"),
                TypeCourDevoir.valueOf(rs.getString("type")) , // Convertir le type en enum
                rs.getInt("idProf"),
                rs.getInt("idModule"),
                rs.getBoolean("devoirDone"),
                rs.getInt("idEtudiant")
        );
    }
}
