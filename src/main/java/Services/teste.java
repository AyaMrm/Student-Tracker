package Services;

import Model.Admin;
import Model.Etudiant;
import Model.Role;
import Model.Utilisateur;
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
         */


    }
}
