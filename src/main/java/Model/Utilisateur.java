package Model;

public class Utilisateur {
    int matricule;
    String nom;
    String prenom;
    String email;
    String password;
    Role role;

    public Utilisateur(){
    }

    public Utilisateur(int matricule, String nom, String prenom, String email, String password, Role role){
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        if (password == null || password.isEmpty()) {
            throw new PasswordException("Le mot de passe ne peut pas être vide.");
        }
        if (PasswordValidator.isWeak(password)) {
            throw new InvalidPassword("Mot de passe trop faible !");
        }

        PasswordCryp p = new PasswordCryp();
        this.password = p.hashPassword(password);
        //this.password = password;
        this.role= role;
    }

    public Utilisateur(int matricule, String nom, String prenom, String email, Role role){
        this.matricule =matricule;
        this.nom = nom;
        this.prenom= prenom;
        this.email = email;
        this.role = role;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new PasswordException("Le mot de passe ne peut pas être vide.");
        }
        if (PasswordValidator.isWeak(password)) {
            throw new InvalidPassword("Mot de passe trop faible !");
        }

        PasswordCryp p = new PasswordCryp();
        this.password = p.hashPassword(password);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "matricule=" + matricule +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'';
    }
}
