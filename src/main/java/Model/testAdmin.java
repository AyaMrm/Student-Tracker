package Model;

public class testAdmin {
    public static void main(String[] args) {
        AdminDAO adminDAO = new AdminDAO();
        Admin ad = new Admin(10, "name", "surname", "name@gmail.com", "Hya#fFu3$#");

        boolean d = adminDAO.ajouterAdmin(ad);

        if(d){
            System.out.println("ADMIN ajouter avec succes !!");
        }else{
            System.out.println("Erreur lors de l'ajout d'admin !!");
        }

    }
}
