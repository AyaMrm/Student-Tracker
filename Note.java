package model;

public class Note {
	 private int idNote;
	    private int coefficient;
	    private float cc;
	    private float exam;
	    private float moyenne;
	    private int idEtudiant;
	    private int idProf;
	    private int idModule;
	    private int idSemestre;
		
	    public Note(int idNote, int coefficient, float cc, float exam, float moyenne, int idEtudiant, int idProf,
				int idModule, int idSemestre) {
			super();
			this.idNote = idNote;
			this.coefficient = coefficient;
			this.cc = cc;
			this.exam = exam;
			this.moyenne = moyenne;
			this.idEtudiant = idEtudiant;
			this.idProf = idProf;
			this.idModule = idModule;
			this.idSemestre = idSemestre;
		}

		public int getIdNote() {
			return idNote;
		}

		public void setIdNote(int idNote) {
			this.idNote = idNote;
		}

		public int getCoefficient() {
			return coefficient;
		}

		public void setCoefficient(int coefficient) {
			this.coefficient = coefficient;
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

		public void setIdEtudiant(int idEtudiant) {
			this.idEtudiant = idEtudiant;
		}

		public int getIdProf() {
			return idProf;
		}

		public void setIdProf(int idProf) {
			this.idProf = idProf;
		}

		public int getIdModule() {
			return idModule;
		}

		public void setIdModule(int idModule) {
			this.idModule = idModule;
		}

		public int getIdSemestre() {
			return idSemestre;
		}

		public void setIdSemestre(int idSemestre) {
			this.idSemestre = idSemestre;
		}
	    
		@Override
		public String toString() {
			return "Note [idNote=" + idNote + ", coefficient=" + coefficient + ", cc=" + cc + ", exam=" + exam
					+ ", moyenne=" + moyenne + ", idEtudiant=" + idEtudiant + ", idProf=" + idProf + ", idModule="
					+ idModule + ", idSemestre=" + idSemestre + "]";
		}
	    
}
