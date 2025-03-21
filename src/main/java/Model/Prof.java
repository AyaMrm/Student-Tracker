package Model;

public class Prof extends Utilisateur {
    String specialite;
    String grade;
    String departement;

    public Prof(){

    }
    public Prof(int matricule, String nom, String prenom, String email, String password, String specialite, String grade, String departement){
        super(matricule, nom, prenom, email, password, Role.PROF);
        this.specialite = specialite;
        this.grade = grade;
        this.departement =departement;
    }

    public Prof(int matricule, String nom, String prenom, String email, String specialite, String grade, String departement){
        super(matricule, nom, prenom, email);
        this.specialite = specialite;
        this.grade = grade;
        this.departement = departement;
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

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Specialite=" + specialite +
                ", Grade='" + grade + '\'' +
                ", Departement='" + departement + '\'';
    }
}
