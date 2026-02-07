package Model;
public class ProfModule {
	 private int idProf;
	 private int idModule;
	
	 public ProfModule(int idProf, int idModule) {
		super();
		this.idProf = idProf;
		this.idModule = idModule;
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
	@Override
	public String toString() {
		return "ProfModule [idProf=" + idProf + ", idModule=" + idModule + "]";
	}
	 
	 
	 
}