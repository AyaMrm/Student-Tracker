package Model;

import java.util.ArrayList;

public class Etudiant extends Utilisateur {
    private int idEtudiant;
    private int idSpecialite;
    private String section;
    private String groupe;
    private Integer idEmploiDuTemps; // Changé de int à Integer
    private ArrayList<Annee> annees;

    public Etudiant() {
    }

    public Etudiant(int idUser, String nom, String prenom, String email, String motDePasse,
                    int idSpecialite, String section, String groupe, Integer idEmploiDuTemps,
                    ArrayList<Annee> annees) {
        super(idUser, nom, prenom, email, motDePasse, Role.ETUDIANT);
        this.idEtudiant = idUser;
        this.idSpecialite = idSpecialite;
        this.section = section;
        this.groupe = groupe;
        this.idEmploiDuTemps = idEmploiDuTemps; // Accepte null
        this.annees = (annees != null) ? new ArrayList<>(annees) : new ArrayList<>();
    }

    public Etudiant(int idUser, String nom, String prenom, String email,
                    int idSpecialite, String section, String groupe, Integer idEmploiDuTemps) {
        super(idUser, nom, prenom, email, Role.ETUDIANT);
        this.idEtudiant = idUser;
        this.idSpecialite = idSpecialite;
        this.section = section;
        this.groupe = groupe;
        this.idEmploiDuTemps = idEmploiDuTemps; // Accepte null
        this.annees = new ArrayList<>();
    }

    // Getters
    public int getIdEtudiant() {
        return idEtudiant;
    }

    public int getIdSpecialite() {
        return idSpecialite;
    }

    public String getSection() {
        return section;
    }

    public String getGroupe() {
        return groupe;
    }

    public Integer getIdEmploiDuTemps() { // Changé de int à Integer
        return idEmploiDuTemps;
    }

    public ArrayList<Annee> getAnnees() {
        return new ArrayList<>(annees);
    }

    // Setters
    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
        super.setIdUser(idEtudiant);
    }

    public void setIdSpecialite(int idSpecialite) {
        this.idSpecialite = idSpecialite;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public void setIdEmploiDuTemps(Integer idEmploiDuTemps) { // Changé de int à Integer
        this.idEmploiDuTemps = idEmploiDuTemps;
    }

    public void setAnnees(ArrayList<Annee> annees) {
        this.annees = (annees != null) ? new ArrayList<>(annees) : new ArrayList<>();
    }
}