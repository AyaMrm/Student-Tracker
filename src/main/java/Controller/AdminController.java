package Controller;

import Model.Admin;
import Service.AdminService;

public class AdminController {
	
	private final AdminService adminService;

	public AdminController() {
	    this.adminService = new AdminService();
	}
	
    public void ajouterAdmin(Admin admin) {
        if (adminService.adminExist(admin.getMatricule())) {
            System.out.println("Erreur : L'administrateur existe déjà !");
        } else if (adminService.ajouterAdmin(admin)) {
            System.out.println("Administrateur ajouté avec succès !");
        } else {
            System.out.println("Échec de l'ajout de l'administrateur.");
        }
    }
	
    public void getAdminByMat(int matricule) {
        Admin admin = adminService.getAdminByMat(matricule);
        if (admin != null) {
            System.out.println(admin);
        } else {
            System.out.println("Aucun administrateur trouvé avec ce matricule.");
        }
    }
}

    public void modifierAdmin(Admin admin) {
        if (!adminService.adminExist(admin.getMatricule())) {
            System.out.println("Erreur : Administrateur introuvable.");
        } else if (adminService.modifierAdmin(admin)) {
            System.out.println("Administrateur modifié avec succès !");
        } else {
            System.out.println("Échec de la modification de l'administrateur.");
        }
    }
	
    public void supprimerAdmin(int matricule) {
        if (!adminService.adminExist(matricule)) {
            System.out.println("Erreur : Administrateur non trouvé.");
        } else if (adminService.supprimerAdmin(matricule)) {
            System.out.println("Administrateur supprimé avec succès !");
        } else {
            System.out.println("Échec de la suppression de l'administrateur.");
        }
    }
}
