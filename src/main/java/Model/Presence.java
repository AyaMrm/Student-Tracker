package Model;
import java.time.LocalTime;
import java.time.LocalDate;

public class Presence {

    private int id;
    private String statut;
    private LocalTime heure;
    private LocalDate datePresence;
    private int idEtudiant;
    private int idModule;
    private int idProf;

    public Presence(int id, String statut, LocalTime heure, LocalDate datePresence, int idEtudiant, int idModule, int idProf) {
        this.id = id;
        this.statut = statut;
        this.heure = heure;
        this.datePresence = datePresence;
        this.idEtudiant = idEtudiant;
        this.idModule = idModule;
        this.idProf = idProf;
    }

    public int getId() { 
    	return id; 
    }
    public String getStatut() { 
    	return statut; 
    }
    public void setStatut(String statut) { 
    	this.statut = statut; 
    }
    public LocalTime getHeure() { 
    	return heure; 
    }
    public LocalDate getDatePresence() { 
    	return datePresence; 
    }
    public int getIdEtudiant() { 
    	return idEtudiant; 
    }
    public int getIdModule() { 
    	return idModule; 
    }
    public int getIdProf() { 
    	return idProf; 
    }

    
}
