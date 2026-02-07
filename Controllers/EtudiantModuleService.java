package Controllers;


import Model.EtudiantModuleDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class EtudiantModuleService {

    private final EtudiantModuleDAO dao;

    public EtudiantModuleService(Connection cnx) {
        this.dao =  new EtudiantModuleDAO(cnx);
    }

    public boolean ajouterRelation(int idEtudiant, int idModule) {
        try {
            return dao.ajouterRelation(idEtudiant, idModule);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean supprimerRelation(int idEtudiant, int idModule) {
        try {
            return dao.supprimerRelation(idEtudiant, idModule);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean existeRelation(int idEtudiant, int idModule) {
        try {
            return dao.existeRelation(idEtudiant, idModule);
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Integer> getModulesParEtudiant(int idEtudiant) {
        try {
            return dao.getModulesParEtudiant(idEtudiant);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Integer> getEtudiantsParModule(int idModule) {
        try {
            return dao.getEtudiantsParModule(idModule);
        } catch (SQLException e) {
            return null;
        }
    }
}
