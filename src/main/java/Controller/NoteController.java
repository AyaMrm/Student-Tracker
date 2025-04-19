//terminé !
package Controller;

import java.util.List;
import Model.Note;
import Service.NoteService;

public class NoteController {

	private final NoteService noteService;
	
	public NoteController() {
		this.noteService = new NoteService();
	}
	
    public boolean ajouterNote(Note note) {
        return noteService.ajouterNote(note);
    }

    public boolean modifierNote(Note note) {
        return noteService.modifierNote(note);
    }

    public boolean supprimerNote(int idNote) {
        return noteService.supprimerNote(idNote);
    }

    public Note getNoteParId(int idNote) {
        return noteService.getNoteParId(idNote);
    }

    public List<Note> getToutesLesNotes() {
        return noteService.getToutesLesNotes();
    }
	
}
