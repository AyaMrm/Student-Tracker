package Model;

public class Admin extends Utilisateur{
    int idAdmin;

    public Admin(){

    }
    public Admin(int idUser, String nom, String prenom, String email, String motdepasse){
        super(idUser, nom, prenom, email, motdepasse,Role.ADMIN );
        this.idAdmin = idUser;
    }

    public Admin(int idUser, String nom, String prenom, String email){
        super(idUser, nom, prenom, email,Role.ADMIN );
        this.idAdmin = idUser;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Override
    public int getIdUser() {
        return idUser;
    }

    @Override
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String getNom() {
        return super.getNom();
    }

    @Override
    public void setNom(String nom) {
        super.setNom(nom);
    }

    @Override
    public String getPrenom() {
        return super.getPrenom();
    }

    @Override
    public void setPrenom(String prenom) {
        super.setPrenom(prenom);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public Role getRole() {
        return super.getRole();
    }

    @Override
    public void setRole(Role role) {
        super.setRole(role);
    }

    @Override
    public String getMotdepasse() {
        return super.getMotdepasse();
    }

    @Override
    public void setMotdepasse(String motdepasse) {
        super.setMotdepasse(motdepasse);
    }

    @Override
    public String toString() {
        return "Admin{}";
    }
}
