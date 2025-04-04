package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SemestreDAO {

    private Connection connection;

    public SemestreDAO(Connection connection) {
        this.connection = connection;
    }
    
   // Vérifier si une année existe
    public boolean anneeExiste(int idAnnee) throws SQLException {
        String query = "SELECT COUNT(*) AS total FROM annees WHERE idAnnee = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idAnnee);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("total") > 0;
            }
        }
        return false;
    }

 // Vérifier si une année a exactement deux semestres
    public int nombreDeSemestres(int idAnnee) throws SQLException {
        String query = "SELECT COUNT(*) AS total FROM semestres WHERE idAnnee = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idAnnee);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        }
        return 0;
    }
    
 //  Ajouter un semestre (vérification incluse)
    public void ajouterSemestre(Semestre semestre) throws SQLException {
        if (!anneeExiste(semestre.getIdAnnee())) {
            System.out.println("Erreur : L'année " + semestre.getIdAnnee() + " n'existe pas.");
            return;
        }

        if (nombreDeSemestres(semestre.getIdAnnee()) >= 2) {
            System.out.println("Erreur : L'année " + semestre.getIdAnnee() + " a déjà deux semestres.");
            return;
        }

        String query = "INSERT INTO semestres (idSemestre, numero, moyenneSemestre, idAnnee) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, semestre.getIdSemestre());
            stmt.setString(2, semestre.getNumero().getValue());
            stmt.setObject(3, semestre.getMoyenneSemestre(), Types.DECIMAL);
            stmt.setInt(4, semestre.getIdAnnee());
            stmt.executeUpdate();
            System.out.println("✅ Semestre ajouté avec succès.");
        }
    }
    
    //Modifier un semestre (vérification incluse)
    public void updateSemestre(Semestre semestre) throws SQLException {
        if (!anneeExiste(semestre.getIdAnnee())) {
            System.out.println("Erreur : L'année " + semestre.getIdAnnee() + " n'existe pas.");
            return;
        }

        String query = "UPDATE semestres SET numero = ?, moyenneSemestre = ?, idAnnee = ? WHERE idSemestre = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, semestre.getNumero().getValue());
            stmt.setObject(2, semestre.getMoyenneSemestre(), Types.DECIMAL);
            stmt.setInt(3, semestre.getIdAnnee());
            stmt.setInt(4, semestre.getIdSemestre());
            stmt.executeUpdate();
            System.out.println("✅ Semestre modifié avec succès.");
        }
    }
    
   // Supprimer un semestre (bloque la suppression si l'année n'a que deux semestres)
    public void deleteSemestre(int idSemestre, int idAnnee) throws SQLException {
        if (!anneeExiste(idAnnee)) {
            System.out.println("Erreur : L'année " + idAnnee + " n'existe pas.");
            return;
        }

        if (nombreDeSemestres(idAnnee) <= 2) {
            System.out.println("Erreur : Impossible de supprimer un semestre car chaque année doit en avoir exactement deux.");
            return;
        }

        String query = "DELETE FROM semestres WHERE idSemestre = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idSemestre);
            stmt.executeUpdate();
            System.out.println("✅ Semestre supprimé avec succès.");
        }
    }
   // Récupérer un semestre par son ID
    public Semestre getSemestreById(int id) throws SQLException {
        String query = "SELECT * FROM semestres WHERE idSemestre = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Semestre(
                    rs.getInt("idSemestre"),
                    NumeroSemestre.fromString(rs.getString("numero")),
                    rs.getObject("moyenneSemestre") != null ? rs.getDouble("moyenneSemestre") : null,
                    rs.getInt("idAnnee")
                );
            }
        }
        return null;
    }
    
 // Récupérer tous les semestres
    public List<Semestre> getAllSemestres() throws SQLException {
        List<Semestre> semestres = new ArrayList<>();
        String query = "SELECT * FROM semestres";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                semestres.add(new Semestre(
                    rs.getInt("idSemestre"),
                    NumeroSemestre.fromString(rs.getString("numero")),
                    rs.getObject("moyenneSemestre") != null ? rs.getDouble("moyenneSemestre") : null,
                    rs.getInt("idAnnee")
                ));
            }
        }
        return semestres;
    }
    }