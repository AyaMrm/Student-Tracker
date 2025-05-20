package Model;

import java.sql.Connection;
import java.util.ArrayList;

public class ProfTeste {
    public static void main(String[] args) {
        try (Connection connection = ConnectionDB.getConnection()) {
            ProfDAO profDAO = new ProfDAO(connection);
            Prof prof = new Prof(51, "Lahrech", "Abdelmadjid", "lahrech@gmail.com", "Passord", 1, "phD", "big data");
            boolean add = profDAO.ajouterProf(prof);
            System.out.println(add);
/*
            Prof p = profDAO.getProfByMat(50);
            System.out.println(p.getNom());
            ArrayList<Prof> l = profDAO.getProfsByNom("abdelmadjid");
            ArrayList<Prof> l1 = profDAO.getProfBySpecialite("Développement logiciel");
            ArrayList<Prof> l2 = profDAO.getProfByGrade("phD");
            ArrayList<Prof> l3 = profDAO.getProfByDepartement("big data");
            ArrayList<Prof> l4 = profDAO.getAllProfs();
            for(Prof i : l){
                System.out.println(i.getPrenom());
            }
            Prof pro = new Prof(50, "Ilyes", "khennek", "khennekkk@gmail.com", "Passord", 10, "phD", "AI");
            boolean mod = profDAO.modifierProf(pro);
            System.out.println(mod);
*/
            //boolean supp = profDAO.supprimerProf(41);
            //System.out.println(supp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

