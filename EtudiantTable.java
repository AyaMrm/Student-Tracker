package Model;

import java.math.BigDecimal;

public class EtudiantTable {
int Matricule;
String nameString;
String surnameString;
String specialityString;
String yearString;
BigDecimal graDecimal;
String gmailString;
String passwordString;
String Section;
String Groupe;
public EtudiantTable(int matricule, String nameString, String surnameString, String specialityString, String yearString,
		BigDecimal graDecimal, String gmailString, String passwordString, String section, String groupe) {
	super();
	Matricule = matricule;
	this.nameString = nameString;
	this.surnameString = surnameString;
	this.specialityString = specialityString;
	
	this.yearString = yearString;
	this.graDecimal = graDecimal;
	this.gmailString = gmailString;
	this.passwordString = passwordString;
	Section = section;
	Groupe = groupe;
}
public int getMatricule() {
	return Matricule;
}
public void setMatricule(int matricule) {
	Matricule = matricule;
}
public String getNameString() {
	return nameString;
}
public void setNameString(String nameString) {
	this.nameString = nameString;
}
public String getSurnameString() {
	return surnameString;
}
public void setSurnameString(String surnameString) {
	this.surnameString = surnameString;
}
public String getSpecialityString() {
	return specialityString;
}
public void setSpecialityString(String specialityString) {
	this.specialityString = specialityString;
}
public String getYearString() {
	return yearString;
}
public void setYearString(String yearString) {
	this.yearString = yearString;
}
public BigDecimal getGraDecimal() {
	return graDecimal;
}
public void setGraDecimal(BigDecimal graDecimal) {
	this.graDecimal = graDecimal;
}
public String getGmailString() {
	return gmailString;
}
public void setGmailString(String gmailString) {
	this.gmailString = gmailString;
}
public String getPasswordString() {
	return passwordString;
}
public void setPasswordString(String passwordString) {
	this.passwordString = passwordString;
}
public String getSection() {
	return Section;
}
public void setSection(String section) {
	Section = section;
}
public String getGroupe() {
	return Groupe;
}
public void setGroupe(String groupe) {
	Groupe = groupe;
}

}