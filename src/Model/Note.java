package Model;

import java.math.BigDecimal;

public class Note {
	 private int idNote;
	    private int coefficient;
	    private BigDecimal cc;
	    private BigDecimal exam;
	    private BigDecimal moyenne;
	    private int idEtudiant;
	    private int idProf;
	    private int idModule;
	    private int idSemestre;
		
	    public Note(int idNote, int coefficient, BigDecimal cc, BigDecimal exam, BigDecimal moyenne, int idEtudiant, int idProf,
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
