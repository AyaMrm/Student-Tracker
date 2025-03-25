package Services;

import Model.Admin;
import Model.AdminDAO;
import Model.Utilisateur;
import Model.UtilisateurDAO;

public class AdminService {
    AdminDAO adminDAO = new AdminDAO();

    //il marchee
    public boolean adminExist(int matricule){
        return adminDAO.existe(matricule);
    }

    //marche aussi
    public boolean ajouterAdmin(Admin admin){
        if(adminExist(admin.getMatricule())){
            System.err.println("Admin existe deja !!");
            return false;
        }
        return adminDAO.ajouterAdmin(admin);
    }

    // sa aussi !!!!!!!!!!
    public Admin getAdminByMat( int maticule){
        return adminDAO.getAdminByMat(maticule);
    }

    //il marche
    public boolean modifierAdmin(Admin admin){
        return adminDAO.modifierAdmin(admin);
    }

    public boolean supprimerAdmin(int matricule){
        return adminDAO.supprimerAdmin(matricule);
    }

}
