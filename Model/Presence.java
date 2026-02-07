package Model;

import java.sql.Date;
import java.sql.Time;

public class Presence {
	private int idPresence;
    private StatutPresence statut;
    private Time heure;
    private Date datePresence;
    private int idEtudiant;
    private int idModule;
    private int idProf;
	
    public Presence(int idPresence, StatutPresence statut, Time heure, Date datePresence, int idEtudiant, int idModule,
			int idProf) {
		super();
		this.idPresence = idPresence;
		this.statut = statut;
		this.heure = heure;
		this.datePresence = datePresence;
		this.idEtudiant = idEtudiant;
		this.idModule = idModule;
		this.idProf = idProf;
	}


	public int getIdPresence() {
		return idPresence;
	}

	public void setIdPresence(int idPresence) {
		this.idPresence = idPresence;
	}

	public StatutPresence getStatut() {
		return statut;
	}

	public void setStatut(StatutPresence statut) {
		this.statut = statut;
	}

	public Time getHeure() {
		return heure;
	}

	public void setHeure(Time heure) {
		this.heure = heure;
	}

	public Date getDatePresence() {
		return datePresence;
	}

	public void setDatePresence(Date datePresence) {
		this.datePresence = datePresence;
	}

	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public int getIdModule() {
		return idModule;
	}

	public void setIdModule(int idModule) {
		this.idModule = idModule;
	}

	public int getIdProf() {
		return idProf;
	}

	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}
    

	@Override
	public String toString() {
		return "Presence [idPresence=" + idPresence + ", statut=" + statut + ", heure=" + heure + ", datePresence="
				+ datePresence + ", idEtudiant=" + idEtudiant + ", idModule=" + idModule + ", idProf=" + idProf + "]";
	}
    
}
