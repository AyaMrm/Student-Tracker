// terminé !
package Controller;

import java.sql.Connection;

import Model.Admin;
import Controller.AdminService;

public class AdminController {
	
	private final AdminService adminService;

	public AdminController(Connection cnx) {
	    this.adminService = new AdminService(cnx);
	}
	
    public boolean ajouterAdmin(Admin admin) {
        if (adminService.adminExiste(admin.getIdAdmin())) {
        	return false;
        } 
        return adminService.ajouterAdmin(admin);
    }
	
    public Admin getAdminByMat(int matricule) {
    	return adminService.getAdminByMat(matricule);
}

    public boolean modifierAdmin(Admin admin) {
        if (!adminService.adminExiste(admin.getIdAdmin())) {
        	return false;
        } 
        return adminService.modifierAdmin(admin);
    }
	
    public boolean supprimerAdmin(int matricule) {
        if (!adminService.adminExiste(matricule)) {
        	return false;
        } 
        return adminService.supprimerAdmin(matricule);
    }
}
