package Model;

public class Note {

	 private int id;
	 private float coefficient;
	 private float cc;
	 private float exam;
	 private float moyenne;
	 private int idEtudiant;
	 private int idProf;
	 private int idModule;

	 public Note(int id, float coefficient, float cc, float exam, float moyenne, int idEtudiant, int idProf, int idModule) {
	     this.id = id;
	     this.coefficient = coefficient;
	     this.cc = cc;
	     this.exam = exam;
	     this.moyenne = moyenne;
	     this.idEtudiant = idEtudiant;
	     this.idProf = idProf;
	     this.idModule = idModule;
	 }

	 public int getId() { 
		 return id; 
	 }
	 public float getCoefficient() { 
		 return coefficient; 
	 }
	 public float getCc() { 
		 return cc; 
	 }
	 public void setCc(float cc) { 
		 this.cc = cc; 
	 }
	 public float getExam() { 
		 return exam;
	 }
	 public void setExam(float exam) { 
		 this.exam = exam;
	 }
	 public float getMoyenne() { 
		 return moyenne;
	 }
	 public void setMoyenne(float moyenne) { 
		 this.moyenne = moyenne;
	 }
	 public int getIdEtudiant() { 
		 return idEtudiant; 
	 }
	 public int getIdProf() { 
		 return idProf;
	 }
	 public int getIdModule() { 
		 return idModule;
	 }
	 
}
