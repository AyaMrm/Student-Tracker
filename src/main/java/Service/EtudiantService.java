package Service;

import java.util.List;
import Model.EtudiantDAO;
import Model.Etudiant;

public class EtudiantService{

	private EtudiantDAO etudiantDAO;

    public EtudiantService() {
        this.etudiantDAO = new EtudiantDAO();
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        if (etudiant.getNom().isEmpty() || etudiant.getPrenom().isEmpty()) {
            throw new IllegalArgumentException("Nom et prénom ne peuvent pas être vides !");
        }
        etudiantDAO.ajouterEtudiant(etudiant);
    }

    public void modifierEtudiant(Etudiant etudiant) {
        etudiantDAO.modifierEtudiant(etudiant);
    }

    public void supprimerEtudiant(int idEtudiant) {
        etudiantDAO.supprimerEtudiant(idEtudiant);
    }

    public Etudiant getEtudiant(int idEtudiant) {
        return etudiantDAO.getEtudiant(idEtudiant);
    }

    public List<Etudiant> getAllEtudiants() {
        return etudiantDAO.getAllEtudiants();
    }
}
