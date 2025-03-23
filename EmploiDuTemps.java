package model;

import java.sql.Time;

public class EmploiDuTemps {
private int idEmploiDuTemps;
private String jour;
private Time heureDebut;
private Time heureFin ;
private String salle;
private int idModule;
private Integer idProf;
private String section;
private String groupe;
private int idAnnee;


public EmploiDuTemps(int idEmploiDuTemps, String jour, Time heureDebut, Time heureFin, String salle, int idModule,
		Integer idProf, String section, String groupe, int idAnnee) {
	super();
	this.idEmploiDuTemps = idEmploiDuTemps;
	this.jour = jour;
	this.heureDebut = heureDebut;
	this.heureFin = heureFin;
	this.salle = salle;
	this.idModule = idModule;
	this.idProf = idProf;
	this.section = section;
	this.groupe = groupe;
	this.idAnnee = idAnnee;
}


public int getIdEmploiDuTemps() {
	return idEmploiDuTemps;
}


public void setIdEmploiDuTemps(int idEmploiDuTemps) {
	this.idEmploiDuTemps = idEmploiDuTemps;
}


public String getJour() {
	return jour;
}


public void setJour(String jour) {
	this.jour = jour;
}


public Time getHeureDebut() {
	return heureDebut;
}


public void setHeureDebut(Time heureDebut) {
	this.heureDebut = heureDebut;
}


public Time getHeureFin() {
	return heureFin;
}


public void setHeureFin(Time heureFin) {
	this.heureFin = heureFin;
}


public String getSalle() {
	return salle;
}


public void setSalle(String salle) {
	this.salle = salle;
}


public int getIdModule() {
	return idModule;
}


public void setIdModule(int idModule) {
	this.idModule = idModule;
}


public Integer getIdProf() {
	return idProf;
}


public void setIdProf(Integer idProf) {
	this.idProf = idProf;
}


public String getSection() {
	return section;
}


public void setSection(String section) {
	this.section = section;
}


public String getGroupe() {
	return groupe;
}


public void setGroupe(String groupe) {
	this.groupe = groupe;
}


public int getIdAnnee() {
	return idAnnee;
}


public void setIdAnnee(int idAnnee) {
	this.idAnnee = idAnnee;
}


@Override
public String toString() {
	return "EmploiDuTemps [idEmploiDuTemps=" + idEmploiDuTemps + ", jour=" + jour + ", heureDebut=" + heureDebut
			+ ", heureFin=" + heureFin + ", salle=" + salle + ", idModule=" + idModule + ", idProf=" + idProf
			+ ", section=" + section + ", groupe=" + groupe + ", idAnnee=" + idAnnee + "]";
}


}
