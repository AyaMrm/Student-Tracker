package Model;


public class ProfTable {

	int idprof;
	String nameString;
	String surnameString;
	String specialityString;
	String grade;
	String gmailString;
	String passwordString;
	String departement;
	public ProfTable(int idprof, String nameString, String surnameString, String specialityString, String grade,
			String gmailString, String passwordString, String departement) {
		super();
		this.idprof = idprof;
		this.nameString = nameString;
		this.surnameString = surnameString;
		this.specialityString = specialityString;
		this.grade = grade;
		this.gmailString = gmailString;
		this.passwordString = passwordString;
		this.departement = departement;
	}
	public int getIdprof() {
		return idprof;
	}
	public void setIdprof(int idprof) {
		this.idprof = idprof;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
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
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	@Override
	public String toString() {
		return "ProfTable [idprof=" + idprof + ", nameString=" + nameString + ", surnameString=" + surnameString
				+ ", specialityString=" + specialityString + ", grade=" + grade + ", gmailString=" + gmailString
				+ ", passwordString=" + passwordString + ", departement=" + departement + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
