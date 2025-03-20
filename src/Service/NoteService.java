package Service;

import java.util.List;
import Model.Note;
import Model.NoteDAO;

public class NoteService {

	 private NoteDAO noteDAO;

	 public NoteService() {
	     this.noteDAO = new NoteDAO();
	 }
	 
	 public void ajouterNote(Note note) {
		 if(note.getCc() < 0 || note.getExam() < 0) {
			 throw new IllegalArgumentException("Les notes ne peuvent pas etres negatives !");
		 }
		 noteDAO.ajouterNote(note);
	 }
	 
	 public void modifierNote(Note note) {
		 if(note.getCc() < 0 || note.getExam() < 0) {
			 throw new IllegalArgumentException("Les notes ne peuvent pas etres negatives !");
		 }
		 noteDAO.modifierNote(note);
	 }
	 
	 public float calculerMoyenne(int idEtudiant, int idModule) {
	     List<Note> notes = noteDAO.getNotesParEtudiantEtModule(idEtudiant, idModule);
	     float somme = 0;
	     int count = 0;

	     for (Note note : notes) {
	         float moyenne = (note.getCc() * 0.4f) + (note.getExam() * 0.6f);
	         somme += moyenne;
	         count++;
	     }

	     return (count > 0) ? (somme / count) : 0;
	 }
	 
	 public void miseAJourMoyenne(int idEtudiant, int idModule) {
		 float nouvelleMoyenne = noteDAO.calculerMoyenne(idEtudiant, idModule);
		 noteDAO.miseAJourMoyenne(idEtudiant, idModule, nouvelleMoyenne);
	 }
	 
	 public List<Note> getNotesParModules(int idModule){
		 return noteDAO.getNotesParModule(idModule);
	 }
	 
	 public List<Note> getNotesParEtudiant(int idEtudiant){
		 return noteDAO.getNotesParEtudiant(idEtudiant);
	 }
	 
	 public void supprimerNote(int idNote) {
		 noteDAO.supprimerNote(idNote);
	 }
	 
}
