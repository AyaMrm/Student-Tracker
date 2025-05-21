package Model;

import java.math.BigDecimal;

public class EtudiantNoteTable {
    private int idEtudiant;
    String nameString;
    String surnameString;
    String specialityString;
    String sectionString;
    String groupeString;
    private BigDecimal cc;
    private BigDecimal exam;
    private BigDecimal moyenne;
	public EtudiantNoteTable(int idEtudiant, String nameString, String surnameString, String specialityString,
			String sectionString, String groupeString, BigDecimal cc, BigDecimal exam, BigDecimal moyenne) {
		super();
		this.idEtudiant = idEtudiant;
		this.nameString = nameString;
		this.surnameString = surnameString;
		this.specialityString = specialityString;
		this.sectionString = sectionString;
		this.groupeString = groupeString;
		this.cc = cc;
		this.exam = exam;
		this.moyenne = moyenne;
	}
	public int getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
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
	public String getSectionString() {
		return sectionString;
	}
	public void setSectionString(String sectionString) {
		this.sectionString = sectionString;
	}
	public String getGroupeString() {
		return groupeString;
	}
	public void setGroupeString(String groupeString) {
		this.groupeString = groupeString;
	}
	public BigDecimal getCc() {
		return cc;
	}
	public void setCc(BigDecimal cc) {
		this.cc = cc;
	}
	public BigDecimal getExam() {
		return exam;
	}
	public void setExam(BigDecimal exam) {
		this.exam = exam;
	}
	public BigDecimal getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(BigDecimal moyenne) {
		this.moyenne = moyenne;
	}
	@Override
	public String toString() {
		return "EtudiantNoteTable [idEtudiant=" + idEtudiant + ", nameString=" + nameString + ", surnameString="
				+ surnameString + ", specialityString=" + specialityString + ", sectionString=" + sectionString
				+ ", groupeString=" + groupeString + ", cc=" + cc + ", exam=" + exam + ", moyenne=" + moyenne + "]";
	}
   
}
