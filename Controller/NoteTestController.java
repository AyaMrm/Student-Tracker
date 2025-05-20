package Controller;

import Controller.NoteService;
import Model.Note;
import Model.NoteDAO;
import Model.DatabaseConnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class NoteTestController {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");

            NoteController noteController = new NoteController(connection);

            // 1. Test Ajout d'une note
            System.out.println("\n--- Test Ajout Note ---");
            Note note = new Note(1, 1, new BigDecimal("15.5"), new BigDecimal("13.75"), new BigDecimal("14"), 1, 1, 1, 1);
            boolean ajoutReussi = noteController.ajouterNote(note);
            System.out.println("Ajout réussi ? " + ajoutReussi);

            // 2. Test Récupération d'une note
            System.out.println("\n--- Test Récupération Note ---");
            Note noteRecup = noteController.getNoteParId(1);
            System.out.println("Note récupérée : " + noteRecup);

            // 3. Test Liste de toutes les notes
            System.out.println("\n--- Test Liste Notes ---");
            List<Note> notes = noteController.getToutesLesNotes();
            System.out.println("Toutes les notes : " + notes);

            connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=1");

        } catch (SQLException e) {
            System.err.println("Erreur lors du test Note : " + e.getMessage());
        }
    }
}

