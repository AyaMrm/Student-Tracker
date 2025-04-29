// terminé !
package Controller;

import Model.Admin;
import Service.AdminService;

public class AdminController {
	
	private final AdminService adminService;

	public AdminController(AdminService adminService) {
	    this.adminService = adminService;
	}
	
    public boolean ajouterAdmin(Admin admin) {
        if (adminService.adminExist(admin.getMatricule())) {
        	return false;
        } 
        return adminService.ajouterAdmin(admin);
    }
	
    public Admin getAdminByMat(int matricule) {
    	return adminService.getAdminByMat(matricule);
}

    public boolean modifierAdmin(Admin admin) {
        if (!adminService.adminExist(admin.getMatricule())) {
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
