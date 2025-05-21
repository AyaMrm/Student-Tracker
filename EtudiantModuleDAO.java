package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtudiantModuleDAO {

	private Connection connection ;
	public EtudiantModuleDAO(Connection connection) {
		this.connection = connection ;
	}
	
	public boolean existeRelation(int idEtudiant , int idModule) throws SQLException {
		String sql = "SELECT 1 FROM etudiants_modules WHERE idEtudiant = ? AND idModule = ?";
	    try(PreparedStatement stmt = connection.prepareStatement(sql)){
	    	stmt.setInt(1, idEtudiant);
	    	stmt.setInt(2, idModule);
	    	ResultSet rs = stmt.executeQuery();
	    	return rs.next();
	    	}
	    	
	    }
	
	public boolean ajouterRelation(int idEtudiant , int idModule) throws SQLException{
		if(existeRelation(idEtudiant, idModule)) return false;
		
		String sql = "INSERT INTO etudiants_modules (idEtudiant , idModule) VALUES (? ,?)";
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, idEtudiant);
	    	stmt.setInt(2, idModule);
	    	return stmt.executeUpdate() > 0 ;
		}
	}
	
	 public boolean supprimerRelation(int idEtudiant, int idModule) throws SQLException {
	        if (!existeRelation(idEtudiant, idModule)) return false;

	        String sql = "DELETE FROM etudiants_modules WHERE idEtudiant = ? AND idModule = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, idEtudiant);
	            stmt.setInt(2, idModule);
	            return stmt.executeUpdate() > 0;
	        }
	    }
	 public List<Integer> getModulesParEtudiant(int idEtudiant) throws SQLException {
		 List<Integer> modules = new ArrayList<>();
		 String sql = "SELECT idModule FROM etudiants_modules WHERE idEtudiant = ?";
		 try(PreparedStatement stmt = connection.prepareStatement(sql)){
	            stmt.setInt(1, idEtudiant);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                	modules.add(rs.getInt("idModule"));
                }
		 }
		 return modules;
	 }
	 
	    public List<Integer> getEtudiantsParModule(int idModule) throws SQLException {
	        List<Integer> etudiants = new ArrayList<>();
	        String sql = "SELECT idEtudiant FROM etudiants_modules WHERE idModule = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, idModule);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                etudiants.add(rs.getInt("idEtudiant"));
	            }
	        }
	        return etudiants;
	}
}
