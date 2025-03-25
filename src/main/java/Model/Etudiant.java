package Model;

public class Etudiant extends Utilisateur {
    String specialite ;
    String section;
    String groupe;
    int idAnnee;
    int idEmploiDuTemp;

    public Etudiant(){
    }
    public Etudiant(int matricule, String nom, String prenom, String email, String password, Role role, String specialite, String section, String groupe, int idAnnee, int idEmploiDuTemp){
        super(matricule, nom, prenom, email, password, role);
        this.specialite = specialite;
        this.section = section;
        this.groupe = groupe;
        this.idAnnee = idAnnee;
        this.idEmploiDuTemp = idEmploiDuTemp;
    }

    public Etudiant(int matricule, String nom, String prenom, String email, String specialite, String section, String groupe, int idAnnee, int idEmploiDuTemp){
        super(matricule, nom, prenom, email, Role.ETUDIANT);
        this.specialite = specialite;
        this.section = section;
        this.groupe = groupe;
        this.idAnnee = idAnnee;
        this.idEmploiDuTemp = idEmploiDuTemp;
    }

    public Etudiant(int matricule, String nom, String prenom, String email, String password, String specialite, String section, String groupe, int idAnnee, int idEmploiDuTemp){
        super(matricule, nom, prenom, email, password, Role.ETUDIANT);
        this.specialite = specialite;
        this.section = section;
        this.groupe = groupe;
        this.idAnnee = idAnnee;
        this.idEmploiDuTemp = idEmploiDuTemp;
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

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public int getIdAnnee() {
        return idAnnee;
    }

    public void setIdAnnee(int idAnnee) {
        this.idAnnee = idAnnee;
    }

    public int getIdEmploiDuTemps() {
        return idEmploiDuTemp;
    }

    public void setIdEmploiDuTemps(int idEmploiDuTemp) {
        this.idEmploiDuTemp = idEmploiDuTemp;
    }
}
