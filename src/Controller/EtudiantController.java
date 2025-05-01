// terminé !
package Controller;

import java.sql.Connection;
import java.util.List;
import Model.Etudiant;
import Service.EtudiantService;

public class EtudiantController {

    private final EtudiantService etudiantService;

    public EtudiantController(Connection cnx) {
        this.etudiantService = new EtudiantService(cnx);
    }

    public boolean ajouterEtudiant(Etudiant etd) {
        return etudiantService.ajouterEtudiant(etd);
    }

    public boolean modifierEtudiant(Etudiant etd) {
        return etudiantService.modifierEtudiant(etd);
    }

    public boolean supprimerEtudiant(int id) {
        return etudiantService.supprimerEtudiant(id);
    }

    public Etudiant getEtudiantById(int id) {
        return etudiantService.getEtudiantById(id);
    }

    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    public List<Etudiant> getEtudiantByNom(String nom) {
        return etudiantService.getEtudiantByNom(nom);
    }

    public List<Etudiant> getEtudiantBySpecialite(int idSpecialite) {
        return etudiantService.getEtudiantBySpecialite(idSpecialite);
    }

    public boolean etudiantExiste(int id) {
        return etudiantService.etudiantExiste(id);
    }
    
}
