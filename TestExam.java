package model;

import java.sql.Date;
import java.sql.Time;

public class TestExam {
	private int idTestExam;
    private TypeTestExam type;
    private Date date;
    private Time heure;
    private int idModule;
    private int idProf;
    private String section;
    private String groupe;
    private String description;
	
    public TestExam(int idTestExam, TypeTestExam type, Date date, Time heure, int idModule, int idProf, String section,
			String groupe, String description) {
		super();
		this.idTestExam = idTestExam;
		this.type = type;
		this.date = date;
		this.heure = heure;
		this.idModule = idModule;
		this.idProf = idProf;
		this.section = section;
		this.groupe = groupe;
		this.description = description;
	}

	public int getIdTestExam() {
		return idTestExam;
	}

	public void setIdTestExam(int idTestExam) {
		this.idTestExam = idTestExam;
	}

	public TypeTestExam getType() {
		return type;
	}

	public void setType(TypeTestExam type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getHeure() {
		return heure;
	}

	public void setHeure(Time heure) {
		this.heure = heure;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TestExam [idTestExam=" + idTestExam + ", type=" + type + ", date=" + date + ", heure=" + heure
				+ ", idModule=" + idModule + ", idProf=" + idProf + ", section=" + section + ", groupe=" + groupe
				+ ", description=" + description + "]";
	}
    
    
    
}
