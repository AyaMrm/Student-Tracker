package model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModuleDAO {
    private Connection connection;

    public ModuleDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean existeModule(int idModule) throws SQLException {
        String sql = "SELECT COUNT(*) FROM modules WHERE idModule = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idModule);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public void ajouterModule(Module module) throws SQLException {
        if (existeModule(module.getIdModule())) {
            throw new SQLException("Le module avec cet ID existe déjà.");
        }
        String sql = "INSERT INTO modules (idModule ,nom, idProfResponsable, idSpecialite, idSemestre, methodeCalcul, coefControle, coefExamen) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, module.getIdModule());
            stmt.setString(2, module.getNom());
            stmt.setInt(3, module.getIdProfResponsable());
            stmt.setInt(4, module.getidSpecialite ());
            stmt.setInt(5, module.getIdSemestre());
            stmt.setString(6, module.getMethodeCalcul().getLabel());
            stmt.setObject(7, module.getMethodeCalcul() == MethodeCalcul.PERSONNALISEE ? null : module.getMethodeCalcul().getCoefControle(), Types.DOUBLE);
            stmt.setObject(8, module.getMethodeCalcul() == MethodeCalcul.PERSONNALISEE ? null : module.getMethodeCalcul().getCoefExamen(), Types.DOUBLE);
            stmt.executeUpdate();
        }
    }

    public Module getModuleById(int id) throws SQLException {
        String sql = "SELECT * FROM modules WHERE idModule = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Module(
                        rs.getInt("idModule"),
                        rs.getString("nom"),
                        rs.getInt("idProfResponsable"),
                        rs.getInt("idSpecialite"),
                        rs.getInt("idSemestre"),
                        MethodeCalcul.fromLabel(rs.getString("methodeCalcul")),
                        rs.getObject("coefControle", Double.class),
                        rs.getObject("coefExamen", Double.class)

                    );
                    
                }
            }
        }
        return null;
    }

    public List<Module> getAllModules() throws SQLException {
        List<Module> modules = new ArrayList<>();
        String sql = "SELECT * FROM modules";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                modules.add(new Module(
                    rs.getInt("idModule"),
                    rs.getString("nom"),
                    rs.getInt("idProfResponsable"),
                    rs.getInt("idSpecialite"),    
                    rs.getInt("idSemestre"),

                    MethodeCalcul.fromLabel(rs.getString("methodeCalcul")),
                    rs.getObject("coefControle", Double.class),
                    rs.getObject("coefExamen", Double.class)
                ));
            }
        }
        return modules;
    }

    public void updateModule(Module module) throws SQLException {
        if (!existeModule(module.getIdModule())) {
            throw new SQLException("Le module avec cet ID n'existe pas.");
        }
        String sql = "UPDATE modules SET nom=?, idProfResponsable=?, idSpecialite=?, methodeCalcul=?, coefControle=?, coefExamen=?, idSemestre=? WHERE idModule=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, module.getNom());
            stmt.setInt(2, module.getIdProfResponsable());
            stmt.setInt(3, module.getidSpecialite ());
            stmt.setString(4, module.getMethodeCalcul().getLabel());
            if (module.getCoefControle() == null) {
                stmt.setNull(5, Types.DOUBLE);  // si coefControle est null, on utilise setNull
            } else {
                stmt.setDouble(5, module.getCoefControle());  // sinon on utilise setDouble
            }

            if (module.getCoefExamen() == null) {
                stmt.setNull(6, Types.DOUBLE);  // si coefExamen est null, on utilise setNull
            } else {
                stmt.setDouble(6, module.getCoefExamen());  // sinon on utilise setDouble
            }

            stmt.setInt(7, module.getIdSemestre());
            stmt.setInt(8, module.getIdModule());            
            stmt.executeUpdate();
        }
    }

    public void supprimerModule(int id) throws SQLException {
        if (!existeModule(id)) {
            throw new SQLException("Le module avec cet ID n'existe pas.");
        }
        String sql = "DELETE FROM modules WHERE idModule = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    
    public List<Module> getAllModulesBySpecialite(String idSpecialite) throws SQLException {
        List<Module> modules = new ArrayList<>();
        String sql = "SELECT * FROM modules WHERE specialite = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idSpecialite);  // On remplace ? par la spécialité passée en paramètre
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    modules.add(new Module(
                        rs.getInt("idModule"),
                        rs.getString("nom"),
                        rs.getInt("idProfResponsable"),
                        rs.getInt("idSpecialite"),
                        rs.getInt("idSemestre"),
                        MethodeCalcul.fromLabel(rs.getString("methodeCalcul")),
                        rs.getObject("coefControle", Double.class),
                        rs.getObject("coefExamen", Double.class)
                    ));
                }
            }
        }
        return modules;
    }

}
