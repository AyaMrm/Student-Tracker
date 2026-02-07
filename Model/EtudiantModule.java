package Model;
public class EtudiantModule {
	private int idEtudiant;
    private int idModule;
	
    public EtudiantModule(int idEtudiant, int idModule) {
		super();
		this.idEtudiant = idEtudiant;
		this.idModule = idModule;
	}

	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public int getIdModule() {
		return idModule;
	}

	public void setIdModule(int idModule) {
		this.idModule = idModule;
	}

	@Override
	public String toString() {
		return "EtudiantModule [idEtudiant=" + idEtudiant + ", idModule=" + idModule + "]";
	}

    
}