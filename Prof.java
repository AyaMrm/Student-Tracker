package Model;

public class Prof extends Utilisateur {
    int idProf;
    int idSpecialite;
    String grade;
    String departement;

    public Prof() {
    }

    public Prof(int idUser, String nom, String prenom, String email, String motdepasse,int idSpecialite, String grade, String departement) {
        super(idUser, nom, prenom, email, motdepasse, Role.Prof);
        this.idProf = idUser;
        this.idSpecialite = idSpecialite;
        this.grade = grade;
        this.departement = departement;
    }

    public Prof(int idUser, String nom, String prenom, String email, int idSpecialite, String grade, String departement){
        super(idUser, nom, prenom, email, Role.Prof);
        this.idProf = idUser;
        this.idSpecialite = idSpecialite;
        this.grade = grade;
        this.departement = departement;
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

    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(int idSpecialite) {
        this.idSpecialite = idSpecialite;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

}