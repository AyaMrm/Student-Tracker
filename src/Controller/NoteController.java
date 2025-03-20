package Controller;

import java.util.List;
import Model.Note;
import Service.NoteService;

public class NoteController {

	private NoteService noteService;
	
	public NoteController() {
		this.noteService = new NoteService();
	}
	
	public void ajouterNote(Note note) {
		noteService.ajouterNote(note);
	}
	
	public void modifierNote(Note note) {
		noteService.modifierNote(note);
	}
	
	public void supprimerNote(int idNote) {
		noteService.supprimerNote(idNote);
	}
	
	public float calculerMoyenne(int idEtudiant, int idModule) {
		return noteService.calculerMoyenne(idEtudiant, idModule);
	}
	public void miseAJourMoyenne(int idEtudiant, int idModule) {
		noteService.miseAJourMoyenne(idEtudiant, idModule);
	}
	
	public List<Note> getNotesParEtudiant(int idEtudiant){
		return noteService.getNotesParEtudiant(idEtudiant);
	}
	public List<Note> getNotesParModules(int idModule){
		return noteService.getNotesParModules(idModule);
	}
	
}
