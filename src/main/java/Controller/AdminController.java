package Controller;

import Model.Admin;
import Service.AdminService;

public class AdminController {
	
	private final AdminService adminService;

	public AdminController() {
	    this.adminService = new AdminService();
	}
	
	public boolean adminExist(int matricule) {
	    return adminService.adminExist(matricule);
	}

	public boolean ajouterAdmin(Admin admin) {
	    return adminService.ajouterAdmin(admin);
	}

	public Admin getAdminByMat(int matricule) {
	    return adminService.getAdminByMat(matricule);
	}

	public boolean modifierAdmin(Admin admin) {
	    return adminService.modifierAdmin(admin);
	}

	public boolean supprimerAdmin(int matricule) {
	    return adminService.supprimerAdmin(matricule);
	}
}
