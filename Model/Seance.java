package Model;
import java.time.LocalTime;

public class Seance{
    private int idSeance;
    private LocalTime debutSeance;
    private LocalTime finSeance;
    private int idModule;
    private int idProf;
    private String salle ;
    private int idJour;
    
    public Seance(int idSeance, LocalTime debutSeance, LocalTime finSeance, int idModule, int idProf, String salle,int idJour){
        this.idSeance = idSeance;
        this.debutSeance = debutSeance;
        this.finSeance = finSeance;
        this.idModule = idModule;
        this.idProf = idProf;
        this.salle = salle;
        this.idJour = idJour;
            }

    public int getIdSeance() {
        return idSeance;
    }

    public LocalTime getDebutSeance() {
        return debutSeance;
    }

    public LocalTime getFinSeance() {
        return finSeance;
    }

    public int getIdModule() {
        return idModule;
    }

    public int getIdProf() {
        return idProf;
    }
    public String getSalle() {
		return salle;
	}

    public int getIdJour() {
        return idJour;
    }

    public void setIdSeance(int idSeance) {
        this.idSeance = idSeance;
    }

    public void setDebutSeance(LocalTime debutSeance) {
        this.debutSeance = debutSeance;
    }

    public void setFinSeance(LocalTime finSeance) {
        this.finSeance = finSeance;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public void setSalle(String salle) {
		this.salle = salle;
	}
    
    public void setIdJour(int idJour) {
        this.idJour = idJour;
    }
    

	@Override
	public String toString() {
		return "Seance [idSeance=" + idSeance + ", debutSeance=" + debutSeance + ", finSeance=" + finSeance
				+ ", idModule=" + idModule + ", idProf=" + idProf + ", idJour=" + idJour + ", salle=" + salle + "]";
	}

	
    
}