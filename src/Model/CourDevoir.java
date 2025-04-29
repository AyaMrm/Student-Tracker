package Model;

public class CourDevoir {
	private int idCoursDevoirs;
    private String message;
    private String coursEnPDF;
    private TypeCourDevoir type;// chemin du fichier PDF
    private int idProf;
    private int idModule;
    private boolean devoirDone;
    private int idEtudiant;
	public CourDevoir(int idCoursDevoirs, String message, String coursEnPDF,TypeCourDevoir type, int idProf, int idModule,
			boolean devoirDone, int idEtudiant) {
		super();
		this.idCoursDevoirs = idCoursDevoirs;
		this.message = message;
		this.coursEnPDF = coursEnPDF;
		this.type = type;
		this.idProf = idProf;
		this.idModule = idModule;
		this.devoirDone = devoirDone;
		this.idEtudiant = idEtudiant;
	}
	public int getIdCoursDevoirs() {
		return idCoursDevoirs;
	}
	public void setIdCoursDevoirs(int idCoursDevoirs) {
		this.idCoursDevoirs = idCoursDevoirs;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCoursEnPDF() {
		return coursEnPDF;
	}
	public void setCoursEnPDF(String coursEnPDF) {
		this.coursEnPDF = coursEnPDF;
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
	public boolean isDevoirDone() {
		return devoirDone;
	}
	public void setDevoirDone(boolean devoirDone) {
		this.devoirDone = devoirDone;
	}
	public int getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public TypeCourDevoir getType() {
		return type;
	}
	public void setType(TypeCourDevoir type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "CourDevoir [idCoursDevoirs=" + idCoursDevoirs + ", message=" + message + ", coursEnPDF=" + coursEnPDF
				+ ", idProf=" + idProf + ", idModule=" + idModule + ", devoirDone=" + devoirDone + ", idEtudiant="
				+ idEtudiant + ", type=" + type + "]";
	} 
    
    
    
}
