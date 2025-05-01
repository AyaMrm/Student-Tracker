// terminé !
package Service;

import java.util.List;
import Model.Note;
import Model.NoteDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class NoteService {

	 private final NoteDAO noteDAO;

	 public NoteService(Connection cnx) {
	     this.noteDAO = new NoteDAO(cnx);
	 }
	 public boolean ajouterNote(Note note) {
		 if(note == null || note.getIdEtudiant() <= 0) return false;
	     try {
	         return noteDAO.ajouterNote(note);
	     } catch (SQLException e) {
	         return false;
	     }
	 }

	    public boolean modifierNote(Note note) {
	    	if(note == null || note.getIdEtudiant() <= 0) return false;
	        try {
	            return noteDAO.modifierNote(note);
	        } catch (SQLException e) {
	            return false;
	        }
	    }

	    public boolean supprimerNote(int idNote) {
	    	if(idNote <= 0) return false;
	        try {
	            return noteDAO.supprimerNote(idNote);
	        } catch (SQLException e) {
	            return false;
	        }
	    }

	    public Note getNoteParId(int idNote) {
	    	if(idNote <= 0) return null;
	        try {
	            return noteDAO.getNoteParId(idNote);
	        } catch (SQLException e) {
	            return null;
	        }
	    }

	    public List<Note> getToutesLesNotes() {
	        try {
	            return noteDAO.getToutesLesNotes();
	        } catch (SQLException e) {
	            return null;
	        }
	    }
	    
	    public static java.math.BigDecimal calculerMoyenne(java.math.BigDecimal cc, java.math.BigDecimal exam) {
	        java.math.BigDecimal coefCC = new java.math.BigDecimal("0.4");
	        java.math.BigDecimal coefExam = new java.math.BigDecimal("0.6");
	        return cc.multiply(coefCC).add(exam.multiply(coefExam));
	    }
}
