package Controller;

import Model.Admin;
import Model.AdminDAO;

import java.sql.Connection;

public class AdminService {

    private final AdminDAO adminDAO;

    public AdminService(Connection cnx) {
        this.adminDAO = new AdminDAO(cnx);
    }

    public boolean adminExiste(int id) {
        if (id <= 0) return false;
        return adminDAO.existe(id);
    }

    public boolean ajouterAdmin(Admin admin) {
        if (admin == null || admin.getIdAdmin() <= 0) return false;
        if (adminDAO.existe(admin.getIdAdmin())) return false;
        return adminDAO.ajouterAdmin(admin);
    }

    public Admin getAdminByMat(int id) {
        if (id <= 0) return null;
        return adminDAO.getAdminByMat(id);
    }

    public boolean modifierAdmin(Admin admin) {
        if (admin == null || admin.getIdAdmin() <= 0) return false;
        if (!adminDAO.existe(admin.getIdAdmin())) return false;
        return adminDAO.modifierAdmin(admin);
    }

    public boolean supprimerAdmin(int id) {
        if (id <= 0 || !adminDAO.existe(id)) return false;
        return adminDAO.supprimerAdmin(id);
    }
}