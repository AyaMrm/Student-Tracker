package Controller;

import Model.Prof;
import Service.ProfService;
import java.util.List;

public class ProfController {

    private final ProfService profService;

    public ProfController() {
        this.profService = new ProfService();
    }

    public void ajouterProf(Prof prof) {
        if (profService.profExist(prof.getMatricule())) {
            System.out.println("Erreur : Le professeur existe déjà.");
        } else if (profService.ajouterProf(prof)) {
            System.out.println("Professeur ajouté avec succès !");
        } else {
            System.out.println("Échec de l'ajout du professeur.");
        }
    }

    public void modifierProf(Prof prof) {
        if (!profService.profExist(prof.getMatricule())) {
            System.out.println("Erreur : Professeur introuvable.");
        } else if (profService.modifierProf(prof)) {
            System.out.println("Professeur modifié avec succès !");
        } else {
            System.out.println("Échec de la modification du professeur.");
        }
    }

    public void supprimerProf(int matricule) {
        if (!profService.profExist(matricule)) {
            System.out.println("Erreur : Professeur non trouvé.");
        } else if (profService.supprimerProf(matricule)) {
            System.out.println("Professeur supprimé avec succès !");
        } else {
            System.out.println("Échec de la suppression du professeur.");
        }
    }

    public void afficherProfByMatricule(int matricule) {
        Prof prof = profService.getProfByMat(matricule);
        if (prof != null) {
            System.out.println(prof);
        } else {
            System.out.println("Aucun professeur trouvé avec ce matricule.");
        }
    }

    public void afficherProfsByNom(String nom) {
        List<Prof> profs = profService.getProfByNom(nom);
        if (!profs.isEmpty()) {
            profs.forEach(System.out::println);
        } else {
            System.out.println("Aucun professeur trouvé avec ce nom.");
        }
    }

    public void afficherProfsBySpecialite(String specialite) {
        List<Prof> profs = profService.getProfBySpecialite(specialite);
        if (!profs.isEmpty()) {
            profs.forEach(System.out::println);
        } else {
            System.out.println("Aucun professeur trouvé pour cette spécialité.");
        }
    }

    public void afficherProfsByGrade(String grade) {
        List<Prof> profs = profService.getProfByGrade(grade);
        if (!profs.isEmpty()) {
            profs.forEach(System.out::println);
        } else {
            System.out.println("Aucun professeur trouvé pour ce grade.");
        }
    }

    public void afficherProfsByDepartement(String departement) {
        List<Prof> profs = profService.getProfByDepartement(departement);
        if (!profs.isEmpty()) {
            profs.forEach(System.out::println);
        } else {
            System.out.println("Aucun professeur trouvé pour ce département.");
        }
    }

    public void afficherTousLesProfs() {
        List<Prof> profs = profService.getAllProfs();
        if (!profs.isEmpty()) {
            profs.forEach(System.out::println);
        } else {
            System.out.println("Aucun professeur enregistré.");
        }
    }
}
