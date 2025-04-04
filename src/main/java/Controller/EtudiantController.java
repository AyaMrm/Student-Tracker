package Controller;

import java.util.List;
import Model.Etudiant;
import Service.EtudiantService;

public class EtudiantController {

	private final EtudiantService etudiantService;

	public EtudiantController() {
		this.etudiantService = new EtudiantService();
	}
	
    public void ajouterEtudiant(Etudiant etudiant) {
        if (etudiantService.etudiantExist(etudiant.getMatricule())) {
            System.out.println("Erreur : L'étudiant existe déjà.");
        } else if (etudiantService.ajouterEtudiant(etudiant)) {
            System.out.println("Étudiant ajouté avec succès !");
        } else {
            System.out.println("Échec de l'ajout de l'étudiant.");
        }
    }

    public void getEtudiantByMat(int matricule) {
        Etudiant etudiant = etudiantService.getEtudiantByMat(matricule);
        if (etudiant != null) {
            System.out.println(etudiant);
        } else {
            System.out.println("Aucun étudiant trouvé avec ce matricule.");
        }
    }

    public void getEtudiantsByNom(String nom) {
        List<Etudiant> etudiants = etudiantService.getEtudiantByNom(nom);
        if (!etudiants.isEmpty()) {
            etudiants.forEach(System.out::println);
        } else {
            System.out.println("Aucun étudiant trouvé avec ce nom.");
        }
    }
	
    public void getEtudiantsBySpecialite(String specialite) {
        List<Etudiant> etudiants = etudiantService.getEtudiantBySpecialite(specialite);
        if (!etudiants.isEmpty()) {
            etudiants.forEach(System.out::println);
        } else {
            System.out.println("Aucun étudiant trouvé pour cette spécialité.");
        }
    }

    public void getEtudiantsBySection(String specialite, String section) {
        List<Etudiant> etudiants = etudiantService.getEtudiantBySection(specialite, section);
        if (!etudiants.isEmpty()) {
            etudiants.forEach(System.out::println);
        } else {
            System.out.println("Aucun étudiant trouvé pour cette section.");
        }
    }

    public void getEtudiantsByGroupe(String specialite, String section, String groupe) {
        List<Etudiant> etudiants = etudiantService.getEtudiantByGroupe(specialite, section, groupe);
        if (!etudiants.isEmpty()) {
            etudiants.forEach(System.out::println);
        } else {
            System.out.println("Aucun étudiant trouvé pour ce groupe.");
        }
    }
	
    public void modifierEtudiant(Etudiant etudiant) {
        if (!etudiantService.etudiantExist(etudiant.getMatricule())) {
            System.out.println("Erreur : Étudiant introuvable.");
        } else if (etudiantService.modifierEtudiant(etudiant)) {
            System.out.println("Étudiant modifié avec succès !");
        } else {
            System.out.println("Échec de la modification de l'étudiant.");
        }
    }
	
    public void supprimerEtudiant(int matricule) {
        if (!etudiantService.etudiantExist(matricule)) {
            System.out.println("Erreur : Étudiant non trouvé.");
        } else if (etudiantService.supprimerEtudiant(matricule)) {
            System.out.println("Étudiant supprimé avec succès !");
        } else {
            System.out.println("Échec de la suppression de l'étudiant.");
        }
    }

    public void getTousLesEtudiants() {
        List<Etudiant> etudiants = etudiantService.getAllEtudiant();
        if (!etudiants.isEmpty()) {
            etudiants.forEach(System.out::println);
        } else {
            System.out.println("Aucun étudiant enregistré.");
        }
    }
    
}
