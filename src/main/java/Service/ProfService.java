package Service;

import Model.Prof;
import Model.ProfDAO;

import java.sql.Connection;
import java.util.ArrayList;

public class ProfService {
    protected ProfDAO profDAO;

    public ProfService(Connection cnx){
        this.profDAO = new ProfDAO(cnx);
    }

    public boolean existe (int id){
        return profDAO.existe(id);
    }

    public boolean ajouterProf(Prof prof){
        return profDAO.ajouterProf(prof);
    }

    public Prof getProfByMat(int id){
        return profDAO.getProfByMat(id);
    }

    public ArrayList<Prof> getProfByNom(String nom){
        return profDAO.getProfsByNom(nom);
    }

    public ArrayList<Prof> getProfBySpecialite(String spc){
        return profDAO.getProfBySpecialite(spc);
    }

    public ArrayList<Prof> getProfByGrade(String grade){
        return profDAO.getProfByGrade(grade);
    }

    public ArrayList<Prof> getProfByDepartement(String dep){
        return profDAO.getProfByDepartement(dep);
    }

    public boolean modifierProf(Prof prof){
        return profDAO.modifierProf(prof);
    }

    public boolean supprimerProf(int id){
        return profDAO.supprimerProf(id);
    }

}
