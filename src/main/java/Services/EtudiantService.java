package Services;

import Model.Etudiant;
import Model.EtudiantDAO;
import java.util.ArrayList;

public class EtudiantService {
    EtudiantDAO etudiantDAO = new EtudiantDAO();

    //marche
    public boolean etudiantExist(int matricule){
        return etudiantDAO.existe(matricule);
    }

    //marche
    public boolean ajouterEtudiant(Etudiant etudiant){
        return etudiantDAO.ajouterEtudiant(etudiant);
    }

    //marche
    public Etudiant getEtudiantByMat(int matricule){
        return etudiantDAO.getEtudiantByMat(matricule);
    }

    //il mrch
    public ArrayList<Etudiant> getEtudiantByNom(String nom){
        return etudiantDAO.getEtudiantByNom(nom);
    }

    //marche
    public ArrayList<Etudiant> getAllEtudiant(){
        return etudiantDAO.getAllEtudiants();
    }

    //tres biennn
    public ArrayList<Etudiant> getEtudiantBySpecialite(String specialite){
        return etudiantDAO.getEtudiantsBySpecialite(specialite);
    }

    //marche marche marche
    public ArrayList<Etudiant> getEtudiantBySection(String specialite,String section){
        return etudiantDAO.getEtudiantsBySection(specialite,section);
    }

    //il marche
    public ArrayList<Etudiant> getEtudiantByGroupe(String specialite, String section, String groupe){
        return etudiantDAO.getEtudiantsByGroupe(specialite, section, groupe);
    }

    // pas encore tester
    public boolean modifierEtudiant(Etudiant etudiant){
        return etudiantDAO.modifierEtudiant(etudiant);
    }

    //elle marche !!
    public boolean supprimerEtudiant(int matricule){
        return etudiantDAO.supprimerEtudiant(matricule);
    }

}
