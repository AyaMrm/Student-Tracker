package Model;

import java.math.BigDecimal;

public class Annee {
 private int idAnnee ;
 private String anneeScolaire; //aaaa/aaaa
// private int idEtudiant;
 private int idSpecialite;
 private BigDecimal moyenneGenerale;


 private Semestre semestre1;
 private Semestre semestre2;
 


 public Annee(int idAnnee,  String anneeScolaire, int idSpecialite,BigDecimal moyenneGenerale) {
		super();
		this.idAnnee = idAnnee;
		this.anneeScolaire = anneeScolaire;
		this.idSpecialite = idSpecialite;
		this.moyenneGenerale = moyenneGenerale;
	}
	public Annee(int idAnnee,  String anneeScolaire, int idSpecialite) {
		super();
		this.idAnnee = idAnnee;
		this.anneeScolaire = anneeScolaire;
		this.idSpecialite = idSpecialite;
	}

public Annee(int idAnnee,  String anneeScolaire, int idSpecialite,BigDecimal moyenneGenerale,
		Semestre semestre1, Semestre semestre2) {
	super();
	this.idAnnee = idAnnee;
	this.anneeScolaire = anneeScolaire;
	this.idSpecialite = idSpecialite;
	this.moyenneGenerale = moyenneGenerale;
	this.semestre1 = semestre1;
	this.semestre2 = semestre2;
}

public int getIdAnnee() {
	return idAnnee;
}


public void setIdAnnee(int idAnnee) {
	this.idAnnee = idAnnee;
}

public BigDecimal getmoyenneGenerale() {
	return moyenneGenerale;
}

public void setMoyGeneral(BigDecimal moyenneGenerale) {
	this.moyenneGenerale = moyenneGenerale;
}



public String getAnneeScolaire() {
	return anneeScolaire;
}

public void setAnneeScolaire(String anneeScolaire) {
	this.anneeScolaire = anneeScolaire;
	
}

public Semestre getSemestre1() {
	return semestre1;
}

public void setSemestre1(Semestre semestre1) {
	this.semestre1 = semestre1;
}

public Semestre getSemestre2() {
	return semestre2;
}

public void setSemestre2(Semestre semestre2) {
	this.semestre2 = semestre2;
}


public int getIdSpecialite() {
	return idSpecialite;
}

public void setIdSpecialite(int idSpecialite) {
	this.idSpecialite = idSpecialite;
}

@Override
public String toString() {
	return "Annee [idAnnee=" + idAnnee + ", moyenneGenerale=" + moyenneGenerale + ", anneeScolaire=" + anneeScolaire
			+  ", idSpecialite=" + idSpecialite + ", semestre1=" + semestre1
			+ ", semestre2=" + semestre2 + "]";
}

}
