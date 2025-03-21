package Model;

public class testAdmin {
    public static void main(String[] args) {
        AdminDAO adminDAO = new AdminDAO();
        /*
        Admin ad = new Admin(10, "name", "surname", "name@gmail.com", "Hya#fFu3$#");

        boolean d = adminDAO.ajouterAdmin(ad);

        if(d){
            System.out.println("ADMIN ajouter avec succes !!");
        }else{
            System.out.println("Erreur lors de l'ajout d'admin !!");
        }


        int matricule = 10;

        Utilisateur admin = adminDAO.getAdminByMat(matricule);

        if (admin != null) {
            System.out.println("✅ Admin trouvé !");
            System.out.println("ID: " + admin.getMatricule());
            System.out.println("Nom: " + admin.getNom());
            System.out.println("Prénom: " + admin.getPrenom());
            System.out.println("Email: " + admin.getEmail());
        } else {
            System.out.println("❌ Aucun admin trouvé avec ce matricule !");
        }

        Admin admin = new Admin(10, "Nom", "NouveauPrenom", "newemail@example.com");

        boolean updated = adminDAO.modifierAdmin(admin);

        if (updated) {
            System.out.println("✅ Admin modifié avec succès !");
        } else {
            System.out.println("❌ Échec de la modification.");
        }
         */
        int matricule = 10;

        boolean success = adminDAO.supprimerAdmin(matricule);

        if (success) {
            System.out.println("✅ Suppression réussie !");
        } else {
            System.out.println("❌ Échec de la suppression. Vérifiez le matricule !");
        }

    }
}
