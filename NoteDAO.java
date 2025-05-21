package Model;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO {
	 private Connection connection;

	    public NoteDAO(Connection connection) {
	        this.connection = connection;
	    }

	    // Méthode pour ajouter une note
	    public boolean ajouterNote(Note note) throws SQLException {
	        // Vérifier si l'étudiant a déjà une note pour ce module
	        if (getNoteParEtudiantEtModule(note.getIdEtudiant(), note.getIdModule()) != null) {
	            return false; // L'étudiant a déjà une note pour ce module
	        }

	        // Vérifications des données de la note (validité des valeurs)
	        if (note.getCoefficient() <= 0.0 
	        	    || note.getCc().compareTo(BigDecimal.ZERO) < 0 
	        	    || note.getCc().compareTo(new BigDecimal("20.0")) > 0
	        	    || note.getExam().compareTo(BigDecimal.ZERO) < 0
	        	    || note.getExam().compareTo(new BigDecimal("20.0")) > 0
	        	    || note.getMoyenne().compareTo(BigDecimal.ZERO) < 0
	        	    || note.getMoyenne().compareTo(new BigDecimal("20.0")) > 0) {
	        	    return false;
	        	}

	        String sql = "INSERT INTO notes (idNote, coefficient, cc, exam, moyenne, idEtudiant, idProf, idModule, idSemestre) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, note.getIdNote());
	            stmt.setInt(2, note.getCoefficient());
	            stmt.setBigDecimal(3, note.getCc());
	            stmt.setBigDecimal(4, note.getExam());
	            stmt.setBigDecimal(5, note.getMoyenne());
	            stmt.setInt(6, note.getIdEtudiant());
	            stmt.setInt(7, note.getIdProf());
	            stmt.setInt(8, note.getIdModule());
	            stmt.setInt(9, note.getIdSemestre());
	            return stmt.executeUpdate() > 0;
	        }
	    }

	    // Méthode pour modifier une note avec vérification de l'existence de la note
	    public boolean modifierNote(Note note) throws SQLException {
	        // Vérifier si la note existe
	        if (getNoteParId(note.getIdNote()) == null) {
	            return false;
	        }

	        // Vérifications des données de la note
	        if (note.getCoefficient() <= 0.0 
	        	    || note.getCc().compareTo(BigDecimal.ZERO) < 0 
	        	    || note.getCc().compareTo(new BigDecimal("20.0")) > 0
	        	    || note.getExam().compareTo(BigDecimal.ZERO) < 0
	        	    || note.getExam().compareTo(new BigDecimal("20.0")) > 0
	        	    || note.getMoyenne().compareTo(BigDecimal.ZERO) < 0
	        	    || note.getMoyenne().compareTo(new BigDecimal("20.0")) > 0) {
	        	    return false;
	        	}

	        String sql = "UPDATE notes SET coefficient=?, cc=?, exam=?, moyenne=?, idEtudiant=?, idProf=?, idModule=?, idSemestre=? WHERE idNote=?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, note.getCoefficient());
	            stmt.setBigDecimal(2, note.getCc());
	            stmt.setBigDecimal(3, note.getExam());
	            stmt.setBigDecimal(4, note.getMoyenne());
	            stmt.setInt(5, note.getIdEtudiant());
	            stmt.setInt(6, note.getIdProf());
	            stmt.setInt(7, note.getIdModule());
	            stmt.setInt(8, note.getIdSemestre());
	            stmt.setInt(9, note.getIdNote());
	            return stmt.executeUpdate() > 0;
	        }
	    }

	    // Méthode pour supprimer une note
	    public boolean supprimerNote(int idNote) throws SQLException {
	        // Vérifier si la note existe
	        if (getNoteParId(idNote) == null) {
	            return false;
	        }

	        String sql = "DELETE FROM notes WHERE idNote=?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, idNote);
	            return stmt.executeUpdate() > 0;
	        }
	    }

	    // Méthode pour récupérer une note par son ID
	    public Note getNoteParId(int idNote) throws SQLException {
	        String sql = "SELECT * FROM notes WHERE idNote=?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, idNote);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return new Note(
	                    rs.getInt("idNote"),
	                    rs.getInt("coefficient"),
	                    rs.getBigDecimal("cc"),
	                    rs.getBigDecimal("exam"),
	                    rs.getBigDecimal("moyenne"),
	                    rs.getInt("idEtudiant"),
	                    rs.getInt("idProf"),
	                    rs.getInt("idModule"),
	                    rs.getInt("idSemestre")
	                );
	            }
	        }
	        return null;
	    }

	    // Méthode pour récupérer toutes les notes
	    public List<Note> getToutesLesNotes() throws SQLException {
	        List<Note> notes = new ArrayList<>();
	        String sql = "SELECT * FROM notes";
	        try (PreparedStatement stmt = connection.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                notes.add(new Note(
	                    rs.getInt("idNote"),
	                    rs.getInt("coefficient"),
	                    rs.getBigDecimal("cc"),
	                    rs.getBigDecimal("exam"),
	                    rs.getBigDecimal("moyenne"),
	                    rs.getInt("idEtudiant"),
	                    rs.getInt("idProf"),
	                    rs.getInt("idModule"),
	                    rs.getInt("idSemestre")
	                ));
	            }
	        }
	        return notes;
	    }

	    // Méthode pour vérifier si une note existe pour un étudiant et un module
	    private Note getNoteParEtudiantEtModule(int idEtudiant, int idModule) throws SQLException {
	        String sql = "SELECT * FROM notes WHERE idEtudiant=? AND idModule=?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, idEtudiant);
	            stmt.setInt(2, idModule);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return new Note(
	                    rs.getInt("idNote"),
	                    rs.getInt("coefficient"),
	                    rs.getBigDecimal("cc"),
	                    rs.getBigDecimal("exam"),
	                    rs.getBigDecimal("moyenne"),
	                    rs.getInt("idEtudiant"),
	                    rs.getInt("idProf"),
	                    rs.getInt("idModule"),
	                    rs.getInt("idSemestre")
	                );
	            }
	        }
	        return null; // Retourne null si aucune note trouvée
	    }
}