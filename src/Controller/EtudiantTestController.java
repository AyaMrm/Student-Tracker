package Controller;


import Model.Etudiant;
import Model.Role;
import Model.Utilisateur;
import Service.AuthService;
import Service.EtudiantService;

import java.sql.Connection;
import java.util.List;

public class EtudiantTestController {

    public static void main(String[] args) {

        try {
            Connection conn = DatabaseConnection.getConnection();

            EtudiantService service = new EtudiantService(conn);
            AuthService authService = new AuthService(conn);
            EtudiantController controller = new EtudiantController(conn);
            
            // 1. Test ajout
            Etudiant e1 = new Etudiant(50, "Amira", "Benali","String", "String", 20, "F", "3", 1, null);
            Utilisateur u1 = new Utilisateur(50, "Amira", "Benali","String", "String", Role.ETUDIANT);
            boolean ajoutUtilisateur = authService.ajouterUtilisateur(u1, "2025T");
            boolean ajoutEtudiant = controller.ajouterEtudiant(e1);
            System.out.println("Ajout Utilisateur réussi ? " + ajoutUtilisateur);
            System.out.println("Ajout Etudiant réussi ? " + ajoutEtudiant);

            // 2. Test récupération
            Etudiant recupere = controller.getEtudiantById(1);
            if (recupere != null) {
                System.out.println("Étudiant récupéré : " + recupere.getNom() + " " + recupere.getPrenom());
            } else {
                System.out.println("Aucun étudiant trouvé avec cet ID.");
            }

            // 3. Test modification
            e1.setNom("AmiraModifiee");
            boolean modifOk = controller.modifierEtudiant(e1);
            System.out.println("Modification réussie ? " + modifOk);

            // 4. Test récupération par nom
            List<Etudiant> liste = controller.getEtudiantByNom("AmiraModifiee");
            System.out.println("Étudiants avec ce nom : " + liste.size());

            // 5. Test suppression
            boolean supprOk = controller.supprimerEtudiant(1);
            System.out.println("Suppression réussie ? " + supprOk);

            conn.close();

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
