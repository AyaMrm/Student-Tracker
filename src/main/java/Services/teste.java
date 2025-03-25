package Services;

import Model.*;
import org.mindrot.jbcrypt.BCrypt;
import java.lang.*;
import java.util.ArrayList;

public class teste {
    public static void main(String[] args) throws AuthException {
        UtilisateurService utilisateurService = new UtilisateurService();
        //"pDE23$##"
        /*

        UtilisateurService service = new UtilisateurService();
        Utilisateur user = new Utilisateur(50, "je", "ne", "saa2@gmail.com", "Sfrf4%", Role.PROF);
        //service.ajouterUtilisateur(user);

        try {
            //Utilisateur b = service.authentifierUtilisateur(50, "Sfrf4%");
            //boolean b = service.changerPassword(50, "Sfrf4%", "Sfrf4%dd");
            //boolean b = service.userExists(56);
            //System.out.println(b);
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }

        boolean u = service.supprimerUtilisateur(56);
        System.out.println(u);

        AdminService service = new AdminService();

        boolean a = service.ajouterAdmin(new Admin(1, "ad", "min", "admin@gmail.com", "Password123&"));
        //boolean a = service.adminExist(1);
        //Admin a = service.getAdminByMat(1);
        //boolean a = service.modifierAdmin(new Admin(1, "admin", "admin", "admin1@gmail.com", "jsp!#$32dD"));
        //boolean a = service.supprimerAdmin(1);

        System.out.println(a);

        EtudiantService service = new EtudiantService();

        //boolean e = service.ajouterEtudiant(new Etudiant(10, "etu", "diant", "etudiant1@gmail.com", "Password!133@", "Informatique", "B", "2",1, 1 ));
        //Etudiant e = service.getEtudiantByMat(10);
        //ArrayList<Etudiant> e = service.getEtudiantByGroupe("Iue", "C", "2");
        //boolean e = service.modifierEtudiant(new Etudiant(10, "etudiant", "1", "etudiant1@gmail.com", "WRE#de33", "Laformatique", "BI", "3", 2, 2));
        boolean e = service.supprimerEtudiant(10);
        System.out.println(e);
         */

        ProfService service = new ProfService();

        //boolean p = service.ajouterProf(new Prof(20, "prof", "esseur", "professeur1@gmail.com", "syER3%%", "Informatique", "Docteur","AI"));
        //boolean p = service.profExist(20);
        //Prof p = service.getProfByMat(20);
        //ArrayList<Prof> p = service.getAllProfs();
        //boolean p = service.modifierProf(new Prof(20, "prof", "professeur", "Professeur1@gmail.com", "idkKK@34", "Mathematique", "Docteur", "Analyse"));
        boolean p = service.supprimerProf(20);
        System.out.println(p);

    }
}
