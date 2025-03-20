package Model;

import java.util.ArrayList;

public class testEtudiant {
    public static void main(String[] args) {
        EtudiantDAO etudiantDAO = new EtudiantDAO();
/*
        Etudiant etudiant = new Etudiant(2232, "mrm", "aya", "mrm.aya@email.com", "p##221dOrD$$123", Role.ETUDIANT,
                "Informatique", "B", "G2", 2025, 1);

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
        String nomRecherche = "A";

        //ArrayList<Etudiant> etudiants = etudiantDAO.getEtudiantByNom(nomRecherche);

        //ArrayList<Etudiant> all = etudiantDAO.getAllEtudiants();

        //ArrayList<Etudiant> bysec = etudiantDAO.getEtudiantsBySection("B");

        /*
        ArrayList<Etudiant> spec = etudiantDAO.getEtudiantsByGroupe("informatique", "b", "G1");

        if (spec.isEmpty()) {
            System.out.println("pas d'etudiant ! ");
        } else {
            System.out.println("Étudiants trouvés :");
            for (Etudiant etdt : spec) {
                System.out.println(etdt);
            }
        }
         */

        Etudiant etudiant = new Etudiant(1001, "Ali", "Ali", "Ali.Ali@example.com", "ST", "A", "G1", 2025, 3);
        //boolean success = EtudiantDAO.modifierEtudiant(etudiant);

        boolean idk = etudiantDAO.supprimerEtudiant(1001);
    }
}
