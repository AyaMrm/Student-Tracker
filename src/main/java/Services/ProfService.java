package Services;

import Model.Prof;
import Model.ProfDAO;

import java.util.ArrayList;

public class ProfService {
    ProfDAO profDAO = new ProfDAO();

    public boolean profExist(int matricule){
        return profDAO.existe(matricule);
    }

    public boolean ajouterProf(Prof prof){
        return profDAO.ajouterProf(prof);
    }

    public Prof getProfByMat(int matricule){
        return profDAO.getProfByMat(matricule);
    }

    public ArrayList<Prof> getProfByNom(String nom){
        return profDAO.getProfsByNom(nom);
    }

    public ArrayList<Prof> getProfBySpecialite(String specialite){
        return profDAO.getProfBySpecialite(specialite);
    }

    public ArrayList<Prof> getProfByGrade(String grade){
        return profDAO.getProfByGrade(grade);
    }

    public ArrayList<Prof> getProfByDepartement(String dep){
        return profDAO.getProfByDepartement(dep);
    }

    public ArrayList<Prof> getAllProfs(){
        return profDAO.getAllProfs();
    }

    public boolean modifierProf(Prof p){
        return profDAO.modifierProf(p);
    }

    public boolean supprimerProf(int matricule){
        return profDAO.supprimerProf(matricule);
    }

}
