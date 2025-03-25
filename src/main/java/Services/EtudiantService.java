package Services;

import Model.Etudiant;
import Model.EtudiantDAO;
import java.util.ArrayList;

public class EtudiantService {
    EtudiantDAO etudiantDAO = new EtudiantDAO();

    public boolean etudiantExist(int matricule){
        return etudiantDAO.existe(matricule);
    }

    public boolean ajouterEtudiant(Etudiant etudiant){
        return etudiantDAO.ajouterEtudiant(etudiant);
    }

    public Etudiant getEtudiantByMat(int matricule){
        return etudiantDAO.getEtudiantByMat(matricule);
    }

    public ArrayList<Etudiant> getEtudiantByNom(String nom){
        return etudiantDAO.getEtudiantByNom(nom);
    }

    public ArrayList<Etudiant> getAllEtudiant(){
        return etudiantDAO.getAllEtudiants();
    }

    public ArrayList<Etudiant> getEtudiantBySpecialite(String specialite){
        return etudiantDAO.getEtudiantsBySpecialite(specialite);
    }

    public ArrayList<Etudiant> getEtudiantBySection(String specialite,String section){
        return etudiantDAO.getEtudiantsBySection(specialite,section);
    }

    public ArrayList<Etudiant> getEtudiantByGroupe(String specialite, String section, String groupe){
        return etudiantDAO.getEtudiantsByGroupe(specialite, section, groupe);
    }

    public boolean modifierEtudiant(Etudiant etudiant){
        return etudiantDAO.modifierEtudiant(etudiant);
    }

    public boolean suppremerEtudiant(int matricule){
        return etudiantDAO.supprimerEtudiant(matricule);
    }

}
