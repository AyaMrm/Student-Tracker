package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfModuleDAO {
	private Connection connection;

    public ProfModuleDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean existeRelation(int idProf, int idModule) throws SQLException {
        String sql = "SELECT 1 FROM profs_modules WHERE idProf = ? AND idModule = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idProf);
            stmt.setInt(2, idModule);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }

    public boolean ajouterRelation(int idProf, int idModule) throws SQLException {
        if (existeRelation(idProf, idModule)) return false;

        String sql = "INSERT INTO profs_modules (idProf, idModule) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idProf);
            stmt.setInt(2, idModule);
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean supprimerRelation(int idProf, int idModule) throws SQLException {
        if (!existeRelation(idProf, idModule)) return false;

        String sql = "DELETE FROM profs_modules WHERE idProf = ? AND idModule = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idProf);
            stmt.setInt(2, idModule);
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Integer> getModulesParProf(int idProf) throws SQLException {
        List<Integer> modules = new ArrayList<>();
        String sql = "SELECT idModule FROM profs_modules WHERE idProf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idProf);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                modules.add(rs.getInt("idModule"));
            }
        }
        return modules;
    }

    public List<Integer> getProfsParModule(int idModule) throws SQLException {
        List<Integer> profs = new ArrayList<>();
        String sql = "SELECT idProf FROM profs_modules WHERE idModule = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idModule);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                profs.add(rs.getInt("idProf"));
            }
        }
        return profs;
    }
}
