package Controller;

import Model.Prof;
import Model.ProfDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class ProfService {

    private final ProfDAO profDAO;

    public ProfService(Connection cnx) {
        this.profDAO = new ProfDAO(cnx);
    }

    public boolean profExiste(int id) {
        if (id <= 0) return false;
        return profDAO.existe(id);
    }

    public boolean ajouterProf(Prof prof) {
        if (prof == null || prof.getIdProf() <= 0) return false;
        if (profDAO.existe(prof.getIdProf())) return false;
        return profDAO.ajouterProf(prof);
    }

    public Prof getProfByMat(int id) {
        if (id <= 0) return null;
        return profDAO.getProfByMat(id);
    }

    public ArrayList<Prof> getProfByNom(String nom) {
        if (nom == null || nom.trim().isEmpty()) return new ArrayList<>();
        return new ArrayList<>(profDAO.getProfsByNom(nom));
    }

    public ArrayList<Prof> getProfBySpecialite(String specialite) {
        if (specialite == null || specialite.trim().isEmpty()) return new ArrayList<>();
        return new ArrayList<>(profDAO.getProfBySpecialite(specialite));
    }

    public ArrayList<Prof> getProfByGrade(String grade) {
        if (grade == null || grade.trim().isEmpty()) return new ArrayList<>();
        return new ArrayList<>(profDAO.getProfByGrade(grade));
    }

    public ArrayList<Prof> getProfByDepartement(String dep) {
        if (dep == null || dep.trim().isEmpty()) return new ArrayList<>();
        return new ArrayList<>(profDAO.getProfByDepartement(dep));
    }

    public boolean modifierProf(Prof prof) {
        if (prof == null || prof.getIdProf() <= 0) return false;
        if (!profDAO.existe(prof.getIdProf())) return false;
        return profDAO.modifierProf(prof);
    }

    public boolean supprimerProf(int id) {
        if (id <= 0) return false;
        return profDAO.supprimerProf(id);
    }
}
