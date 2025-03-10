package Model;

public class Admin extends Utilisateur {
    public Admin(int matricule, String nom, String prenom, String email, String password, Role role){
        super(matricule, nom, prenom, email, password, role);
    }

    @Override
    public int getMatricule() {
        return super.getMatricule();
    }

    @Override
    public void setMatricule(int matricule) {
        super.setMatricule(matricule);
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
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
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
    public String toString() {
        return super.toString();
    }
}
