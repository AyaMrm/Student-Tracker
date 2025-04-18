package Service;

import Model.Etudiant;
import Model.EtudiantDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EtudiantService {
    protected EtudiantDAO etudiantDAO ;

    public EtudiantService(Connection cnx){
        this.etudiantDAO = new EtudiantDAO(cnx);
    }

    public boolean existe(int id) throws SQLException {
        return etudiantDAO.etudiantExiste(id);
    }

    public boolean ajouterEtudiant(Etudiant etd) throws SQLException {
        return etudiantDAO.ajouterEtudiant(etd);
    }

    public boolean modifierEtudiant(Etudiant etd) throws SQLException {
        return etudiantDAO.modifierEtudiant(etd);
    }

    public boolean supprimerEtudiant(int id) throws SQLException{
        return etudiantDAO.supprimerEtudiant(id);
    }

    public Etudiant getEtudiantById(int id) throws SQLException {
        return etudiantDAO.getEtudiantParId(id);
    }

    public List<Etudiant> getAllEtudiant() throws SQLException {
        return etudiantDAO.getTousLesEtudiants();
    }

    public List<Etudiant> getEtudiantByName(String nom) throws SQLException {
        return etudiantDAO.getEtudiantParNom(nom);
    }

    public List<Etudiant> getEtudiantBySpecialite(int idSpecialite) throws SQLException {
        return etudiantDAO.getEtudiantParSpecialite(idSpecialite);
    }


}
