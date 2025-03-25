package Services;

import Model.Prof;
import Model.ProfDAO;

import java.util.ArrayList;

public class ProfService {
    ProfDAO profDAO = new ProfDAO();

    //marche
    public boolean profExist(int matricule){
        return profDAO.existe(matricule);
    }

    // c bonnn
    public boolean ajouterProf(Prof prof){
        return profDAO.ajouterProf(prof);
    }

    //fait !
    public Prof getProfByMat(int matricule){
        return profDAO.getProfByMat(matricule);
    }

    //il marche
    public ArrayList<Prof> getProfByNom(String nom){
        return profDAO.getProfsByNom(nom);
    }

    //marche
    public ArrayList<Prof> getProfBySpecialite(String specialite){
        return profDAO.getProfBySpecialite(specialite);
    }

    //il marche
    public ArrayList<Prof> getProfByGrade(String grade){
        return profDAO.getProfByGrade(grade);
    }

    //marche
    public ArrayList<Prof> getProfByDepartement(String dep){
        return profDAO.getProfByDepartement(dep);
    }

    //marche
    public ArrayList<Prof> getAllProfs(){
        return profDAO.getAllProfs();
    }

    //
    public boolean modifierProf(Prof p){
        return profDAO.modifierProf(p);
    }

    public boolean supprimerProf(int matricule){
        return profDAO.supprimerProf(matricule);
    }

}
