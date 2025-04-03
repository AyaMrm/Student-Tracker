package model;

import java.math.BigDecimal;

public class Annee {
 private int idAnnee ;
 private BigDecimal moyGeneral;
 private String anneeScolaire; //aaaa/aaaa
 private int idEtudiant;

 public Annee(int idAnnee, BigDecimal moyGeneral,  String anneeScolaire, int idEtudiant) {
	super();
	this.idAnnee = idAnnee;
	this.moyGeneral = moyGeneral;
	this.anneeScolaire = anneeScolaire;
	this.idEtudiant = idEtudiant;
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

@Override
public String toString() {
	return "Annee [idAnnee=" + idAnnee + ", moyGeneral=" + moyGeneral + ", anneeScolaire=" + anneeScolaire
			+ ", idEtudiant=" + idEtudiant + "]";
}


 
 
 
}
