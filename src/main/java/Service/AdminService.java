package Service;

import Model.Admin;
import Model.AdminDAO;

import java.sql.Connection;

public class AdminService {
    protected AdminDAO adminDAO;
    public AdminService(Connection cnx){
        this.adminDAO = new AdminDAO(cnx);
    }

    public boolean existe(int id){
        return adminDAO.existe(id);
    }

    public boolean ajouterAdmin(Admin admin){
        return adminDAO.ajouterAdmin(admin);
    }

    public Admin getAdminByMat (int id){
        return adminDAO.getAdminByMat(id);
    }

    public boolean modifierAdmin(Admin admin){
        return adminDAO.modifierAdmin(admin);
    }

    public boolean supprimerAdmin(int id){
        return adminDAO.supprimerAdmin(id);
    }

}
