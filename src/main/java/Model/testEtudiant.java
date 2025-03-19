package Model;

import java.util.ArrayList;

public class testEtudiant {
    public static void main(String[] args) {
        EtudiantDAO etudiantDAO = new EtudiantDAO();
/*
        Etudiant etudiant = new Etudiant(1001, "Ali", "Meziane", "ali.meziane@email.com", "passwOrD$$123", Role.ETUDIANT,
                "Informatique", "B", "G1", 2025, 1);

        boolean success = etudiantDAO.ajouterEtudiant(etudiant);
        if (success) {
            System.out.println("✅ Étudiant ajouté avec succès !");
        } else {
            System.out.println("❌ Erreur lors de l'ajout !");
        }


        int matricule = 1001;  // Matricule à rechercher
        Etudiant etudiant = etudiantDAO.getEtudiantByMat(matricule);

        if (etudiant != null) {
            System.out.println("✅ Étudiant trouvé : " + etudiant);
        } else {
            System.out.println("❌ Étudiant introuvable !");
        }

 */
        String nomRecherche = "As";

        ArrayList<Etudiant> etudiants = etudiantDAO.getEtudiantByNom(nomRecherche);


        if (etudiants.isEmpty()) {
            System.out.println("Aucun étudiant trouvé avec le nom : " + nomRecherche);
        } else {
            System.out.println("Étudiants trouvés :");
            for (Etudiant etdt : etudiants) {
                System.out.println(etdt);
            }
        }
    }
}
