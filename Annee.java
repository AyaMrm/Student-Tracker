package model;

import java.math.BigDecimal;

public class Annee {
 private int idAnnee ;
 private BigDecimal moyGeneral;
 private String anneeScolaire; //aaaa/aaaa
 private int idEtudiant;
 private int idSpecialite;

 private Semestre semestre1;
 private Semestre semestre2;
 


public Annee(int idAnnee, BigDecimal moyGeneral, String anneeScolaire, int idEtudiant, int idSpecialite,
		Semestre semestre1, Semestre semestre2) {
	super();
	this.idAnnee = idAnnee;
	this.moyGeneral = moyGeneral;
	this.anneeScolaire = anneeScolaire;
	this.idEtudiant = idEtudiant;
	this.idSpecialite = idSpecialite;
	this.semestre1 = semestre1;
	this.semestre2 = semestre2;
}

public int getIdAnnee() {
	return idAnnee;
}

public int getIdEtudiant() {
	return idEtudiant;
}

public void setIdEtudiant(int idEtudiant) {
	this.idEtudiant = idEtudiant;
}

public void setIdAnnee(int idAnnee) {
	this.idAnnee = idAnnee;
}

public BigDecimal getMoyGeneral() {
	return moyGeneral;
}

public void setMoyGeneral(BigDecimal moyGeneral) {
	this.moyGeneral = moyGeneral;
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
	return "Annee [idAnnee=" + idAnnee + ", moyGeneral=" + moyGeneral + ", anneeScolaire=" + anneeScolaire
			+ ", idEtudiant=" + idEtudiant + ", idSpecialite=" + idSpecialite + ", semestre1=" + semestre1
			+ ", semestre2=" + semestre2 + "]";
}

}
