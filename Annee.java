package model;

import java.math.BigDecimal;

public class Annee {
 private int idAnnee ;
 private BigDecimal moyGeneral;
 private String methodeCalcul;
 private String anneeScolaire;

 public Annee(int idAnnee, BigDecimal moyGeneral, String methodeCalcul, String anneeScolaire) {
	super();
	this.idAnnee = idAnnee;
	this.moyGeneral = moyGeneral;
	this.methodeCalcul = methodeCalcul;
	this.anneeScolaire = anneeScolaire;
}

public int getIdAnnee() {
	return idAnnee;
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

public String getMethodeCalcul() {
	return methodeCalcul;
}

public void setMethodeCalcul(String methodeCalcul) {
	this.methodeCalcul = methodeCalcul;
}

public String getAnneeScolaire() {
	return anneeScolaire;
}

public void setAnneeScolaire(String anneeScolaire) {
	this.anneeScolaire = anneeScolaire;
}

@Override
public String toString() {
	return "Annee [idAnnee=" + idAnnee + ", moyGeneral=" + moyGeneral + ", methodeCalcul=" + methodeCalcul
			+ ", anneeScolaire=" + anneeScolaire + "]";
}
 
 
 
}
