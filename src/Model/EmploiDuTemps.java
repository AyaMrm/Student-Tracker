package Model;

import java.util.List;

public class EmploiDuTemps {
	private int idEmploiDuTemps;
	private List<Jour> jours;  
	private String section;
    private String groupe;
	private int idAnnee;
    private Specialite specialite;

    
   
public EmploiDuTemps(int idEmploiDuTemps, List<Jour> jours, String section, String groupe, int idAnnee,
		Specialite specialite) {
	super();
	this.idEmploiDuTemps = idEmploiDuTemps;
	this.jours = jours;
	this.section = section;
	this.groupe = groupe;
	this.idAnnee = idAnnee;
	this.specialite = specialite;
}
public int getIdEmploiDuTemps() {
		return idEmploiDuTemps;
	}
	public void setIdEmploiDuTemps(int idEmploiDuTemps) {
		this.idEmploiDuTemps = idEmploiDuTemps;
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
	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	public List<Jour> getJours() {
		return jours;
	}
	public void setJours(List<Jour> jours) {
		this.jours = jours;
	}
	@Override
	public String toString() {
		return "EmploiDuTemps [idEmploiDuTemps=" + idEmploiDuTemps + ", jours=" + jours + ", section=" + section
				+ ", groupe=" + groupe + ", idAnnee=" + idAnnee + ", specialite=" + specialite + "]";
	}
	



}
