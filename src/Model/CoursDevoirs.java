package Model;

public class CoursDevoirs {

	private int idCoursDevoirs;
    private String message;
    private String coursEnPDF;
    private int idProf;
    private int idModule;
    private boolean devoirDone;
    private int idEtudiant;

    public CoursDevoirs(int idCoursDevoirs, String message, String coursEnPDF, int idProf, int idModule, boolean devoirDone, int idEtudiant) {
        this.idCoursDevoirs = idCoursDevoirs;
        this.message = message;
        this.coursEnPDF = coursEnPDF;
        this.idProf = idProf;
        this.idModule = idModule;
        this.devoirDone = devoirDone;
        this.idEtudiant = idEtudiant;
    }

    public int getId() { 
    	return idCoursDevoirs; 
    }
    public String getMessage() { 
    	return message; 
    }
    public String getCoursEnPDF() { 
    	return coursEnPDF; 
    }
    public int getIdProf() { 
    	return idProf; 
    }
    public int getIdModule() { 
    	return idModule; 
    }
    public boolean isDevoirDone() { 
    	return devoirDone; 
    }
    public int getIdEtudiant() { 
    	return idEtudiant; 
    }
    public void setDevoirDone(boolean devoirDone) { 
    	this.devoirDone = devoirDone;
    }

}
